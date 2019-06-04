import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;


public class ShowInstances {

    public static void main (String[] args) {


        AmazonEC2 ec2 = new GetEc2Client().getClient();

        boolean done = false;
        DescribeInstancesRequest request = new DescribeInstancesRequest();

        while(!done) {
            DescribeInstancesResult response = ec2.describeInstances(request);

            for(Reservation reservation : response.getReservations()) {
                for(Instance instance : reservation.getInstances()) {

                    String publicIP = ec2.describeInstances(new DescribeInstancesRequest()
                            .withInstanceIds(instance.getInstanceId()))
                            .getReservations()
                            .stream()
                            .map(Reservation::getInstances)
                            .flatMap(List::stream)
                            .findFirst()
                            .map(Instance::getPublicIpAddress)
                            .orElse(null);

                    System.out.printf(
                            "Found instance with id %s, " +
                                    "AMI %s, " +
                                    "type %s, " +
                                    "state %s " +
                                    "- IP address %s " +
                                    "and monitoring state %s",
                            instance.getInstanceId(),
                            instance.getImageId(),
                            instance.getInstanceType(),
                            instance.getState().getName(),
                            publicIP,
                            instance.getMonitoring().getState());
                }

                System.out.println("");
            }

            request.setNextToken(response.getNextToken());

            if(response.getNextToken() == null) {
                done = true;
            }
        }
    }

}
