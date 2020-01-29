package kMeanAlgorithm;

import java.io.IOException;

/**
 * This class starts the kMean-Algorithm
 * 1. A file is read (CSV) and stored as datapoints
 * 2. From datapoints are random centroids picked
 * 3. The clustering begins (calc lp-distance between centroids and datapoints)
 * 5. The clustering-result is written in a txt-file
 * 6. A graph of the positions of points and centroids is displayed
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 */
public class KMeanAlgorithm {
	
	public static Datapoints datapoints;
	public static Centroids centroids;
	private static int amCentroid;
		
	/**
	 * Main-function that runs the program.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Store directory of input-file
		String path = System.getProperty("user.dir") + "\\inputFiles\\numberCSV.csv"; // Use relative path to project.		
		//String path = System.getProperty("user.dir") + "\\inputFiles\\textCSV.csv"; // Use relative path to project.		

		// Use directory-string + @param type to load in the file and store it as datapoints.
		datapoints = new Datapoints(path, "numbers");	
		
		// Chose amount of centroids
		amCentroid = 5; 
		
		// List of centroids that are randomly picked from datapoints
		centroids = new Centroids(datapoints, amCentroid);
		//centroids.prinOverview(); // prints overview over centroids
		
		// Start clustering-algo
		new Clustering(centroids, datapoints);				
	}	
}
		
		
		
		
		
		
		