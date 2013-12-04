import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestHierholzer {
	
	private Node[] nodes1;
	private MultiGraph baseGraph;
	private MultiGraph complexGraph;

	@Before
	public void setUp() throws Exception {
		nodes1 = new Node[] { new Node(2, 1, 0), new Node(0, 2, 1),
				new Node(4, 3, 2), new Node(0, 4, 3), new Node(2, 5, 4) };
		complexGraph = new MultiGraph(nodes1);
		int N = nodes1.length;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				complexGraph.addEdge(nodes1[i], nodes1[j]);
			}
		}
		
		Node n1 = new Node(0,0,0);
		Node n2 = new Node(1,1,1);
		Edge e1 = new Edge(n1, n2);
		Edge e2 = new Edge(n2, n1);
		baseGraph = new MultiGraph(new Node[] {n1, n2});
		baseGraph.addEdge(e1);
		baseGraph.addEdge(e2);
	}

	@Test
	public void testCycleNotNull() {
		Assert.assertNotNull(Hierholzer.getEulerCycle(complexGraph));
		Assert.assertNotNull(Hierholzer.getEulerCycle(baseGraph));
	}
	
	@Test
	public void testCycleLength() {
		LinkedList<Edge> baseCycle = Hierholzer.getEulerCycle(baseGraph);
		LinkedList<Edge> complexCycle = Hierholzer.getEulerCycle(complexGraph);
		Assert.assertEquals(baseCycle.size(), 1);
		Assert.assertEquals(complexCycle.size(), 10);
	}

}
