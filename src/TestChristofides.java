import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestChristofides {

	private static Node[] nodes;
	private static Edge[] expectedEdges;
	private static Graph graph;
	private Christofides christofides;

	@Before
	public void setUp() throws Exception {
		nodes = new Node[] { new Node(2, 1, 0), new Node(0, 2, 1),
				new Node(4, 3, 2), new Node(0, 4, 3), new Node(2, 5, 4) };
		expectedEdges = new Edge[] { new Edge(new Node(4, 3, 2), new Node(2, 5,
				4)) };

		christofides = new Christofides();
		graph = new Graph(nodes);

		graph.addEdge(nodes[2], nodes[0]);
		graph.addEdge(nodes[0], nodes[1]);
		graph.addEdge(nodes[1], nodes[3]);
		graph.addEdge(nodes[3], nodes[4]);
	}

	@Test
	public void testNodesWithOddDegree() {
		Node[] O = christofides.getNodesWithOddDegree(graph);
		for (Node n : O) {
			Assert.assertTrue(n.degree % 2 == 1);
		}
	}

	@Test
	public void testMatchNotEmpty() {
		Node[] O = christofides.getNodesWithOddDegree(graph);
		HashSet<Edge> M = christofides.greedyMatch(O, graph);
		Assert.assertTrue(M.size() > 0);
	}

	@Test
	public void testMatch() {
		Node[] O = christofides.getNodesWithOddDegree(graph);
		HashSet<Edge> M = christofides.greedyMatch(O, graph);
		for (Edge e : M) {
			boolean edgeFound = false;
			for (Edge expectedEdge : expectedEdges) {
				if (expectedEdge.equals(e)) {
					edgeFound = true;
					break;
				}
			}
			Assert.assertTrue(edgeFound);
		}
	}

}
