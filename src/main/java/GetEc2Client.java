import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;


public class GetEc2Client {


    private AWSCredentials credentials;


    public GetEc2Client() {

        try {
            this.credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials, please configure your AWS CLI.", e);
        }

    }


    public AmazonEC2 getClient() {

        return AmazonEC2ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(this.credentials))
                .withRegion("us-west-2")
                .build();

    }

}
