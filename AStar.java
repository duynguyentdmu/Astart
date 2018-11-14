package tdmu.edu.vn;

import java.util.ArrayList;
import java.util.Collections;

public class AStar {
	
	private boolean contains(ArrayList<NodeRecord> list, int node) {
		
		for (NodeRecord nodeRecord: list)
			if (nodeRecord.getNode() == node)
				return true;

		return false;
	}
	
	private NodeRecord find(ArrayList<NodeRecord> list, int node) {
		
		for (NodeRecord nodeRecord: list)
			if (nodeRecord.getNode() == node)
				return nodeRecord;
		
		return null;
	}
	
	public ArrayList<Connection> pathfindAStar(Graph graph, int start, int end, Heuristic heuristic) {
		
		NodeRecord startRecord = new NodeRecord();
		
		startRecord.setNode(start);
		startRecord.setConnection(null);
		startRecord.setCostSoFar(0);
		startRecord.setEstimatedTotalCost(heuristic.estimate(start));
		
		ArrayList<NodeRecord> open = new ArrayList<NodeRecord>();
		open.add(startRecord);
		ArrayList<NodeRecord> closed =  new ArrayList<NodeRecord>();
		
		NodeRecord current = null;
		
		while (!open.isEmpty()) {
			
			current = Collections.min(open);
			
			if (current.getNode() ==  end) break;
			
			ArrayList<Connection> connections = graph.getConnections(current);
			
			for (Connection connection: connections) {
				int endNode = connection.getToNode();
				double endNodeCost = current.getCostSoFar() + connection.getCost();
				double endNodeHeuristic = 0.0f;
				NodeRecord endNodeRecord = new NodeRecord();
				
				if (contains(closed, endNode)) {
					endNodeRecord = find(closed, endNode);
					if (endNodeRecord.getCostSoFar() <= endNodeCost) continue;
					closed.remove(endNodeRecord);
					endNodeHeuristic = heuristic.estimate(endNode);
				}
				else if (contains(open, endNode)) {
					endNodeRecord = find(open, endNode);
					if (endNodeRecord.getCostSoFar() <= endNodeCost) continue;
					endNodeHeuristic = endNodeRecord.getEstimatedTotalCost() - endNodeRecord.getCostSoFar();
				}
				else {
					endNodeRecord.setNode(endNode);
					endNodeHeuristic = heuristic.estimate(endNode);
				}
				
				endNodeRecord.setCostSoFar(endNodeCost);
				endNodeRecord.setConnection(connection);
				endNodeRecord.setEstimatedTotalCost(endNodeCost + endNodeHeuristic);
				
				if (!contains(open, endNode))
					open.add(endNodeRecord);
				
				open.remove(current);
				closed.add(current);
			}
		}
		
		if (current.getNode() != end) {
			return null;
		}
		else {
			System.out.println("Total cost: " + current.getEstimatedTotalCost());
			
			ArrayList<Connection> path = new ArrayList<Connection>(); 
			while (current.getNode()!=start) {
				path.add(current.getConnection());
				current = find(closed, current.getConnection().getFromNode());
			}
			
			return path;
		}
	}
}
