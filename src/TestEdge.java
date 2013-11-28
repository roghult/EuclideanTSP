import org.junit.Assert;
import org.junit.Test;


public class TestEdge {
	
	private static final double DELTA = 0.000001;

	@Test
	public void testDistance() {
		Edge e1 = new Edge(0, 0, 0, 1, 0, 1);
		Assert.assertEquals(e1.getDistance(), 1, DELTA);
		Edge e2 = new Edge(0, 0, 0, 0, 0, 1);
		Assert.assertEquals(e2.getDistance(), 0, DELTA);
		Edge e3 = new Edge(2, -1, -2, 2, 0, 1);
		Assert.assertEquals(e3.getDistance(), 5, DELTA);
		Edge e4 = new Edge(3, 5, 1, 2, 0, 1);
		Assert.assertEquals(e4.getDistance(), 4, DELTA);
		Edge e5 = new Edge(3, 5, 1, 1, 0, 1);
		Assert.assertEquals(e5.getDistance(), 4, DELTA);
	}

}
