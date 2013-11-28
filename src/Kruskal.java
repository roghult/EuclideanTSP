import java.util.HashSet;
import java.util.PriorityQueue;

public class Kruskal {

	public static HashSet<Edge> getMST(double[][] points) {
		int N = points.length;
		HashSet<Edge> mst = new HashSet<Edge>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

		// create all edges and add them to our priority queue
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j != i) {
					pq.add(new Edge(points[i][0], points[i][1], points[j][0],
							points[j][1], i, j));
				}
			}
		}

		DisjointSet uf = new UnionFind(N);
		while (!pq.isEmpty() && mst.size() < N - 1) {
			Edge e = pq.poll();
			int point1 = e.getP1index();
			int point2 = e.getP2index();
			if (!uf.connected(point1, point2)) {
				// if a cycle isn't formed
				uf.union(point1, point2);
				mst.add(e);
			}
		}

		return mst;
	}

}
