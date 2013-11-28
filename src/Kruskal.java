import java.util.HashSet;
import java.util.PriorityQueue;

public class Kruskal {

	public static HashSet<Edge> getMST(Graph g) {
		int N = g.count();
		HashSet<Edge> mst = new HashSet<Edge>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for(Edge e : g.getEdges()) {
			pq.add(e);
		}

		DisjointSet uf = new UnionFind(N);
		while (!pq.isEmpty() && mst.size() < N - 1) {
			Edge e = pq.poll();
			int point1 = e.getNode1().getIndex();
			int point2 = e.getNode2().getIndex();
			if (!uf.connected(point1, point2)) {
				// if a cycle isn't formed
				uf.union(point1, point2);
				mst.add(e);
			}
		}

		return mst;
	}

}
