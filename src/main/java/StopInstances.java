import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.StopInstancesRequest;


public class StopInstances {

    public static void main(String[] args) throws IOException {


        System.out.print("Enter your instance id: ");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String instanceId = reader.readLine();


        AmazonEC2 ec2 = new GetEc2Client().getClient();

        StopInstancesRequest stopRequest = new StopInstancesRequest()
                .withInstanceIds(instanceId);

        ec2.stopInstances(stopRequest);

    }

}
