package no.itfakultet;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Stream;

public class Data {

    private Connection conn;
    private int i = 0;
    private HashMap<String, String> data = new HashMap<>();
    private String navn;

    public Data() {

        String url = "jdbc:postgresql://noderia.com/brreg";
        Properties props = new Properties();
        props.setProperty("user", "kurs");
        props.setProperty("password", "kurs123");
        // props.setProperty("ssl","true");

        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            System.out.println("Klarte ikke å koble seg til databasen, fordi: " + e.getMessage());
        }


//       String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
//        Connection conn = DriverManager.getConnection(url);

    }

    public void getData(String navn) {

        this.navn = navn.stripTrailing();  // fjern mellomrom etter søkeordet
        System.out.println("Orgnummer\tNavn");
        System.out.println("----------------------------------------------");

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT orgnr, navn from enheter where navn ilike '" + navn + "%'");

            while (rs.next()) {
                System.out.println(rs.getString("orgnr") + "\t" + rs.getString("navn"));
                this.data.put(rs.getString("orgnr"), rs.getString("navn"));
                i++;
            }

            System.out.println("Antal bedrifter funnet: " + i);

            Scanner sc2 = new Scanner(System.in);
            System.out.println("1. Lag pdf");
            System.out.println("2. Lag Excel");
            System.out.println("3. Lag XML");
            System.out.println("4. Lag HTML");

            Integer valgtTall = sc2.nextInt();

            switch (valgtTall) {
                case 1:
                    lagPdf(data);
                    break;
                case 2:
                    lagExcel(data);
                    break;
                case 3:
                    lagXml(data);
                    break;
                case 4:
                    lagHtml(data);
                    break;
                default:
                    System.out.println("Velg 1, 2 eller 3");
                    break;
            }
            i = 0;
            rs.close();
            st.close();
        } catch (SQLException | DocumentException e) {
            System.out.println("Klarte ikke å hente data, fordi: " + e.getMessage());
            e.printStackTrace();
        }

    } // end getData

    public void lagPdf(HashMap<String, String> data) throws DocumentException {

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(this.navn + "_data.pdf"));
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }

        document.open();

        Font tittelFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, BaseColor.GREEN);

        document.add(new Paragraph("Bedrifter fra enhetsregisteret", tittelFont));
        document.add(new Paragraph(" ", tittelFont));

        PdfPTable table = new PdfPTable(2);

        Stream.of("Organisasjonsnummer", "Navn")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(1);
                    header.setFixedHeight(20.0f);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });

        for (Map.Entry celle : data.entrySet()) {
            table.addCell((String) celle.getKey());
            table.addCell((String) celle.getValue());
        }

        document.add(table);
        document.close();
        data.clear();
        System.out.println("Lagret filen " + this.navn + "_data.pdf");
    }


    public void lagExcel(HashMap<String, String> data) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Bedrifter");

        // Lag rad 0 med kolonne-overskrifter
        Row headerRow = sheet.createRow(0);
        Cell heading1 = headerRow.createCell(0);
        heading1.setCellValue("Organisasjonsnummer");
        Cell heading2 = headerRow.createCell(1);
        heading2.setCellValue("Navn");

        // Lag resten av radene med innholdet fra HashMap data

        int a = 1;
        for (Map.Entry celle : data.entrySet()) {
            Row dataRad = sheet.createRow(a++);
            dataRad.createCell(0).setCellValue((String) celle.getKey());
            dataRad.createCell(1).setCellValue((String) celle.getValue());
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        // Skriv til fil, lukk ressursene og gi melding til brukeren
        try (FileOutputStream fileOut = new FileOutputStream(this.navn + "_data.xlsx")) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Lagret filen " + this.navn + "_data.xslx");
        } catch (IOException e) {
            System.out.println("Filen ble ikke lagret.");
            e.printStackTrace();
        }

        data.clear();

    } // end lagExcel

    public void lagXml(HashMap<String, String> data) {

        StringBuffer xmlDoc = new StringBuffer();

        xmlDoc.append("<bedrifter>\n");

        for (Map.Entry celle : data.entrySet()) {
            xmlDoc.append("<bedrift orgnummer=\""+celle.getKey()+"\" navn=\""+celle.getValue()+"\" />\n");
        }

        xmlDoc.append("</bedrifter>\n");

        try (FileWriter xmlFil = new FileWriter(this.navn + "_data.xml")) {
            xmlFil.write(String.valueOf(xmlDoc));
            System.out.println("Lagret filen " + this.navn + "_data.xml");
        } catch (IOException e) {
            System.out.println("Filen ble ikke lagret.");
            e.printStackTrace();
        }

    } // end lagXml


    public void lagHtml(HashMap<String, String> data) {

        StringBuffer htmlDoc = new StringBuffer();

        htmlDoc.append("<html>\n");
        htmlDoc.append("<title>Bedrifter fra Brreg</title>\n");
        htmlDoc.append("<meta charset=utf8 />\n");

        htmlDoc.append("<body>\n");
        htmlDoc.append("<h1>Bedrifter fra Brønnøysundregisteret</h1>\n");

        htmlDoc.append("<table style=\"border:solid black 1px; background-color:#efefef;\">\n");
        htmlDoc.append("<tr><th>Organisasjonsnummer</th><th>Navn</th>\n");

        for (Map.Entry celle : data.entrySet()) {
            htmlDoc.append("<tr><td>"+celle.getKey()+"</td><td>"+celle.getValue()+"</td></tr>\n");
        }

        htmlDoc.append("</table>\n");
        htmlDoc.append("</body>\n");
        htmlDoc.append("</html>\n");

        try (FileWriter htmlFil = new FileWriter(this.navn + "_data.html")) {
            htmlFil.write(String.valueOf(htmlDoc));
            System.out.println("Lagret filen " + this.navn + "_data.html");
        } catch (IOException e) {
            System.out.println("Filen ble ikke lagret.");
            e.printStackTrace();
        }

    } // end lagXml


} // end class
