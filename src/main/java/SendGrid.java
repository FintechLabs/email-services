public class SendGrid {

    private static final String ACCESS_KEY = "";

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
            com.sendgrid.SendGrid sendgrid = new com.sendgrid.SendGrid(ACCESS_KEY);
            com.sendgrid.SendGrid.Email email = new com.sendgrid.SendGrid.Email();
            email.addTo(TO);
            email.setFrom(FROM);
            email.setSubject(SUBJECT);
            email.setHtml(HTMLBODY);
            com.sendgrid.SendGrid.Response response = sendgrid.send(email);
            System.out.println("Response    ====>>>>        " + response.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
