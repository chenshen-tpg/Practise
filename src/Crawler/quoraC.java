package Crawler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import static java.net.http.HttpClient.newHttpClient;

public class quoraC {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url =
                "https://www.quora.com/What-are-the-times-you-are-most-inspired-most-motivated-most-charged-up";

        HttpClient client = newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        JSONArray answers = json.getJSONArray("answers");
        for (int i = 0; i < answers.length(); i++) {
            JSONObject answer = answers.getJSONObject(i);
            String text = answer.getString("text");
            String author = answer.getString("author");
            System.out.println("Comment by " + author + ": ");
            System.out.println(text);
            System.out.println();
        }
    }
}
