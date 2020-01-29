package kMeanAlgorithm;

import java.util.LinkedList;
import java.util.List;

public class Centroids {
	
	public List<Centroid> centroids = new LinkedList<>();
	public int amCentroids;
	public int dimensions;
	private String dataName;
	public Centroid centroid;
	public int centroidNumber;
	
	/**
	 * Constructor of Centroids based on datapoints and the chosen amount of centroids. (Usually the centroids are randomly chosen.)
	 * @param datapoints
	 * @param amCentroids
	 */
	public Centroids(Datapoints datapoints, int amCentroids) {
		
		this.amCentroids = amCentroids;
		this.dimensions = datapoints.dimDatapoints;
		this.dataName = datapoints.dataName;
		this.centroidNumber = 1;
		
		// Loop for amount of centroids that were chosen in KMeanAlgorithm.java
		for(int i = 0; i < this.amCentroids; i++) {
			int tempCentroid = (int) (Math.random() * datapoints.amDatapoints); // Random int
			Datapoint temp = datapoints.getDatapoint(tempCentroid);
			centroid = new Centroid(temp, centroidNumber); // Use Centroid-Constructor
			centroids.add(centroid); // Add to list of centroids
			
			// remove these centroids from datapoints-list
			datapoints.removeDatapoint(tempCentroid);
			// Update amount of rows of datapoints-list
			datapoints.updateAmount();	
			
			this.centroidNumber++;
		}
		System.out.print(amCentroids + " Centroids were picked:");
		for(int i = 0; i < this.amCentroids; i++) {
			System.out.print(this.centroids.get(i).centroid);
		}
		System.out.println("\n");
	}
	
	/**
	 * Getter to get given centroid on index
	 * @param index
	 * @return Centroid - based on Datapoint (Double[])
	 */
	public Centroid getCentroid(int index) {
		return this.centroids.get(index);
	}
	
	/**
	 * Transform list of centroids to an array. Used for Graphic.java in Clustering.java
	 * (In this case, all used centroids are stored to show the change in the graph.)
	 * @return Double[][] - array with centroids
	 */
	public Double[][] toArray() {
		Double[][] tempList = new Double[this.centroids.size()][this.dimensions]; // Array with adequate lengths
		// store values.
		for(int i = 0; i < this.centroids.size(); i++) {
			Double[] tempCentroid = this.centroids.get(i).centroid.datapoint;
			for(int z = 0; z < this.dimensions; z++) {
				tempList[i][z] = tempCentroid[z];
			}
		}
		return tempList;
	}
	
	/**
	 * Print all centroids.
	 */
	public void prinOverview() {	
		System.out.println("The centroids (N = " + amCentroids + ", d = " + dimensions + ") of " + this.dataName + ": ");
		for(int i = 0; i < amCentroids; i++) {
			System.out.println(this.centroids.get(i).centroid);
		}	
	}
}
