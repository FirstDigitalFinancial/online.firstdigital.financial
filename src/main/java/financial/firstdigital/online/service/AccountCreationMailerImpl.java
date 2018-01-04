package financial.firstdigital.online.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import financial.firstdigital.online.model.EmailDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class AccountCreationMailerImpl implements AccountCreationMailer {

    @Value("${aws.region}")
    private String AWS_REGION;

    @Value("${mail.address.noreply}")
    private String FROM;

    @Value("${mail.verification.subject}")
    private String SUBJECT;

    @Value("${mail.verification.body.text}")
    private String textFile;
    private String TEXTBODY;

    @Value("${mail.verification.body.html}")
    private String htmlFile;
    private String HTMLBODY;

    public void sendVerificationEmail(EmailDetail emailDetail) {

        TEXTBODY = readBody(textFile);
        HTMLBODY = readBody(htmlFile);

        try {
            AmazonSimpleEmailService client =
                    AmazonSimpleEmailServiceClientBuilder.standard()
                            .withRegion(Regions.valueOf(AWS_REGION)).build();

            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(
                            new Destination().withToAddresses(emailDetail.getEmailAddress()))
                    .withMessage(new Message()
                            .withBody(new Body()
                                    .withHtml(new Content()
                                            .withCharset("UTF-8").withData(HTMLBODY.replaceAll("VERIFICATION_KEY", emailDetail.getVerificationKey())))
                                    .withText(new Content()
                                            .withCharset("UTF-8").withData(TEXTBODY.replaceAll("VERIFICATION_KEY", emailDetail.getVerificationKey()))))
                            .withSubject(new Content()
                                    .withCharset("UTF-8").withData(SUBJECT)))
                    .withSource(FROM);

            client.sendEmail(request);
        } catch (Exception ex) {
            System.out.println("The email was not sent. Error message: "
                    + ex.getMessage());
        }
    }

    public String readBody(String inputFile){

        StringBuffer buffer = new StringBuffer("");

        try{
            String line="";
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream istream = classloader.getResourceAsStream(inputFile);

            BufferedReader br = new BufferedReader(new InputStreamReader(istream));

            while ((line = br.readLine()) != null)   {
                buffer.append(line);
            }

            istream.close();
        } catch (Exception ex){
            System.err.println("Unable to read message body. Error message: " + ex.getMessage());
        }

        return buffer.toString();
    }

}
