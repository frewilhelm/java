package kMeanAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Centroid defines the datastructure of centroids that is based on Datapoint
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 */
public class Centroid {
	
	Datapoint centroid;
	public int amountOfDatapoints;
	public List<Datapoint> assignedDatapoints = new LinkedList<>();
	public int centroidNumber;
	
	/**
	 * Constructor of centroids
	 * @param datapoint
	 * @param centroidNumber - = amount of centroids ascending
	 */
	public Centroid(Datapoint datapoint, int centroidNumber) {
		this.centroid = datapoint;
		this.centroidNumber = centroidNumber;
	}
	
	/**
	 * Assign datapoint to a list of the chosen centroid.
	 * @param datapoint
	 */
	public void assignDatapoint(Datapoint datapoint) {
		assignedDatapoints.add(datapoint);
	}
	
	/**
	 * Get the value of the centroid.
	 * @param index
	 * @return double
	 */
	public double getValue(int index) {
		return this.centroid.getValue(index);
	}
	
	/**
	 * toString()-Method to print the centroids as adequate output.
	 */
	public String toString() {	
		String temp = "[" + this.centroid.datapoint[0];
		for(int i = 1; i < this.centroid.datapoint.length; i++) {
			temp = temp + ", " + this.centroid.datapoint[i];
		}
		temp = temp + "]";
		return temp;
	}
	
	/**
	 * Find the max value in the first dimension of all datapoints assigend to a given centroid. (For Graph)
	 * @return double
	 */
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
	
	/**
	 * Find the max value in the second dimension of all datapoints assigend to a given centroid. (For Graph)
	 * @return double
	 */
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
	
	/**
	 * In Clustering the centroids are updated depending on the assigned datapoints of a given centroid. Thus, the value
	 *  of the centroids has to be updated.
	 * @param newValue
	 * @param index
	 */
	public void updataCentroid(double newValue, int index) {
		this.centroid.datapoint[index] = newValue;
	}
}
