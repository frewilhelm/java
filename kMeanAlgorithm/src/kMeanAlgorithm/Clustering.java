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
		
		for(int i = 0; i < datapoints.amDatapoints; i++) {
			datapoint = new Datapoint(datapoints, i); 
			for(int j = 0; j < centroids.amCentroids; j++) {
				centroid = new Centroid(centroids, j); 
				double temp = Similarity.getLpDistance(centroid, datapoint, datapoints.amDatapoints);
				System.out.println("Distance between " + datapoint.toString() + " and " + centroid.toString() + " is " + temp);
				break;


			}
			break;
		}

				
				
				
				
	
			
		

		
		/*
		 * Datenpunkt auswählen -> Distanzen berechnen -> zu centroid mit geringster Distanz zuordnen
		 */
		
		
		
	}

}
