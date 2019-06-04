import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.*;


public class LaunchInstances {

    public static void main(String[] args) {


        AmazonEC2 ec2 = new GetEc2Client().getClient();

        RunInstancesRequest runInstancesRequest = new RunInstancesRequest();

        runInstancesRequest.withImageId("ami-a9d09ed1")
                .withInstanceType(InstanceType.T1Micro)
                .withMinCount(1)
                .withMaxCount(1)
                .withKeyName("TutorialKeyName")
                .withSecurityGroups("TutorialSecurityGroup");

        RunInstancesResult result = ec2.runInstances(runInstancesRequest);

        System.out.println(result.toString());

    }

}
