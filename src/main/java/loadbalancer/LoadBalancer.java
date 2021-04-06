package loadbalancer;

public interface LoadBalancer {
    void addServer(Server server, int weight);
    Server getServer(String clientIp);
}