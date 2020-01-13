package no.itfakultetet.java;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {

    public Http() {

    }

    public void getRequest(String uri) throws IOException, InterruptedException, URISyntaxException {

        HttpClient client = HttpClient
                .newBuilder()
                .build();

        HttpRequest request = HttpRequest
                .newBuilder(new URI(uri))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());

    }





}
