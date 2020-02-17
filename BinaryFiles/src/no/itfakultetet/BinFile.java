package no.itfakultetet;

import java.io.*;

public class BinFile {

    public FileOutputStream output;

    public BinFile(String fileName) {

        try {
            FileOutputStream output = new FileOutputStream(fileName, true);
            this.output = output;
        } catch (IOException e) {
            System.out.println("Noe gikk galt: " + e.getMessage());
        }

    }

    public void writeFile(String tittel,String startDato, String sluttDato,int deltakere,int fakturert) throws IOException {

        DataOutputStream ut = new DataOutputStream(new BufferedOutputStream(this.output));
        ut.writeUTF(tittel);
        ut.writeUTF(startDato);
        ut.writeUTF(sluttDato);
        ut.writeInt(deltakere);
        ut.writeInt(fakturert);
        ut.flush();

    }

    public void readFile(String fileName) {
        String tittel, start, slutt;
        int deltakere, fakturert, sum = 0 ;
        try {
            FileInputStream input = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(new BufferedInputStream(input));
            System.out.printf("%-40s %-12s %-12s %8s %12s","Kurs-tittel","Start","Slutt","Deltakere","Fakturert");
            System.out.println();
            System.out.println("-".repeat(90));

            while (true) {
                tittel = in.readUTF();
                start = in.readUTF();
                slutt = in.readUTF();
                deltakere = in.readInt();
                fakturert = in.readInt();
                sum+= fakturert;

                System.out.printf("%-40s %-12s %-12s %8d %12d",tittel,start,slutt,deltakere,fakturert);
                System.out.println();

            }
        } catch (EOFException e) {
            System.out.println("-".repeat(90));
            System.out.printf("%80s %7d","SUM",sum);
            System.out.println();

        } catch (IOException e) {
            System.out.println("Noe gikk galt: " + e.getMessage());
        }

    }


}
