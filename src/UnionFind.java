public class UnionFind implements DisjointSet {

	private int[] id;
	private byte[] rank;
	private int count;

	public UnionFind(int N) {
		id = new int[N];
		rank = new byte[N];
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
			rank[i] = 0;
		}
	}

	@Override
	public int find(int point) {
		while (point != id[point]) {
			id[point] = id[id[point]];
			point = id[point];
		}
		return point;
	}

	@Override
	public void union(int point1, int point2) {
		int i = find(point1);
		int j = find(point2);
		if (i == j) {
			return;
		}

		// TODO: get a full grasp on this
		if (rank[i] < rank[j]) {
			id[i] = j;
		} else if (rank[i] > rank[j]) {
			id[j] = i;
		} else {
			id[j] = i;
			rank[i]++;
		}
		count--;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public boolean connected(int point1, int point2) {
		return find(point1) == find(point2);
	}

}
