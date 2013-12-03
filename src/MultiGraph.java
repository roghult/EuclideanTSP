import java.util.ArrayList;

public class MultiGraph {

	private Node[] nodes;
	protected ArrayList<Edge> edges;

	public MultiGraph(Node[] nodes) {
		this.nodes = nodes;
		int N = nodes.length;
		edges = new ArrayList<Edge>((N * (N - 1) / 2) + 1);
	}

	public MultiGraph(Graph g) {
		this(g.getNodes());
		edges = new ArrayList<Edge>(g.getEdges());
	}

	public void addEdge(Node n1, Node n2) {
		if (edges.add(new Edge(n1, n2))) {
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

	public ArrayList<Edge> getEdges() {
		return edges;
	}
}
