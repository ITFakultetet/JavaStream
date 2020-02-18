package no.itfakultetet;

import java.io.*;
import java.time.LocalDate;

public class BinFile {
    private String fileName;

    public BinFile(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile(String tittel, String startDato, String sluttDato, int deltakere, int fakturert) throws IOException {

        class AppendableObjectOutputStream extends ObjectOutputStream {
            public AppendableObjectOutputStream(OutputStream out) throws IOException {
                super(out);
            }

            @Override
            public void writeStreamHeader() throws IOException {
                // do not write a header
            }
        }


        try {

            if (new File(fileName).isFile()) {
                FileOutputStream output = new FileOutputStream(fileName, true);
                AppendableObjectOutputStream ut = new AppendableObjectOutputStream(new BufferedOutputStream(output));
                ut.writeUTF(tittel);
                ut.writeObject(LocalDate.parse(startDato));
                ut.writeObject(LocalDate.parse(sluttDato));
                ut.writeInt(deltakere);
                ut.writeInt(fakturert);
                ut.flush();

            } else {//if file doesn't exist
                FileOutputStream output = new FileOutputStream(fileName);
                ObjectOutputStream ut = new ObjectOutputStream(new BufferedOutputStream(output));
                ut.writeUTF(tittel);
                ut.writeObject(LocalDate.parse(startDato));
                ut.writeObject(LocalDate.parse(sluttDato));
                ut.writeInt(deltakere);
                ut.writeInt(fakturert);
                ut.flush();

            }


        } catch (IOException e) {
            System.out.println("Noe gikk galt ved åpning av datafil for sskriving: " + e.getMessage());
        }

    }

    public void readFile(String fileName) {
        String tittel;
        java.time.LocalDate start, slutt;
        int deltakere, fakturert, sum = 0;
        try {
            FileInputStream input = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(input));
            System.out.printf("%-40s %-12s %-12s %8s %12s", "Kurs-tittel", "Start", "Slutt", "Deltakere", "Fakturert");
            System.out.println();
            System.out.println("-".repeat(90));

            while (true) {
                tittel = in.readUTF();
                start = (java.time.LocalDate) in.readObject();
                slutt = (java.time.LocalDate) in.readObject();
                deltakere = in.readInt();
                fakturert = in.readInt();
                sum += fakturert;

                System.out.printf("%-40s %-12s %-12s %8d %12d", tittel, start, slutt, deltakere, fakturert);
                System.out.println();

            }
        } catch (EOFException e) {
            System.out.println("-".repeat(90));
            System.out.printf("%80s %7d", "SUM", sum);
            System.out.println();

        } catch (IOException e) {
            System.out.println("Noe gikk galt ved lesing av datafil: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
