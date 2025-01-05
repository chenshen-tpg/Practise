package Basic.Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class BaiduTiebaCrawler {
    public static void main(String[] args) {
        String url = "https://tieba.baidu.com/p/8982510215?frwh=index#";

        try {
            // Crawl the first page
            crawlPage(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crawlPage(String url) throws IOException {
        // Connect to the URL and get the document
        Document doc = Jsoup.connect(url).get();

        // Extracting post title
        Element postTitleElement = doc.selectFirst(".core_title_txt");
        String postTitle = postTitleElement.text();
        System.out.println("Post Title: " + postTitle);

        // Extracting post content
        Element postContentElement = doc.selectFirst(".d_post_content");
        String postContent = postContentElement.text();
        System.out.println("Post Content: " + postContent);

        // Extracting comments
        Elements commentElements = doc.select(".l_post");
        System.out.println("Comments:");
        for (Element commentElement : commentElements) {
            // Extracting author's name
            Element authorElement = commentElement.selectFirst(".d_name");
            String authorName = authorElement.text();

            // Extracting comment content
            Element commentContentElement = commentElement.selectFirst(".d_post_content");
            String commentContent = commentContentElement.text();

            System.out.println("Author: " + authorName);
            System.out.println("Comment: " + commentContent);
        }

        // Check if there is a next page
        Element nextPageElement = doc.selectFirst(".next");
        if (nextPageElement != null) {
            // Get the URL of the next page
            String nextPageUrl = nextPageElement.attr("href");
            nextPageUrl = nextPageUrl.startsWith("/") ? "https://tieba.baidu.com" + nextPageUrl : nextPageUrl;
            System.out.println("Next Page URL: " + nextPageUrl);

            // Crawl the next page recursively
            crawlPage(nextPageUrl);
        }
    }
}
