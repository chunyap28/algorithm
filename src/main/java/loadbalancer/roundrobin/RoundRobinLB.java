package loadbalancer.roundrobin;

import loadbalancer.LoadBalancer;
import loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

public class RoundRobinLB implements LoadBalancer {

    protected List<Server> servers = new ArrayList<>();
    private static int pointer = 0;

    @Override
    public void addServer(Server server, int weight) {
        servers.add(server);
    }

    @Override
    public Server getServer(String clientIp) {
        if( servers.isEmpty() ) {
            return null;
        }

        Server server = servers.get(pointer);
        pointer = (pointer+1) % servers.size();
        return server;
    }
}
