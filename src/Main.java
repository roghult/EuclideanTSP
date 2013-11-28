import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double x;
		double y;
		Node[] nodes = new Node[N];
		String[] coordinates;
		for (int i = 0; i < N; i++) {
			coordinates = br.readLine().split(" ");
			x = Double.parseDouble(coordinates[0]);
			y = Double.parseDouble(coordinates[1]);
			nodes[i] = new Node(x, y, i);
		}
		Graph g = new Graph(nodes);
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				g.addEdge(nodes[i], nodes[j]);
			}
		}
	}

}
