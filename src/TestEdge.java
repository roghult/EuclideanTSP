import org.junit.Assert;
import org.junit.Test;

public class TestEdge {

	private static final double DELTA = 0.000001;

	@Test
	public void testDistance() {
		Node n1 = new Node(0, 0, 0);
		Node n2 = new Node(0, 1, 1);
		Edge e1 = new Edge(n1, n2);
		Assert.assertEquals(e1.getDistance(), 1, DELTA);

		n1 = new Node(0, 0, 0);
		n2 = new Node(0, 0, 1);
		Edge e2 = new Edge(n1, n2);
		Assert.assertEquals(e2.getDistance(), 0, DELTA);

		n1 = new Node(2, -1, 0);
		n2 = new Node(-2, 2, 1);
		Edge e3 = new Edge(n1, n2);
		Assert.assertEquals(e3.getDistance(), 5, DELTA);

		n1 = new Node(3, 5, 0);
		n2 = new Node(1, 2, 1);
		Edge e4 = new Edge(n1, n2);
		Assert.assertEquals(e4.getDistance(), 4, DELTA);

		n1 = new Node(3, 5, 0);
		n2 = new Node(1, 1, 1);
		Edge e5 = new Edge(n1, n2);
		Assert.assertEquals(e5.getDistance(), 4, DELTA);
	}

	@Test
	public void testEquals() {
		Node n1 = new Node(0, 0, 0);
		Node n2 = new Node(-2, 2, 1);
		Node n3 = new Node(5, 5, 2);
		Edge e1 = new Edge(n1, n2);
		Edge e2 = new Edge(n2, n1);
		Edge e3 = new Edge(n1, n3);
		
		Assert.assertTrue(e1.equals(e2));
		Assert.assertTrue(e2.equals(e1));
		Assert.assertFalse(e3.equals(e2));
		Assert.assertFalse(e2.equals(e3));
		Assert.assertFalse(e1.equals(e3));
		Assert.assertFalse(e3.equals(e1));
	}

}
