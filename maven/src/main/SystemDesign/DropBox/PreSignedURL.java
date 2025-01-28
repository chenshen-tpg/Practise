
package SystemDesign.DropBox.PresignedURL;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
import java.time.Duration;

public class PreSignedURL {


    public class PresignedUrlExample {

        public static void main(String[] args) {
            // S3 bucket and object details
            String bucketName = "your-bucket-name";
            String objectKey = "your-object-key";
            // Generate a presigned URL
            String presignedUrl = generatePresignedUrl(bucketName, objectKey);
            System.out.println("Presigned URL: " + presignedUrl);
        }
        public static String generatePresignedUrl(String bucketName, String objectKey) {
            // Create an S3Presigner instance
            S3Presigner presigner = S3Presigner.builder()
                    .region(Region.US_EAST_1) // Replace with your bucket's region
                    .credentialsProvider(ProfileCredentialsProvider.create()) // Use default profile
                    .build();

            // Create a GetObjectRequest
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();
            // Create a GetObjectPresignRequest

            GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(10)) // URL expires in 10 minutes
                    .getObjectRequest(getObjectRequest)
                    .build();
            // Generate the presigned URL
            PresignedGetObjectRequest presignedRequest = presigner.presignGetObject(presignRequest);
            String presignedUrl = presignedRequest.url().toString();
            // Close the presigner
            presigner.close();
            return presignedUrl;
        }
    }
}
