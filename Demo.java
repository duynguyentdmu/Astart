package tdmu.edu.vn;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		
		ArrayList<Connection> adjacencyList = new ArrayList<Connection>();
		adjacencyList.add(new Connection(1.3, 0, 1));
		adjacencyList.add(new Connection(1.1, 0, 2));
		adjacencyList.add(new Connection(1.5, 1, 3));
		adjacencyList.add(new Connection(1.7, 1, 4));
		adjacencyList.add(new Connection(1.5, 2, 4));
		adjacencyList.add(new Connection(1.6, 2, 5));
		adjacencyList.add(new Connection(1.4, 4, 6));
		Graph graph = new Graph(adjacencyList);
		
		ArrayList<Double> listDistanceToNode = new ArrayList<Double>(Arrays.asList(4.2, 3.2, 3.7, 2.8, 1.6, 1.4, 0.0));
		Heuristic heuristic = new Heuristic(listDistanceToNode);
		
		int start = 0;
		int end = 6;
		
		AStar aStar = new AStar();
		ArrayList<Connection> path = aStar.pathfindAStar(graph, start, end, heuristic);
		
		if (path != null) {
			System.out.print((char)(end + 65) + " <= ");
			for (Connection connection: path) 
				System.out.print((char)(connection.getFromNode() + 65) + " <= ");
		}
	}
}
