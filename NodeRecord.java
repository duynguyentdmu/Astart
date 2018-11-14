package tdmu.edu.vn;

public class NodeRecord implements Comparable<NodeRecord>{
	
	private int node;
	private Connection connection;
	private double costSoFar;
	private double estimatedTotalCost;
	
	public int getNode() {
		return node;
	}
	
	public void setNode(int node) {
		this.node = node;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public double getCostSoFar() {
		return costSoFar;
	}
	
	public void setCostSoFar(double costSoFar) {
		this.costSoFar = costSoFar;
	}
	
	public double getEstimatedTotalCost() {
		return estimatedTotalCost;
	}
	
	public void setEstimatedTotalCost(double estimatedTotalCost) {
		this.estimatedTotalCost = estimatedTotalCost;
	}

	public NodeRecord(int node, Connection connection, double costSoFar, double estimatedTotalCost) {
		super();
		this.node = node;
		this.connection = connection;
		this.costSoFar = costSoFar;
		this.estimatedTotalCost = estimatedTotalCost;
	}

	public NodeRecord() {
		super();
	}

	@Override
	public int compareTo(NodeRecord o) {
		if (this.estimatedTotalCost < o.estimatedTotalCost) return -1;
		if (this.estimatedTotalCost > o.estimatedTotalCost)	return 1;
		return 0;
	}
	
	
}
