import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[][] points = new double[N][2];
		String[] coordinates;
		for(int i = 0; i < N; i++) {
			coordinates = br.readLine().split(" ");
			points[i][0] = Double.parseDouble(coordinates[0]);
			points[i][1] = Double.parseDouble(coordinates[1]);
		}
		printPoints(points);
	}
	
	private static void printPoints(double[][] points) {
		for(int i = 0; i < points.length; i++) {
			System.out.println(i + ": " + points[i][0] + " " + points[i][1]);
		}
	}

}
