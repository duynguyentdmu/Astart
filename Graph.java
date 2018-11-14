package tdmu.edu.vn;

import java.util.ArrayList;

public class Graph {
	
	private ArrayList<Connection> adjacencyList;
	
	public ArrayList<Connection> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(ArrayList<Connection> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public Graph() {
		super();
	}

	public Graph(ArrayList<Connection> adjacencyList) {
		super();
		this.adjacencyList = adjacencyList;
	}

	public ArrayList<Connection> getConnections(NodeRecord current){
		
		// Tra ve danh sach cac node ke
		ArrayList<Connection> connections = new ArrayList<Connection>();
		
		for (Connection connection: this.getAdjacencyList())
			if (connection.getFromNode() == current.getNode())
				connections.add(connection);
		
		return connections;
	}
}
