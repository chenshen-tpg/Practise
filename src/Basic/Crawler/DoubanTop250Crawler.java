package Basic.Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class DoubanTop250Crawler {
    public static void main(String[] args) {
        String baseUrl = "https://movie.douban.com/top250";

        try {
            // Start crawling from the first page
            crawlPage(baseUrl);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crawlPage(String url) throws IOException {
        // Connect to the URL and get the document
        Document doc = Jsoup.connect(url).get();

        // Extracting movie names and scores
        Elements movieElements = doc.select("div.hd");
        for (Element movieElement : movieElements) {
            Element titleElement = movieElement.selectFirst("span.title");
            String movieName = titleElement.text();

            Element ratingElement = movieElement.nextElementSibling().selectFirst("span.rating_num");
            String movieScore = ratingElement.text();

            System.out.println("Movie: " + movieName + " - Score: " + movieScore);
        }

        // Check if there is a next page
        Element nextPageElement = doc.selectFirst("span.next > a");
        if (nextPageElement != null) {
            // Get the URL of the next page
            String nextPageUrl = nextPageElement.absUrl("href");
//            System.out.println("Next Page URL: " + nextPageUrl);

            // Recursively crawl the next page
            crawlPage(nextPageUrl);
        }
    }
}
