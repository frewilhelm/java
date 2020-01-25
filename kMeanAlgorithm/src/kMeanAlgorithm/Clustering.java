package kMeanAlgorithm;

import java.util.Iterator;
import java.util.List;

public class Clustering {
	
	private Datapoint datapoint;
	private Centroid centroid;

	/*
	public Clustering(Centroids centroids, Datapoints datapoints)
	{
		//kMean-algorithm
		while(centroids.change) { 	// Boolean-check, if moving the centroids make a difference
		
			centroids.change = false;

			assignDataPointToCentroids(centroids, datapoints);  // Assigns datapoints to centroids

			if(centroids.change == true)	// If there are assigned datapoints, move the centroid
			{
				moveCentroids(centroids);
			}
			else	 // If there are no new assigned datapoints the clustering is done
			{
				System.out.println("No change!");
			}
		}
		System.out.println("Clustering DONE");
	}
	*/
	
	public Clustering(Centroids centroids, Datapoints datapoints) {
		
		/*
		 * Berechne die Distanz zwischen centroid und datapoint. Ordne datapoint dem centroiden mit der geringsten Distanz zu
		 */
		
		assignDatapoints(centroids, datapoints);
		
	}
	
	private void assignDatapoints(Centroids centroids, Datapoints datapoints) {
		
		double maxValue = Double.MAX_VALUE;
		
		for(int i = 0; i < centroids.amCentroids; i++) {
			centroid = new Centroid(centroids, i); 
			for(int j = 0; j < datapoints.amDatapoints; j++) {
				
				datapoint = new Datapoint(datapoints, j); 
				
				if(i == 0) {
					datapoint.setDistance(Similarity.getLpDistance(centroid, datapoint, datapoints.dimDatapoints)); // Store distance
					datapoint.centrAssigned = i;
					printAssignProcess(datapoint, centroid);
					
				}
				else {
					if(datapoint.distance < Similarity.getLpDistance(centroid, datapoint, datapoints.dimDatapoints)) {
						datapoint.centrAssigned = i;
						datapoint.setDistance(Similarity.getLpDistance(centroid, datapoint, datapoints.dimDatapoints));
						printAssignProcess(datapoint, centroid);
					}	
				}
			}
		}
		
		// Does not work like it should.... do i need specific centroids??!
		for(int z = 0; z < centroids.amCentroids; z++) {
			System.out.println("Centroid " + centroids.getCentroid(z).toString() + " has " + centroids.getCentroid(z).length );
		}
		
	}
		
	private void printAssignProcess(Datapoint datapoint, Centroid centroid) {
		System.out.println("Distance between " + datapoint.toString() + " and " + centroid.toString() + " is " + 
				(int) datapoint.distance + " and is assigned to centroid: " + datapoint.centrAssigned);
	}



}
