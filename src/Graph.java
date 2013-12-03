import java.util.HashSet;

public class Graph {
	private Node[] nodes;
	protected HashSet<Edge> edges;

	public Graph(Node[] nodes) {
		this.nodes = nodes;
		int N = nodes.length;
		edges = new HashSet<Edge>((N * (N - 1) / 2) + 1);
	}
	
	public void addEdge(Node n1, Node n2) {
		if(edges.add(new Edge(n1, n2))) {
			n1.degree++;
			n2.degree++;
		}
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
	}
	
	public int count() {
		return nodes.length;
	}

	public Node[] getNodes() {
		return nodes;
	}

	public HashSet<Edge> getEdges() {
		return edges;
	}

}
