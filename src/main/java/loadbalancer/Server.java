package loadbalancer;

public class Server {
    String ipAddress;

    public Server(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }
}
