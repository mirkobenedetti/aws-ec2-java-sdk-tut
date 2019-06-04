import java.util.Collections;
import java.util.List;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.CreateSecurityGroupResult;
import com.amazonaws.services.ec2.model.IpPermission;


public class CreateSecurityGroup {

    public static void main(String[] args) throws Exception {


        AmazonEC2 ec2 = new GetEc2Client().getClient();


        try {
            CreateSecurityGroupRequest securityGroupRequest = new CreateSecurityGroupRequest(
                    "TutorialSecurityGroup", "Tutorial Security Group");
            CreateSecurityGroupResult result = ec2
                    .createSecurityGroup(securityGroupRequest);
            System.out.println(String.format("Security group created: [%s]",
                    result.getGroupId()));
        } catch (AmazonServiceException ase) {
            System.out.println(ase.getMessage());
        }


        String ipAddr = new GetMyIp().getIp();
        List<String> ipRanges = Collections.singletonList(ipAddr);


        IpPermission ipPermission = new IpPermission()
                .withIpProtocol("tcp")
                .withFromPort(new Integer(22))
                .withToPort(new Integer(22))
                .withIpRanges(ipRanges);

        List<IpPermission> ipPermissions = Collections.singletonList(ipPermission);

        try {
            AuthorizeSecurityGroupIngressRequest ingressRequest = new AuthorizeSecurityGroupIngressRequest(
                    "TutorialSecurityGroup", ipPermissions);
            ec2.authorizeSecurityGroupIngress(ingressRequest);
            System.out.println(String.format("Ingress port authroized: [%s]",
                    ipPermissions.toString()));
        } catch (AmazonServiceException ase) {
            System.out.println(ase.getMessage());
        }
    }

}