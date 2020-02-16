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

    public void writeFile(String kurs,String dato, int pris) throws IOException {

        DataOutputStream ut = new DataOutputStream(new BufferedOutputStream(this.output));
        ut.writeUTF(kurs);
        ut.writeUTF(dato);
        ut.writeInt(pris);
        ut.flush();

    }

    public void readFile(String fileName) {
        try {
            FileInputStream input = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(new BufferedInputStream(input));
            System.out.println("Kurs-tittel\t\tDato\t\tInntekt");
            System.out.println("-".repeat(40));
            while (true) {
                System.out.println(in.readUTF()+"\t"+in.readUTF()+"\t"+in.readInt());
            }
        } catch (EOFException e) {
            System.out.println("--- slutt på filen ---");

        } catch (IOException e) {
            System.out.println("Noe gikk galt: " + e.getMessage());
        }

    }


}
