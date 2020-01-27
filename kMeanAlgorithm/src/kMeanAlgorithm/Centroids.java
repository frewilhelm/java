package kMeanAlgorithm;

import java.util.Iterator;
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
	 * Constructor of centroids.
	 * Chooses amount i random centroids of the datapoints-list
	 */
	public Centroids(Datapoints datapoints, int amCentroids) {
		
		this.amCentroids = amCentroids;
		this.dimensions = datapoints.dimDatapoints;
		this.dataName = datapoints.dataName;
		this.centroidNumber = 1;
		
		for(int i = 0; i < this.amCentroids; i++) {
			
			int tempCentroid = i; //(int) (Math.random() * datapoints.amDatapoints);
			Datapoint temp = datapoints.getDatapoint(tempCentroid);
			centroid = new Centroid(temp, centroidNumber); 	
			centroids.add(centroid);
			
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
	
	public Centroid getCentroid(int index) {
		return this.centroids.get(index);
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
