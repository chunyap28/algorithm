package loadbalancer.weightedroundrobin;

import loadbalancer.Server;
import loadbalancer.roundrobin.RoundRobinLB;

public class WeightedRoundRobinLB extends RoundRobinLB {

    @Override
    public void addServer(Server server, int weight) {
        for(int i =0; i < weight; i++ ) {
            servers.add(server);
        }
    }
}
