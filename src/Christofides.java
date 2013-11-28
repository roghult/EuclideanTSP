import java.util.HashSet;

public class Christofides implements TSPSolver {

	@Override
	public int[] findPath(Graph G) {
		/*
		 * 1. 	Create a minimum spanning tree T of G
		 */
		HashSet<Edge> T = Kruskal.getMST(G);

		/*
		 * 2. 	Let O be the set of vertices with odd degree in T
		 * 		and find a perfect matching M with minimum weight 
		 * 		in the complete graph over the vertices from O.
		 */
		HashSet<Node> O = getNodesWithOddDegree(T);
		HashSet<Edge> M = match(O, G);
		
		/*
		 * 3.	Combine the edges of M and T to form a multigraph H.
		 */
		
		
		/*
		 * 4. 	Form an Eulerian circuit in H (H is Eulerian because
		 * 		it is connected, with only even-degree vertices).
		 */
		
		
		/*
		 * 5.	Make the circuit found in previous step Hamiltonian by
		 * 		skipping visited nodes (shortcutting).
		 */

		return null;
	}
	
	private HashSet<Edge> match(HashSet<Node> o, Graph g) {
		// TODO Auto-generated method stub
		return null;
	}

	private HashSet<Node> getNodesWithOddDegree(HashSet<Edge> edges) {
		HashSet<Node> nodes = new HashSet<Node>();
		for(Edge e : edges) {
			if(e.getNode1().degree % 2 == 1) {
				nodes.add(e.getNode1());
			}
			if(e.getNode2().degree % 2 == 1) {
				nodes.add(e.getNode2());
			}
		}
		return nodes;
	}

}
