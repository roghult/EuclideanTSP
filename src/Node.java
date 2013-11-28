public class Node {
	private double x;
	private double y;
	private int index;
	public int degree;

	public Node(double x, double y, int index) {
		this.x = x;
		this.y = y;
		this.index = index;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
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
		Node other = (Node) obj;
		if (index != other.index)
			return false;
		return true;
	}
}
