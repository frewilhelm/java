package kMeanAlgorithm;

public class Datapoint {
	
	Double[] datapoint;
	public int centrAssigned;
	private int length;
	
	public Datapoint(Datapoints datapoints, int index) {
		this.length = datapoints.dimDatapoints;
		this.datapoint = datapoints.getDatapoint(index);
	}
	
	public void assignToCentroid(int centroidIndex) {
		centrAssigned = centroidIndex; 
	}
	
	public int length() {
		return this.length;
	}
	
	public double getValue(int index) {
		return this.datapoint[index];
	}
	
	public void print() {
		System.out.print("[" + this.datapoint[0]);
		for(int i = 0; i < this.datapoint.length; i++) {
			System.out.print(", " + this.datapoint[i]);
		}
		System.out.println("]");
	}
	
	public String toString() {
		
		String temp = "[" + this.datapoint[0];
		for(int i = 1; i < this.datapoint.length; i++) {
			temp = temp + ", " + this.datapoint[i];
		}
		temp = temp + "]";
		return temp;
	}

}
