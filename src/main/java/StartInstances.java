import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.StartInstancesRequest;


public class StartInstances {

    public static void main(String[] args) throws IOException {


        System.out.print("Enter your instance id: ");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String instanceId = reader.readLine();


        AmazonEC2 ec2 = new GetEc2Client().getClient();

        StartInstancesRequest request = new StartInstancesRequest()
                .withInstanceIds(instanceId);

        ec2.startInstances(request);

    }

}
