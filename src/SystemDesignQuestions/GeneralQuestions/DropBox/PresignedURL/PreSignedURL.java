package SystemDesignQuestions.GeneralQuestions.DropBox.PresignedURL;

import software.amazon.awssdk.regions.Region;

import java.time.Duration;

public class PreSignedURL {
    public static void main(String[] args) {

    }
     /*** template
     "presignedUrl": "https://my-bucket.s3.us-west-2.amazonaws.com/my-object-key?
     X-Amz-Algorithm=AWS4-HMAC-SHA256&
     X-Amz-Credential=YOUR_CREDENTIALS&X-Amz-Date=20231010T000000Z&X-Amz
     -Expires=600&X-Amz-SignedHeaders=host&X-Amz-Signature=YOUR_SIGNATURE"
     ***/

    String bucketName = "my-bucket";
    String objectKey = "my-object-key";
    Region region = Region.US_WEST_2;
    Duration duration = Duration.ofMinutes(10);

    /***
     S3Presigner presigner = S3Presigner.builder()
     .region(region)
     .credentialsProvider(ProfileCredentialsProvider.create())
     .build();

     GetObjectRequest getObjectRequest = GetObjectRequest.builder()
     .bucket(bucketName)
     .key(objectKey)
     .build();

     GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder()
     .signatureDuration(duration)
     .getObjectRequest(getObjectRequest)
     .build();

     String presignedUrl = presigner.presignGetObject(getObjectPresignRequest).url().toString();
     presigner.close();
     ***/
}