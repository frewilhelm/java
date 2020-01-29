package kMeanAlgorithm;

/**
 * Datastructure for Datapoint based on Double[] and is basis for Centroid, Centroids, Datapoints
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 */
public class Datapoint {
	
	Double[] datapoint;
	public int centrAssigned;
	private int length;
	public double distance;
	
	/**
	 * Construtor
	 * @param datapoint - Double[]
	 */
	public Datapoint(Double[] datapoint) {
		this.datapoint = datapoint;
	}
	
	/**
	 * Assign single datapoint to a centroid with a given identifier
	 * @param centroidIndex
	 */
	public void assignToCentroid(int centroidIndex) {
		centrAssigned = centroidIndex; 
	}
	
	/**
	 * Length/Dimensions of the datapoint
	 * @return int
	 */
	public int length() {
		return this.length;
	}
	
	/**
	 * Get the values at the dimension/index from the datapoint
	 * @param index
	 * @return double
	 */
	public double getValue(int index) {
		return this.datapoint[index];
	}
	
	/**
	 * Set the property 'distance' of a datapoint.
	 * - refers to the lp-distance between the given datapoint and a centroid. 
	 * @param distance
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	/**
	 * toString()-method for an adequate output
	 */
	public String toString() {	
		String temp = "[" + this.datapoint[0];
		for(int i = 1; i < this.datapoint.length; i++) {
			temp = temp + ", " + this.datapoint[i];
		}
		temp = temp + "]";
		return temp;
	}

}
