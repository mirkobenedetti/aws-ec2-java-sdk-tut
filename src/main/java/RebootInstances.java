import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.RebootInstancesRequest;
import com.amazonaws.services.ec2.model.RebootInstancesResult;


public class RebootInstances {

    public static void main(String[] args) throws IOException {


        System.out.print("Enter your instance id: ");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String instanceId = reader.readLine();


        AmazonEC2 ec2 = new GetEc2Client().getClient();

        RebootInstancesRequest request = new RebootInstancesRequest()
                .withInstanceIds(instanceId);

        RebootInstancesResult response =
                ec2.rebootInstances(request);

    }

}
