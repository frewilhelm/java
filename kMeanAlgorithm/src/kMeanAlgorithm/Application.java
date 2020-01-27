package kMeanAlgorithm;

import java.io.IOException;
import java.util.List;

//import javafx.application.Application;
//import project.Clustering;
//import project.graphProject;

/**
 * This class starts the Project
 * 1. A file is read (CSV or text-whitespace-separated) and stored to stringList
 * 2. From stringList are random centroids picked
 * 3. The remaining points are transformed to datapoints
 * 4. The clustering begins
 * 5. The clustering-result is written in a txt-file
 * 6. A graph of the positions of points and centroids is displayed
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public class Application {
	
	public static Datapoints datapoints;
	public static Centroids centroids;
	private static int amCentroid;
	private static Double[] datapoint;
		
	/**
	 * Reads in a file
	 * Creates points and centroids as well as begins the clsutering-algorithm
	 * Launches the graphical implementation
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Load in files (Files are stored in kMeanAlgorithm\inputFiles)
		String path = System.getProperty("user.dir") + "\\inputFiles\\numberCSV2.csv"; // Use relative path to project.		
		
		datapoints = new Datapoints(path);
		
		//datapoints.print();
		
		amCentroid = 3; // Amount of centroids
		// List of centroids that are randomly picked from datapoints
		centroids = new Centroids(datapoints, amCentroid);
		
		// Start clustering-algo
		new Clustering(centroids, datapoints);
		
		// Not quite the same as in my studies.. but it gets better

		
		
		/*
		 * TODO
		 * - Datastructe for datapoint
		 *   - Datapoints: Value, Dimensions, Amount of Datapoints, Relate to which centroid
		 *     - List of doubles[][]
		 *     - Datapoint: double[]; needed to know the relationship to the centroids?
		 *   - Centroids: Value, Dimensions, Amount of Centroids, Amount of Datapoints
		 *     - List of doubles[]
		 *     - Centroid: double
		 *   
		 * - Graphic
		 *   - Interactive GUI
		 *   - Circle around Centroid; range till datapoint that is the farest.
		 *   
		 * - similarity calculation
		 *   - euclid
		 *   
		 * - kMean-Algo
		 *   - use similarity to assign datapoints to centroids
		 *   - move centroids to the mid of assigned datapoints
		 *   - Recursive above until no change in moving centroids occurs
		 */
		

		
		
	}	
}
		
		
		
		
		
		
		