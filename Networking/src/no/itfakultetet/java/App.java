package no.itfakultetet.java;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {

    public static void main(String[] args) {

Http test = new Http();

        try {
            test.getRequest("https://web.itfakultetet.no");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
