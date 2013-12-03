import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGraph {

	private static Node[] nodes1;

	@Before
	public void setUp() {
		nodes1 = new Node[] { new Node(2, 1, 0), new Node(0, 2, 1),
				new Node(4, 3, 2), new Node(0, 4, 3), new Node(2, 5, 4) };
	}

	@Test
	public void testNodeDegreeNoEdges() {
		Graph graphWithoutEdges = new Graph(nodes1);
		for (Node n : graphWithoutEdges.getNodes()) {
			Assert.assertEquals(n.degree, 0);
		}
	}

	@Test
	public void testNodeDegreeOneEdge() {
		Graph graphWithEdgeBetweenFirstAndSecondNode = new Graph(nodes1);
		graphWithEdgeBetweenFirstAndSecondNode.addEdge(nodes1[0], nodes1[1]);
		Node[] nodes = graphWithEdgeBetweenFirstAndSecondNode.getNodes();
		for (int i = 0; i < nodes.length; i++) {
			if (i == 0 || i == 1) {
				Assert.assertEquals(nodes[i].degree, 1);
			} else {
				Assert.assertEquals(nodes[i].degree, 0);
			}
		}
	}

	@Test
	public void testNodeDegreeCompleteGraph() {
		Graph completeGraph = new Graph(nodes1);
		for (int i = 0; i < nodes1.length; i++) {
			for (int j = i + 1; j < nodes1.length; j++) {
				completeGraph.addEdge(nodes1[i], nodes1[j]);
			}
		}

		for (Node n : completeGraph.getNodes()) {
			Assert.assertEquals(n.degree, 4);
		}
	}

}
