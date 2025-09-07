package Learning.Specific.C.SystemDesign.NotificationService;


/***
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

public class Controller {

    // Assume you have a simple NotificationRequest DTO class
    class NotificationRequest {
        private String userId;
        private String message;
        private String channel; // e.g., "email", "sms"
        // Getters and setters
        // ...
    }

    @RestController
    public class NotificationController {

        @Autowired
        private MessageQueueProducer producer; // Our Kafka producer

        @PostMapping("/send-notification")
        public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
            // Simple validation
            if (request.getUserId() == null || request.getMessage() == null) {
                return ResponseEntity.badRequest().body("User ID and message are required.");
            }

            System.out.println("Received request for user " + request.getUserId());

            // Asynchronously publish the message to Kafka
            producer.publishNotification(request);

            return ResponseEntity.ok("Notification request accepted and queued.");
        }
    }
}
 ***/