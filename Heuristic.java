package tdmu.edu.vn;

import java.util.ArrayList;

public class Heuristic {
	
	private ArrayList<Double> distanceToDestination;
	
	public ArrayList<Double> getDistanceToDestination() {
		return distanceToDestination;
	}

	public void setDistanceToDestination(ArrayList<Double> distanceToDestination) {
		this.distanceToDestination = distanceToDestination;
	}

	public Heuristic() {
		super();
	}

	public Heuristic(ArrayList<Double> distanceToDestination) {
		super();
		this.distanceToDestination = distanceToDestination;
	}

	public double estimate(int node) {
		return this.distanceToDestination.get(node);
	}
}
