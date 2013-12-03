import java.util.HashSet;
import java.util.PriorityQueue;

public class Christofides implements TSPSolver {

	@Override
	public int[] findPath(Graph G) {
		/*
		 * 1. Create a minimum spanning tree T of G
		 */
		Graph T = Kruskal.getMST(G);

		/*
		 * 2. Let O be the set of vertices with odd degree in T and find a
		 * perfect matching M with minimum weight in the complete graph over the
		 * vertices from O.
		 */
		Node[] O = getNodesWithOddDegree(T);
		HashSet<Edge> M = greedyMatch(O, G);

		/*
		 * 3. Combine the edges of M and T to form a multigraph H.
		 */
		

		/*
		 * 4. Form an Eulerian circuit in H (H is Eulerian because it is
		 * connected, with only even-degree vertices).
		 */

		/*
		 * 5. Make the circuit found in previous step Hamiltonian by skipping
		 * visited nodes (shortcutting).
		 */

		return null;
	}

	public HashSet<Edge> greedyMatch(Node[] O, Graph G) {
		HashSet<Edge> M = new HashSet<Edge>();
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();

		// get all edges between the nodes
		for (int i = 0; i < O.length; i++) {
			for (int j = i + 1; j < O.length; j++) {
				// TODO: analyze if this is more expensive than fetching the
				// edges from G
				edges.add(new Edge(O[i], O[j]));
			}
		}

		// get shortest edge and mark it
		// if vertex of edge is marked skip it since the shortest edge has
		// already been marked
		Edge e;
		boolean[] nodeIsMarked = new boolean[G.getNodes().length];
		while (!edges.isEmpty()) {
			e = edges.poll();
			int node1index = e.getNode1().getIndex();
			int node2index = e.getNode2().getIndex();
			if (!nodeIsMarked[node1index] && !nodeIsMarked[node2index]) {
				nodeIsMarked[node1index] = true;
				nodeIsMarked[node2index] = true;
				M.add(e);
			}
		}

		return M;
	}

	public Node[] getNodesWithOddDegree(Graph g) {
		HashSet<Node> nodes = new HashSet<Node>();
		HashSet<Edge> edges = g.getEdges();
		for (Edge e : edges) {
			if (e.getNode1().degree % 2 == 1) {
				nodes.add(e.getNode1());
			}
			if (e.getNode2().degree % 2 == 1) {
				nodes.add(e.getNode2());
			}
		}
		return nodes.toArray(new Node[0]);
	}

}
