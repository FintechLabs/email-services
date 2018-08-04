import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.data.model.message.Message;
import com.wildbit.java.postmark.client.data.model.message.MessageResponse;

public class Postmark {

    private static final String API_KEY = "";

    private static final String FROM = "Google<google_careers@abc.com>";

    private static final String TO = "";

    private static final String SUBJECT = "Amazon SES test (AWS SDK for Java)";

    private static final String HTMLBODY = "<h1>Amazon SES test (AWS SDK for Java)</h1>"
            + "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
            + "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>"
            + "AWS SDK for Java</a>";

    private static final String TEXTBODY = "This email was sent through Amazon SES "
            + "using the AWS SDK for Java.";

    public static void main(String[] args) {
        try {
            ApiClient client = com.wildbit.java.postmark.Postmark.getApiClient(API_KEY);
            Message message = new Message(FROM, TO, SUBJECT, HTMLBODY);
            MessageResponse response = client.deliverMessage(message);
            System.out.println("**********      Response        =====>>>>>      " + response.getMessageId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
