import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.KeyPair;


public class CreateKeyPair {

    public static void main(String[] args) {


        AmazonEC2 ec2 = new GetEc2Client().getClient();

        CreateKeyPairRequest createKeyPairRequest = new CreateKeyPairRequest();
        createKeyPairRequest.withKeyName("TutorialKeyName");

        CreateKeyPairResult createKeyPairResult =
                ec2.createKeyPair(createKeyPairRequest);

        KeyPair keyPair = new KeyPair();
        keyPair = createKeyPairResult.getKeyPair();

        System.out.println(keyPair.getKeyMaterial());

    }

}
