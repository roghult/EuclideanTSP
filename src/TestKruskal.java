import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestKruskal {

	private static final Node[] POINTS = { new Node(95.0129, 61.5432, 0),
			new Node(23.1139, 79.1937, 1), new Node(60.6843, 92.1813, 2),
			new Node(48.5982, 73.8207, 3), new Node(89.1299, 17.6266, 4),
			new Node(76.2097, 40.5706, 5), new Node(45.6468, 93.5470, 6),
			new Node(1.8504, 91.6904, 7), new Node(82.1407, 41.0270, 8),
			new Node(44.4703, 89.3650, 9) };
	private HashSet<Edge> mst;

	@Before
	public void setUp() {
		int N = POINTS.length;
		Graph g = new Graph(POINTS);
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				g.addEdge(POINTS[i], POINTS[j]);
			}
		}
		mst = Kruskal.getMST(g);
	}

	@Test
	public void testMSTNotNull() {
		Assert.assertNotNull(mst);
	}

	@Test
	public void testMSTNotEmpty() {
		Assert.assertTrue(mst.size() > 0);
	}

	@Test
	public void testMSTHasCorrectSize() {
		Assert.assertTrue(mst.size() == POINTS.length - 1);
	}

	@Test
	public void testAllPointsAreConnected() {
		for (Edge e : mst) {
			int point1 = e.getNode1().getIndex();
			int point2 = e.getNode2().getIndex();
			boolean isConnected = false;
			for (Edge e2 : mst) {
				if (point1 == e2.getNode1().getIndex()) {
					isConnected = true;
					break;
				}
				if (point2 == e2.getNode2().getIndex()) {
					isConnected = true;
					break;
				}
			}
			Assert.assertTrue(isConnected);
		}
	}

}
