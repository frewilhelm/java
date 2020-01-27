package kMeanAlgorithm;

public class Clustering {
	
	private boolean movingCentroids = true;
	
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
		
		while(movingCentroids) {
			assignDatapoints(centroids, datapoints);
			moveCentroids(centroids);
			if(movingCentroids == false) {
				System.out.println("No update to see.. so clustering DONE!");
				break;
			}
		}	
	}
	
	private void assignDatapoints(Centroids centroids, Datapoints datapoints) {
		
		for(int i = 0; i < centroids.amCentroids; i++) {
			for(int j = 0; j < datapoints.amDatapoints; j++) {
				if(i == 0) { // The lpDistance to the first centroid is the reference point. 
					datapoints.getDatapoint(j).setDistance(Double.MAX_VALUE);
				}
				// Compare to previous lpDistance of datapoints.
				if(datapoints.getDatapoint(j).distance > Similarity.getLpDistance(centroids.getCentroid(i), datapoints.getDatapoint(j), datapoints.dimDatapoints)) {
					
					// refresh possible new distance
					datapoints.getDatapoint(j).setDistance(Similarity.getLpDistance(centroids.getCentroid(i), datapoints.getDatapoint(j), datapoints.dimDatapoints));
					printAssignProcess(datapoints.getDatapoint(j), centroids.getCentroid(i));

					if(centroids.getCentroid(i).assignedDatapoints.contains(datapoints.getDatapoint(j))){ // If already in list -> continue
						continue;
					}
					else { // Add datapoint to actual list and remove datapoint, if necessary, from other lists
						centroids.getCentroid(i).assignDatapoint(datapoints.getDatapoint(j));
						for(int z = 0; z < centroids.amCentroids; z++) {
							if(z == i) { // Don't remove from own list
								continue; 
							}

							else{
								if(centroids.getCentroid(z).assignedDatapoints.contains(datapoints.getDatapoint(j))) {
									centroids.getCentroid(z).assignedDatapoints.remove(datapoints.getDatapoint(j));
								}
							}
						}
					}
				}
				else {
					continue;
				}
			}
		}
		// Print results
		for(int i = 0; i < centroids.amCentroids; i++) {
			System.out.println("The " + centroids.getCentroid(i).centroidNumber + ". centroid contains " 
				+ centroids.getCentroid(i).assignedDatapoints.size() + " Datapoints." );
		}	
	}
	
	private void moveCentroids(Centroids centroids) {
		System.out.println("----------------------- \nUpdate centroids: ");
		

		for(int i = 0; i < centroids.amCentroids; i++) {	
			System.out.print(centroids.getCentroid(i).centroidNumber + ". centroid: " + centroids.getCentroid(i));
			for(int z = 0; z < centroids.dimensions; z++) {	
				int sum = 0;
				double mean = 0;
				
				for(int j = 0; j < centroids.getCentroid(i).assignedDatapoints.size(); j++) {
					sum = (int) (sum + centroids.getCentroid(i).assignedDatapoints.get(j).getValue(z));
				}
				mean = sum / centroids.getCentroid(i).assignedDatapoints.size();
				if(mean == centroids.getCentroid(i).getValue(z)) {
					movingCentroids = false;
				}
				centroids.getCentroid(i).updataCentroid(mean, z);
			}
			System.out.println(" --> " + centroids.getCentroid(i));
		}
	}
		
	private void printAssignProcess(Datapoint datapoint, Centroid centroid) {
		System.out.println("Distance between " + datapoint.toString() + " and " + centroid.toString() + " is " + 
				(int) datapoint.distance + " and is assigned to centroid: " + centroid.centroidNumber);
	}



}
