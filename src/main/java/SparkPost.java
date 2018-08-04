import com.sparkpost.Client;
import com.sparkpost.model.responses.Response;

public class SparkPost {

    private static final String ACCESS_KEY = "";

    private static final String FROM = "Google<google_hr@abc.in>";

    private static final String TO = "";

    private static final String SUBJECT = "Amazon SES test (AWS SDK for Java)";

    private static final String HTMLBODY = "<h1>Amazon SES test (AWS SDK for Java)</h1>"
            + "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
            + "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>"
            + "AWS SDK for Java</a>";

    private static final String TEXTBODY = "This email was sent through Amazon SES "
            + "using the AWS SDK for Java.";

    public static void main(String[] args) {
        Client sparkPost = new Client(ACCESS_KEY);
        try {
            Response response = sparkPost.sendMessage(FROM, TO, SUBJECT, TEXTBODY, HTMLBODY);
            System.out.println("Response    ====>>>>        " + response.getResponseMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
