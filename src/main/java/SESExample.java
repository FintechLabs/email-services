import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.*;

import java.io.IOException;

public class SESExample {

    private static final String FROM = "Stripe<stripe_hr@abc.com>";

    private static final String TO = "";

    private static final String SUBJECT = "Amazon SES test (AWS SDK for Java)";

    private static final String HTMLBODY = "<h1>Amazon SES test (AWS SDK for Java)</h1>"
            + "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
            + "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>"
            + "AWS SDK for Java</a>";

    private static final String TEXTBODY = "This email was sent through Amazon SES "
            + "using the AWS SDK for Java.";

    public static void main(String[] args) throws IOException {

        try {
            AmazonSimpleEmailService client = new AmazonSimpleEmailServiceClient(new BasicAWSCredentials("", ""))
                    .withRegion(Regions.US_WEST_2);
            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(
                            new Destination().withToAddresses(TO))
                    .withMessage(new Message()
                            .withBody(new Body()
                                    .withHtml(new Content()
                                            .withCharset("UTF-8").withData(HTMLBODY))
                                    .withText(new Content()
                                            .withCharset("UTF-8").withData(TEXTBODY)))
                            .withSubject(new Content()
                                    .withCharset("UTF-8").withData(SUBJECT)))
                    .withSource(FROM);
            client.sendEmail(request);
            System.out.println("Email sent!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("The email was not sent. Error message: "
                    + ex.getMessage());
        }
    }

}
