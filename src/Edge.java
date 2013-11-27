public class Edge {

	private double p1x;
	private double p1y;
	private double p2x;
	private double p2y;
	private double distance;

	public Edge(double p1x, double p1y, double p2x, double p2y) {
		this.p1x = p1x;
		this.p1y = p1y;
		this.p2x = p2x;
		this.p2y = p2y;
		// Euclidean distance
		distance = (int) (Math.sqrt(((p1x - p2x) * (p1x - p2x))
				+ ((p1y - p2y) * (p1y - p2y))) + 0.5d);
	}

	public double getDistance() {
		return distance;
	}

	public double getP1x() {
		return p1x;
	}

	public double getP1y() {
		return p1y;
	}

	public double getP2x() {
		return p2x;
	}

	public double getP2y() {
		return p2y;
	}

}
