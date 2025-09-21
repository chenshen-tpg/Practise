package ToolForWorks;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Downloading {

        public static void main(String[] args) throws IOException {
            String[] baseUrls = {
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-black-01-l.webp",
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-white-01-l.webp ",
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-mist-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-lavender-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-sage-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-black-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-white-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-mist-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-lavender-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17/iphone-17-sage-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro/iphone-17-pro-silver-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro/iphone-17-pro-cosmic-orange-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro/iphone-17-pro-deep-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro/iphone-17-pro-silver-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro/iphone-17-pro-cosmic-orange-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro/iphone-17-pro-deep-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro/iphone-17-pro-silver-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro/iphone-17-pro-cosmic-orange-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro/iphone-17-pro-deep-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-silver-01-l.webp" ,
                    " www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-cosmic-orange-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-deep-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-silver-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-cosmic-orange-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-deep-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-silver-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-cosmic-orange-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-deep-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-silver-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-cosmic-orange-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-17-pro-max/iphone-17-pro-max-deep-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-space-black-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-cloud-white-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-light-gold-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-sky-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-space-black-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-cloud-white-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-light-gold-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-sky-blue-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-space-black-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-cloud-white-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-light-gold-01-l.webp " ,
                    "www.vodafone.com.au/images/devices/apple/iphone-air/iphone-air-sky-blue-01-l.webp" };
            String targetDir = "/Users/chen.shen/IdeaProjects/W001094_frontier_frontier-pop/src/main/webapp/images/mobility/iPhone17";
            Files.createDirectories(Paths.get(targetDir));
            for (String baseUrl : baseUrls) {
                baseUrl = baseUrl.trim();
                for (int i = 1; i <= 4; i++) {
                    String num = String.format("%02d", i);
                    String urlStr = baseUrl.replace("01", num);
                    if (!urlStr.startsWith("http")) {
                        urlStr = "https://" + urlStr;
                    }
                    URL url = new URL(urlStr);
                    String fileName = Paths.get(url.getPath()).getFileName().toString();
                    if (Files.exists(Paths.get(targetDir, fileName))) {
                        System.out.println("Skipped (exists): " + fileName);
                        continue;
                    }
                    try (InputStream in = url.openStream()) {
                        Files.copy(in, Paths.get(targetDir, fileName), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Downloaded: " + fileName);
                    } catch (IOException e) {
                        System.out.println("Failed to download: " + fileName + " (" + e.getMessage() + ")");
                    }
                }
            }
        }
}
