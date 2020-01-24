package kMeanAlgorithm;

import java.util.LinkedList;
import java.util.List;

public class Centroids {
	
	public List<Double[]> centroids = new LinkedList<>();
	private int amCentroids;
	private int dimensions;
	private String dataName;
	
	/**
	 * Constructor of centroids.
	 * Chooses amount i random centroids of the datapoints-list
	 */
	public Centroids(Datapoints datapoints, int amCentroids) {
		
		this.amCentroids = amCentroids;
		this.dimensions = datapoints.dimDatapoints;
		this.dataName = datapoints.dataName;
		
		for(int i = 0; i < amCentroids; i++) {
			
			int tempCentroid = (int) (Math.random() * datapoints.amDatapoints);
			this.centroids.add(datapoints.getDatapoint(tempCentroid));
			
			// remove these centroids from datapoints-list
			datapoints.removeDatapoint(tempCentroid);
			// Update amount of rows of datapoints-list
			datapoints.updateAmount();	
		}
	}
	
	public void updateCentroids(Double[] upCentroid, int index) {
		
		if(index > amCentroids - 1) {
			throw new RuntimeException("Index > than amount of centroids. There is nothing to update!");	
			
		}
		this.centroids.remove(index);
		this.centroids.add(index, upCentroid);		
	}
	
	/**
	 * Print all centroids.
	 */
	public void print() {	
		System.out.println("The centroids (N = " + amCentroids + ", d = " + dimensions + ") of " + this.dataName + ": ");
		for(int i = 0; i < amCentroids; i++) {
			System.out.print("[" + this.centroids.get(i)[0]);
			for(int j = 1; j < dimensions; j++) {
				System.out.print(", " +this.centroids.get(i)[j]);
			}
			System.out.println("]");
		}	
		System.out.println();
	}

}
