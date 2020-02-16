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

    public void writeFile(String text) throws IOException {

        DataOutputStream ut = new DataOutputStream(new BufferedOutputStream(this.output));
        ut.writeUTF(text);
        ut.flush();

    }

    public void readFile(String fileName) {
        try {
            FileInputStream input = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(new BufferedInputStream(input));
            while (true) {
                System.out.println(in.readUTF());
            }
        } catch (EOFException e) {
            System.out.println("--- slutt på filen ---");

        } catch (IOException e) {
            System.out.println("Noe gikk galt: " + e.getMessage());
        }

    }


}
