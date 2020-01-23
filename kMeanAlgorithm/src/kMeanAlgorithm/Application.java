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
	
	static DataPoint datapoints;
	public static Data data;
		
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
		
		Data data = new Data(path);
		DataPoint datapoint = data.readFile("numbers");
		data.readFile("numbers");
		
		System.out.println(data);
		
		
		//List<Object> x = data.readFile(path, "numbers");
		
		//System.out.println(x);
		
		//data.readFile(path + "\\inputFiles\\numberCSV.csv", "numbers");
		
		//System.out.println(textCSV);
				
				//new Data(path + "\\inputFiles\\numberCSV.csv", "numbers");		
		//Data textCSV = new Data(path);		
		//Data numberTxt = new Data(path + "\\inputFiles\\numberTxt.txt"); // One dimensional! NOT for graphic implementation!
		//Data stringsTxt = new Data(path + "\\inputFiles\\stringsTxt.txt");
		
		//data = textCSV.readFile("strings");
		//Data numberCSVList = numberCSV.readFile("numbers");
		//List<Object> textCSVList = textCSV.readFile("strings");
		//List<Object> numberTxtList = numberTxt.readFile("numbers");
		//List<Object> stringsTxtList = stringsTxt.readFile("strings");

		//System.out.println(numberCSV);
		
		//System.out.println(textCSV);
		//System.out.println(path + "\\inputFiles\\textCSV.csv");
		
		
		//System.out.println(numberCSVList);
		//System.out.println(textCSVList);
		//System.out.println(numberTxtList);
		//System.out.println(stringsTxtList);
		
		
		// Random centroids are chosen. Amount depending on amountOfCentroids
		//List<InterfaceCentroid> centroids = CentroidPoint.randomCentroids(numberCSVList, 2);
		
		// Create method that gets datapoints from list
		//System.out.println(numberCSV.rows);
		//datapoints.transfDataPoints(numberCSV);
		
		/*
		 * TODO
		 * - Point-Datastructure
		 * - Datapoints
		 * - Centroids
		 * - kMean-Algo
		 * - similarity-calc
		 */

		
		
	}	
}
		
		
		
		
		
		
		