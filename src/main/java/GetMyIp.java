import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GetMyIp {

    private String ipAddress;

    public GetMyIp() throws Exception{

        this.ipAddress = "0.0.0.0/0";

        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));

        this.ipAddress = in.readLine() + "/32";

    }

    public String getIp() {
        return this.ipAddress;
    }

}
