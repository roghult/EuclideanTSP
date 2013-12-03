import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestKruskal {

	private static final Node[] nodes1 = { new Node(95.0129, 61.5432, 0),
			new Node(23.1139, 79.1937, 1), new Node(60.6843, 92.1813, 2),
			new Node(48.5982, 73.8207, 3), new Node(89.1299, 17.6266, 4),
			new Node(76.2097, 40.5706, 5), new Node(45.6468, 93.5470, 6),
			new Node(1.8504, 91.6904, 7), new Node(82.1407, 41.0270, 8),
			new Node(44.4703, 89.3650, 9) };
	private static final Node[] nodes2 = { new Node(2, 1, 0),
			new Node(0, 2, 1), new Node(4, 3, 2), new Node(0, 4, 3),
			new Node(2, 5, 4) };
	private ArrayList<Node[]> nodesList;
	private ArrayList<Graph> mstList;

	@Before
	public void setUp() {
		nodesList = new ArrayList<Node[]>();
		mstList = new ArrayList<Graph>();
		nodesList.add(nodes1);
		nodesList.add(nodes2);
		for (Node[] nodes : nodesList) {
			int N = nodes.length;
			Graph g = new Graph(nodes);
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					g.addEdge(nodes[i], nodes[j]);
				}
			}
			mstList.add(Kruskal.getMST(g));
		}
	}

	@Test
	public void testMSTNotNull() {
		for (Graph mst : mstList) {
			Assert.assertNotNull(mst);
		}
	}

	@Test
	public void testMSTNotEmpty() {
		for (Graph mst : mstList) {
			Assert.assertTrue(mst.getEdges().size() > 0);
		}
	}

	@Test
	public void testMSTHasCorrectEdgeSize() {
		for (int i = 0; i < mstList.size(); i++) {
			Assert.assertEquals(mstList.get(i).getEdges().size(), nodesList.get(i).length - 1);
		}
	}

	@Test
	public void testAllPointsAreConnected() {
		for (Graph mst : mstList) {
			HashSet<Edge> edges = mst.getEdges();
			for (Edge e : edges) {
				int point1 = e.getNode1().getIndex();
				int point2 = e.getNode2().getIndex();
				boolean isConnected = false;
				for (Edge e2 : edges) {
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

}
