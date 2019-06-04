import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;


public class TerminateInstances {

    public static void main(String[] args) throws IOException {


        System.out.print("Enter your instance id: ");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String instanceId = reader.readLine();


        AmazonEC2 ec2 = new GetEc2Client().getClient();

        TerminateInstancesRequest termianteRequest = new TerminateInstancesRequest()
                .withInstanceIds(instanceId);

        ec2.terminateInstances(termianteRequest);

    }

}
