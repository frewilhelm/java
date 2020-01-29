package kMeanAlgorithm;

import java.util.LinkedList;
import java.util.List;

public class Centroid {
	
	Datapoint centroid;
	public int amountOfDatapoints;
	public List<Datapoint> assignedDatapoints = new LinkedList<>();
	public int centroidNumber;
	
	
	public Centroid(Datapoint datapoint, int centroidNumber) {
		this.centroid = datapoint;
		this.centroidNumber = centroidNumber;
	}

	public void assignDatapoint(Datapoint datapoint) {
		assignedDatapoints.add(datapoint);
	}
	
	public double getValue(int index) {
		return this.centroid.getValue(index);
	}
	
	public String toString() {	
		String temp = "[" + this.centroid.datapoint[0];
		for(int i = 1; i < this.centroid.datapoint.length; i++) {
			temp = temp + ", " + this.centroid.datapoint[i];
		}
		temp = temp + "]";
		return temp;
	}
	
	public double assignedMaxValueX() {
		double max = 0;
		for(int i = 0; i < this.assignedDatapoints.size(); i++) {
			Double temp = this.assignedDatapoints.get(i).datapoint[0];
			if(max < temp) {
				max = temp;
			}
		}
		return max;
	}
	
	public double assignedMaxValueY() {
		double max = 0;
		for(int i = 0; i < this.assignedDatapoints.size(); i++) {
			Double temp = this.assignedDatapoints.get(i).datapoint[1];
			if(max < temp) {
				max = temp;
			}
		}
		return max;
	}
	
	public void updataCentroid(double mean, int index) {
		this.centroid.datapoint[index] = mean;
	}
	
}
