import java.util.HashSet;


public class Christofides implements TSPSolver {

	@Override
	public int[] findPath(double[][] points) {
		HashSet<Edge> mst = Kruskal.getMST(points);
		
		return null;
	}

}
