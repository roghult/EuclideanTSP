import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestKruskal {

	private static final double[][] POINTS = { { 95.0129, 61.5432 },
			{ 23.1139, 79.1937 }, { 60.6843, 92.1813 }, { 48.5982, 73.8207 },
			{ 89.1299, 17.6266 }, { 76.2097, 40.5706 }, { 45.6468, 93.5470 },
			{ 1.8504, 91.6904 }, { 82.1407, 41.0270 }, { 44.4703, 89.3650 } };
	private HashSet<Edge> mst;

	@Before
	public void setUp() {
		mst = Kruskal.getMST(POINTS);
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
	public void testAllPointsAreConnected() {
		for(Edge e : mst) {
			int point1 = e.getP1index();
			int point2 = e.getP2index();
			boolean isConnected = false;
			for(Edge e2 : mst) {
				if(point1 == e2.getP1index()) {
					isConnected = true;
					break;
				}
				if(point2 == e2.getP2index()) {
					isConnected = true;
					break;
				}
			}
			Assert.assertTrue(isConnected);
		}
	}

}
