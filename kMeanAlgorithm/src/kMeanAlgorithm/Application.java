package kMeanAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import project.Clustering;
import project.graphProject;

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
	
	List<Object[]> stringList = new ArrayList<Object[]>();

	
	/**
	 * Reads in a file
	 * Creates points and centroids as well as begins the clsutering-algorithm
	 * Launches the graphical implementation
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Initialize a list to store file-parts
		List<Object[]> stringList = new ArrayList<Object[]>();
		
		/*
		 * You can choose a file (Files are stored in the workspace in the respective folder!)
		 */
		
		File file = new File("numberCSV.csv");		
		//File file = new File("textCSV.csv");		
		//File file = new File("numberTxt.txt"); // One dimensional! NOT for graphic implementation!
		//File file = new File("stringsTxt.txt");
		
		// Read file in
		File.readFile(file, stringList);
		
		
	}
		
		
		
		
		
		
}
		
		
		
		
		
		
		