import java.util.HashSet;


public class MultiEdge extends Edge {

	public MultiEdge(Node n1, Node n2) {
		super(n1, n2);
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
		
		if(getNode1().equals(other.getNode1())) {
			if(getNode2().equals(other.getNode2())) {
				return true;
			}
		}
		if(getNode1().equals(other.getNode2())) {
			if(getNode2().equals(other.getNode1())) {
				return true;
			}
		}
		
		return false;
	}

}
