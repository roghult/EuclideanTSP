public class Edge implements Comparable<Edge> {

	private double p1x;
	private double p1y;
	private double p2x;
	private double p2y;
	private int distance;
	private int p1index;
	private int p2index;

	public Edge(double p1x, double p1y, double p2x, double p2y, int p1index, int p2index) {
		// TODO: are x and y ever needed for the points? could these be removed?
		this.p1x = p1x;
		this.p1y = p1y;
		this.p2x = p2x;
		this.p2y = p2y;
		this.p1index = p1index;
		this.p2index = p2index;
		
		// Euclidean distance
		distance = (int) (Math.sqrt(((p1x - p2x) * (p1x - p2x))
				+ ((p1y - p2y) * (p1y - p2y))) + 0.5d);
	}

	public int getP1index() {
		return p1index;
	}

	public int getP2index() {
		return p2index;
	}

	public double getDistance() {
		return distance;
	}

//	public double getP1x() {
//		return p1x;
//	}
//
//	public double getP1y() {
//		return p1y;
//	}
//
//	public double getP2x() {
//		return p2x;
//	}
//
//	public double getP2y() {
//		return p2y;
//	}

	@Override
	public int compareTo(Edge e) {
		return distance - e.distance;
	}

}
