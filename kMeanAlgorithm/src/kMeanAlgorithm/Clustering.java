package kMeanAlgorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;


public class Clustering {
	
	private boolean movingCentroids = true;
	public static Datapoints datapointsGraph;
	public static List<Double[][]> centroidsGraph = new LinkedList<Double[][]>();
	public static int runs;
	public static Double[] maxX;
	public static Double[] maxY;
		
	public Clustering(Centroids centroids, Datapoints datapoints) throws IOException {
		
		runs = 0;	
		while(movingCentroids) {
			centroidsGraph.add(centroids.toArray());
			runs++;
			assignDatapoints(centroids, datapoints);
			moveCentroids(centroids);
			if(movingCentroids == false) {
				System.out.println("After " + runs + " runs there are no changes to observe. Clustering Done!");
			}
		}	
		
		if(centroids.dimensions == 2 && centroids.amCentroids > 1) {
			maxX = new Double[centroids.amCentroids]; // Max x-value[0] from assigned datapoints per centroid
			maxY = new Double[centroids.amCentroids]; // Max y-value[1] from assigned datapoints per centroid
			for(int i = 0; i < centroids.amCentroids; i++) {
				maxX[i] = centroids.getCentroid(i).assignedMaxValueX();
				maxY[i] = centroids.getCentroid(i).assignedMaxValueY();
			}
			datapointsGraph = datapoints;
			Application.launch(Graphic.class);
		}
		else {
			System.out.println("A graphical overview over the clustering-process is not possible due to > 2 value-dimensions or < 1 amount of centroids!");
		}
		
		outputResults(centroids, datapoints);
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

					if(centroids.getCentroid(i).assignedDatapoints.contains(datapoints.getDatapoint(j))){ // If already in list -> continue
						continue;
					}
					else { // Add datapoint to actual list and remove datapoint, if necessary, from other lists
						printAssignProcess(datapoints.getDatapoint(j), centroids.getCentroid(i));

						centroids.getCentroid(i).assignDatapoint(datapoints.getDatapoint(j));
						datapoints.getDatapoint(j).assignToCentroid(i);
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
		
		int iter = 0;		
		int emptyCentroids = 0;
		
		for(int i = 0; i < centroids.amCentroids; i++) {
			System.out.print(centroids.getCentroid(i).centroidNumber + ". centroid: " + centroids.getCentroid(i));	
			boolean print = true;

			for(int z = 0; z < centroids.dimensions; z++) {	
				
				double sum = 0;
				double mean = 0;
				
				if(centroids.getCentroid(i).assignedDatapoints.isEmpty()) {
					mean = centroids.getCentroid(i).getValue(z);	
					print = false;					
				}
				else {
					for(int j = 0; j < centroids.getCentroid(i).assignedDatapoints.size(); j++) {
						sum = (int) (sum + centroids.getCentroid(i).assignedDatapoints.get(j).getValue(z));
					}		
					mean = sum / centroids.getCentroid(i).assignedDatapoints.size();
				}
				if(mean == centroids.getCentroid(i).getValue(z)) {
					iter++;
					print = false;
					if(iter == (centroids.amCentroids - emptyCentroids) * centroids.dimensions) {
						movingCentroids = false;
					}
				}
				centroids.getCentroid(i).updataCentroid(mean, z);
			}
			
			if(print) {
				System.out.println(" --> " + centroids.getCentroid(i) + " --> Change.");
			}
			else {
				System.out.println(" --> " + centroids.getCentroid(i) + " --> No change.");
			}
		}
		System.out.println("-----------------------");
	}
		
	private void printAssignProcess(Datapoint datapoint, Centroid centroid) {
		System.out.println("Distance between " + datapoint.toString() + " and " + centroid.toString() + " is " + 
				(int) datapoint.distance + " and is assigned to centroid: " + centroid.centroidNumber);
	}

	private static void outputResults(Centroids centroids, Datapoints datapoints) throws IOException {
		// Start writing
		BufferedWriter output = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\inputFiles\\results.txt"));
			
		for(int i = 0; i < centroids.amCentroids; i++) {
			if(centroids.getCentroid(i).assignedDatapoints.isEmpty()) {
				output.write("The centroid " + centroids.getCentroid(i).toString() + " has no assigend datapoints.");
			}
			else {
				output.write("The centroid " + centroids.getCentroid(i).toString() + " has the following " + centroids.getCentroid(i).assignedDatapoints.size() + " datapoints assigend to: ");
				output.write(centroids.getCentroid(i).assignedDatapoints.toString());
			}
			output.newLine();
			
		}
		output.close();

	}

}
