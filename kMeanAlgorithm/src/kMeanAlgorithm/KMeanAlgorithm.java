package kMeanAlgorithm;

import java.io.IOException;

/**
 * This class starts the Project
 * 1. A file is read (CSV) and stored as datapoints
 * 2. From datapoints are random centroids picked
 * 3. The clustering begins (calc lp-distance between centroids and datapoints)
 * 5. The clustering-result is written in a txt-file
 * 6. A graph of the positions of points and centroids is displayed
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public class KMeanAlgorithm {
	
	public static Datapoints datapoints;
	public static Centroids centroids;
	private static int amCentroid;
		
	/**
	 * Reads in a file
	 * Creates points and centroids as well as begins the clsutering-algorithm
	 * Launches the graphical implementation
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Load in files (Files are stored in kMeanAlgorithm\inputFiles)
		String path = System.getProperty("user.dir") + "\\inputFiles\\numberCSV.csv"; // Use relative path to project.		
		//String path = System.getProperty("user.dir") + "\\inputFiles\\textCSV.csv"; // Use relative path to project.		

		
		datapoints = new Datapoints(path, "numbers");
		
		//datapoints.print();
		
		amCentroid = 2; // Amount of centroids
		// List of centroids that are randomly picked from datapoints
		centroids = new Centroids(datapoints, amCentroid);
		
		// Start clustering-algo
		new Clustering(centroids, datapoints);				
	}	
}
		
		
		
		
		
		
		