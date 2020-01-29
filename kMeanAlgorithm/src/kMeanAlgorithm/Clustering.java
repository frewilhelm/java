package kMeanAlgorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;

/**
 * This class is used to start the clustering-algorithm
 * 1. Constructor starts to assign datapoints to centroids
 * 2. Centroids are moved to the mean of the aforementioned datapoints
 * 3. redo 1 & 2 until centroids are not moving anymore
 * 4. store results in txt
 * 5. show graph if dim = 2 & enough centroids (> 1)
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 */
public class Clustering {
	
	private boolean movingCentroids = true; // boolean to check if centroids are still moving
	public static Datapoints datapointsGraph; // list that has to be used in Graphic.java 
	public static List<Double[][]> centroidsGraph = new LinkedList<Double[][]>(); // list that has to be used in Graphic.java 
	public static int runs; // Amount of runs until centroids don't move anymore
	public static Double[] maxX; // Array with max values of the first dimension. Used in Graphic.java
	public static Double[] maxY; // Array with max values of the second dimension. Used in Graphic.java
		
	/**
	 * Constructor that starts the recursive kMean-Algo
	 * @param centroids
	 * @param datapoints
	 * @throws IOException
	 */
	public Clustering(Centroids centroids, Datapoints datapoints) throws IOException {
		
		runs = 0;	
		while(movingCentroids) {
			centroidsGraph.add(centroids.toArray()); // Add old and updated centroids for Graphic.java
			runs++;
			assignDatapoints(centroids, datapoints);
			moveCentroids(centroids);
			if(movingCentroids == false) {
				System.out.println("After " + runs + " runs there are no changes to observe. Clustering Done!");
			}
		}	
		
		// Graphic implementation (if only 2 dimensions -> X/Y && more than one centroid)
		if(centroids.dimensions == 2 && centroids.amCentroids > 1) {
			maxX = new Double[centroids.amCentroids]; // Max x-value[0] from assigned datapoints per centroid
			maxY = new Double[centroids.amCentroids]; // Max y-value[1] from assigned datapoints per centroid
			for(int i = 0; i < centroids.amCentroids; i++) {
				maxX[i] = centroids.getCentroid(i).assignedMaxValueX();
				maxY[i] = centroids.getCentroid(i).assignedMaxValueY();
			}
			datapointsGraph = datapoints; // List with all datapoints
			Application.launch(Graphic.class);
		}
		else {
			System.out.println("A graphical overview over the clustering-process is not possible due to > 2 value-dimensions or < 1 amount of centroids!");
		}
		
		// Store results in .txt
		outputResults(centroids, datapoints);
	}
	
	/**
	 * By this method the datapoints are assigned to the centroid that is closest (lp-distance)
	 * @param centroids
	 * @param datapoints
	 */
	private void assignDatapoints(Centroids centroids, Datapoints datapoints) {	
		for(int i = 0; i < centroids.amCentroids; i++) { // Start loop over centroids
			for(int j = 0; j < datapoints.amDatapoints; j++) { // Start loop over datapoints
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
						printAssignProcess(datapoints.getDatapoint(j), centroids.getCentroid(i)); // print process
						centroids.getCentroid(i).assignDatapoint(datapoints.getDatapoint(j)); // assign datapoint
						datapoints.getDatapoint(j).assignToCentroid(i); // assign centroid to datapoint. (For colors in Graphic.java)
						// If necessary, remove datapoint from another centroids.assigned list.
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
				else { // If distance not greater -> continue
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
	
	/**
	 * In this method the mean of the dimensions of the assigned datapoints of the respective centroids is calculated
	 *  and the centroid-value is updated.
	 * @param centroids
	 */
	private void moveCentroids(Centroids centroids) {
		System.out.println("----------------------- \nUpdate centroids: ");
		
		int iter = 0;		
		int emptyCentroids = 0;
		
		// Loop over centroids
		for(int i = 0; i < centroids.amCentroids; i++) {
			System.out.print(centroids.getCentroid(i).centroidNumber + ". centroid: " + centroids.getCentroid(i));	
			boolean print = true; // differs between centroids with assigned datapoints and if centroids are moving
			
			// Loop over respective centroid-dimensions
			for(int z = 0; z < centroids.dimensions; z++) {	
				
				double sum = 0;
				double mean = 0;
				
				// If a centroid has no assigned datapoints -> centroid-values are not updated
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
				// If the new mean is the same as the centroid-value it is not updated and moved
				if(mean == centroids.getCentroid(i).getValue(z)) {
					iter++;
					print = false;
					// If every mean is the same as the centroid-values the kMean-Algo can stop
					// (Iter = Amount of non-changing centroid-values
					//  Iter has to equal the amount of all values of every centroid 
					//   MINUS values that did not change, since they are not noticed
					if(iter == (centroids.amCentroids - emptyCentroids) * centroids.dimensions) {
						movingCentroids = false;
					}
				}
				// Update centroids
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
		
	/**
	 * print process
	 * @param datapoint
	 * @param centroid
	 */
	private void printAssignProcess(Datapoint datapoint, Centroid centroid) {
		System.out.println("Distance between " + datapoint.toString() + " and " + centroid.toString() + " is " + 
				(int) datapoint.distance + " and is assigned to centroid: " + centroid.centroidNumber);
	}

	
	
	/**
	 * Method that writes the final results in a .txt-file
	 * - Updated centroids and their assigned datapoints.
	 * @param centroids
	 * @param datapoints
	 * @throws IOException
	 */
	private static void outputResults(Centroids centroids, Datapoints datapoints) throws IOException {
		// Start writing
		BufferedWriter output = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\inputFiles\\results.txt"));
	
		// Loop for every centroid
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
