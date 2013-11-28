public class Edge implements Comparable<Edge> {

	private Node node1;
	private Node node2;
	public Node getNode1() {
		return node1;
	}

	public Node getNode2() {
		return node2;
	}

	private int distance;

	public Edge(Node n1, Node n2) {
		// TODO: are x and y ever needed for the points? could these be removed?
		node1 = n1;
		node2 = n2;

		// Euclidean distance
		distance = (int) (Math.sqrt(((node1.getX() - node2.getX()) * (node1.getX() - node2.getX()))
				+ ((node1.getY() - node2.getY()) * (node1.getY() - node2.getY()))) + 0.5d);
	}

	public double getDistance() {
		return distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node1 == null) ? 0 : node1.hashCode());
		result = prime * result + ((node2 == null) ? 0 : node2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		
		if(node1.equals(other.node1)) {
			if(node2.equals(other.node2)) {
				return true;
			}
		}
		if(node1.equals(other.node2)) {
			if(node2.equals(other.node1)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int compareTo(Edge e) {
		return distance - e.distance;
	}

}
