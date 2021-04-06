package loadbalancer.roundrobin;

import loadbalancer.LoadBalancer;
import loadbalancer.Server;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class RoundRobinLBTest {

    private LoadBalancer roundRobinLB;

    @BeforeMethod
    public void setup() {
        roundRobinLB = new RoundRobinLB();
    }

    public void testGetServer_OnlyOneServer_GetSameServer() {
        Server server1 = new Server("0.0.0.0");
        roundRobinLB.addServer(server1, 1);

        Assert.assertEquals(roundRobinLB.getServer("0.0.1.0"), server1);
        Assert.assertEquals(roundRobinLB.getServer("0.0.2.0"), server1);
    }

    public void testGetServer_TwoServers_GetAlternateServer() {
        Server server1 = new Server("0.0.0.0");
        Server server2 = new Server("0.0.0.1");
        roundRobinLB.addServer(server1, 1);
        roundRobinLB.addServer(server2, 1);

        Assert.assertEquals(roundRobinLB.getServer("0.0.1.0"), server1);
        Assert.assertEquals(roundRobinLB.getServer("0.0.2.0"), server2);
        Assert.assertEquals(roundRobinLB.getServer("0.0.3.0"), server1);
    }

    public void testGetServer_NoServer_GetNull() {
        Assert.assertEquals(roundRobinLB.getServer("0.0.1.0"), null);
    }
}
