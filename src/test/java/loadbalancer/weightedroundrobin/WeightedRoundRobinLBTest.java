package loadbalancer.weightedroundrobin;

import loadbalancer.LoadBalancer;
import loadbalancer.Server;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class WeightedRoundRobinLBTest {

    LoadBalancer weightedRoundRobinLB;

    @BeforeMethod
    public void setup() {
        weightedRoundRobinLB = new WeightedRoundRobinLB();
    }

    public void testGetServer_TwoWeightedServers_ReturnWeightedServers() {
        Server server1 = new Server("0.0.0.1");
        Server server2 = new Server("0.0.0.2");
        weightedRoundRobinLB.addServer(server1, 2);
        weightedRoundRobinLB.addServer(server2, 1);

        Assert.assertEquals(weightedRoundRobinLB.getServer("0.0.1.0"), server1);
        Assert.assertEquals(weightedRoundRobinLB.getServer("0.0.2.0"), server1);
        Assert.assertEquals(weightedRoundRobinLB.getServer("0.0.3.0"), server2);
        Assert.assertEquals(weightedRoundRobinLB.getServer("0.0.4.0"), server1);
    }

}
