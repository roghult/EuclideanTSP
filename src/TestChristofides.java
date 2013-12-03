import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestChristofides {

	private static Node[] nodes1;
	private static Edge[] expectedEdges1;
	private static HashSet<Edge> combineEdges;
	private static Graph graph1;
	private Christofides christofides;

	@Before
	public void setUp() throws Exception {
		nodes1 = new Node[] { new Node(2, 1, 0), new Node(0, 2, 1),
				new Node(4, 3, 2), new Node(0, 4, 3), new Node(2, 5, 4) };
		expectedEdges1 = new Edge[] { new Edge(new Node(4, 3, 2), new Node(2, 5,
				4)) };
		combineEdges = new HashSet<Edge>();

		christofides = new Christofides();
		graph1 = new Graph(nodes1);

		graph1.addEdge(nodes1[2], nodes1[0]);
		graph1.addEdge(nodes1[0], nodes1[1]);
		graph1.addEdge(nodes1[1], nodes1[3]);
		graph1.addEdge(nodes1[3], nodes1[4]);
	}

	@Test
	public void testNodesWithOddDegree() {
		Node[] O = christofides.getNodesWithOddDegree(graph1);
		for (Node n : O) {
			Assert.assertTrue(n.degree % 2 == 1);
		}
	}

	@Test
	public void testMatchNotEmpty() {
		Node[] O = christofides.getNodesWithOddDegree(graph1);
		HashSet<Edge> M = christofides.greedyMatch(O, graph1);
		Assert.assertTrue(M.size() > 0);
	}

	@Test
	public void testMatch() {
		Node[] O = christofides.getNodesWithOddDegree(graph1);
		HashSet<Edge> M = christofides.greedyMatch(O, graph1);
		for (Edge e : M) {
			boolean edgeFound = false;
			for (Edge expectedEdge : expectedEdges1) {
				if (expectedEdge.equals(e)) {
					edgeFound = true;
					break;
				}
			}
			Assert.assertTrue(edgeFound);
		}
	}
	
	@Test
	public void testCombineNotNull() {
		MultiGraph multiGraph = christofides.combine(graph1, combineEdges);
		Assert.assertNotNull(multiGraph);
	}

	@Test
	public void testCombineEdgeSize() {
		MultiGraph multiGraph = christofides.combine(graph1, combineEdges);
		Assert.assertEquals(multiGraph.getEdges().size(), 4);
		
		combineEdges.add(new Edge(new Node(4,3,2), new Node(2,5,4)));
		multiGraph = christofides.combine(graph1, combineEdges);
		Assert.assertEquals(multiGraph.getEdges().size(), 5);
	}
}
