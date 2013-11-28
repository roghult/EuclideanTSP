
public interface DisjointSet {
	
	int find(int point);
	void union(int point1, int point2);
	int count();
	boolean connected(int point1, int point2);

}
