package tdmu.edu.vn;

public class Connection {

	private double cost;
	private int fromNode;
	private int toNode;
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public int getFromNode() {
		return fromNode;
	}
	
	public void setFromNode(int fromNode) {
		this.fromNode = fromNode;
	}
	
	public int getToNode() {
		return toNode;
	}
	
	public void setToNode(int toNode) {
		this.toNode = toNode;
	}
	
	public Connection(double cost, int fromNode, int toNode) {
		super();
		this.cost = cost;
		this.fromNode = fromNode;
		this.toNode = toNode;
	}
	
	public Connection() {
		super();
	}
}
