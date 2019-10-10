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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
            System.out.println("3. Lag html");

            Integer valgtTall = sc2.nextInt();

            switch (valgtTall) {
                case 1:
                    lagPdf(data);
                    break;
                case 2:
                    lagExcel(data);
                    break;
                case 3:
                    lagHtml(data);
                    break;
                default:
                    System.out.println("Velg et tall");
                    break;
            }
            i = 0;
            rs.close();
            st.close();
        } catch (SQLException | DocumentException e) {
            System.out.println("Klarte ikke å hente data, fordi: " + e.getMessage());
            e.printStackTrace();
        }

    } // end

    public void lagPdf(HashMap<String, String> data) throws DocumentException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(this.navn + "_data.pdf"));
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);

        document.add(new Paragraph("Bedrifter fra enhetsregisteret", font));
        document.add(new Paragraph(" ", font));

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

        // Lag rad 1 med kolonne-overskrifter
        Row headerRow = sheet.createRow(0);
        Cell heading1 = headerRow.createCell(0);
        heading1.setCellValue("Organisasjonsnummer");
        Cell heading2 = headerRow.createCell(1);
        heading2.setCellValue("Navn");

        // Lag resten av radene

        int a = 1;
        for (Map.Entry celle : data.entrySet()) {
            Row dataRad = sheet.createRow(a++);
            dataRad.createCell(0).setCellValue((String) celle.getKey());
            dataRad.createCell(1).setCellValue((String) celle.getValue());
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream(this.navn + "_data.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Closing the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        data.clear();
        System.out.println("Lagret filen " + this.navn + "_data.xsl");
    }

    public void lagHtml(HashMap<String, String> data) {
        System.out.println("Lagret filen " + this.data + "_data.html");
    }


} // end class
