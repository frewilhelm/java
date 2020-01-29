package kMeanAlgorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Data-class is used to read in the given file by the path and type-param. Depending on the type a reader is chosen.
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 */
@SuppressWarnings("serial")
public class Data extends File {

	private static String fileName;
	public int rows;
	public int dimensions;
	public Datapoints list;
	private double tempDatapoint;
	private Double[] tempList;
	private List<Datapoint> datapoints = new LinkedList<>();
	public Datapoint datapoint;

	/*
	 * Generic Given Constructor by extended class "File"
	 */
	public Data(String pathname) {
		super(pathname);
	}

	/**
	 * In "readFile" the correct read-method is chosen
	 * @param type - strings/numbers, depending on input-content
	 * @return List<Datapoint> - return a list of datapoints
	 * @throws IOException
	 */
	public List<Datapoint> readFile(String type) throws IOException {
		
		fileName = this.getName(); // Get name of file
		
		// Check if it is .csv file
		if(fileName.matches("([a-zA-Z0-9\\s_\\.\\-\\(\\):])+(.csv)$")) {
			System.out.print(".csv data detected");		
			if(type == "strings") {
				System.out.print(" and these are strings! ");
				return readCSVStrings(this); // start the reader for .csv file with strings
			}			
			if(type == "numbers") {
				System.out.print(" and these are numbers! ");	
				return readCSVDoubles(this); // start the reader for .csv file with numbers
			}			
			else {
				throw new RuntimeException("Your data-type is not declared/supported. Add parameters 'strings' or 'numbers' or adjust your data.");
			}
		}
		else {
			throw new RuntimeException("Your file-format is not supported. Only .csv are able, yet!");	
		}	
	}
	
	/**
	 * readCSVDoubles reads a given .csv file that contains numbers
	 * @param path - String with path to the file
	 * @return List <Datapoint> - returns a list with datapoints
	 * @throws IOException
	 */
	private List<Datapoint> readCSVDoubles(Data data) throws IOException {
		
		BufferedReader input = new BufferedReader(new FileReader(data)); // Start reader
		String line; // Stores the lines from file
		String[] tempString; // Stores the separated parts from file
		rows = 0; // If it is csv, we have to consider the dimensions

		// Read line for line
		while((line = input.readLine()) != null)
		{
			tempString = line.split("[,;]"); // since CSV
			tempList = new Double[tempString.length]; // declare array
			
			for(int i = 0; i < tempString.length; i++) {			
				String temp = tempString[i];
				try {
					tempDatapoint = Double.parseDouble(temp);		
				} catch (NumberFormatException e) {
					throw new RuntimeException("The content of your file isn't a number. Try param 'strings' !");	
				}
				tempList[i] = tempDatapoint;
				dimensions = i + 1;
			}
			
			datapoint = new Datapoint(tempList);
			datapoints.add(datapoint);
			rows++; // Increments with every line, so we know how many points we have actually			
		}
		System.out.println("The file " + fileName + " has " + dimensions + " dimensions and " + rows + " datapoints.");
		// close reading
		input.close();
		return datapoints;
	}
	
	/**
	 * readCSVStrings reads a given .csv file that contains strings
	 * @param path - String with path to the file
	 * @return List <Datapoint> - returns a list with datapoints
	 * @throws IOException
	 */
	private List<Datapoint> readCSVStrings(Data data) throws IOException {
		
		BufferedReader input = new BufferedReader(new FileReader(data)); // Start reader
		String line; // Stores the lines from file
		String[] tempString; // Stores the separated parts from file
		
		// Read line for line
		while((line = input.readLine()) != null)
		{
			tempString = line.split("[,;]"); // since CSV			

			for(int i = 0; i < tempString.length; i++) {		
				tempList = new Double[2]; // per String there are two dimensions
				
				String temp = tempString[i].toLowerCase();
				if(temp.matches("[0-9]+")) {
					throw new RuntimeException("The content of your file isn't a string. Try param 'numbers' !");	
				}
				tempList[0] = (double) temp.length();
				tempList[1] = uniqueLetters(temp);
				dimensions = 2;
				datapoint = new Datapoint(tempList);
				datapoints.add(datapoint);
			}
		}
		System.out.println("The file " + fileName + " has " + dimensions + " dimensions and " + datapoints.size() + " datapoints.");
		// close reading
		input.close();
		return datapoints;
	}
	
	/**
	 * uniqueLetters returns a double with the amount of unique letters
	 * @param string
	 * @return double - amount of unique letters in given string
	 */
	private double uniqueLetters(String string) {
		
		String uniqueLetters = "";
		
		// go step by step through string
		for(int i = 0; i < string.length(); i++)
		{
			if(uniqueLetters.indexOf(string.charAt(i)) == -1) // if string[i] is not found, add string[i] to uniqueLetters
			{
				uniqueLetters = uniqueLetters + string.charAt(i); // Add to uniqueLetters, if it is not contained yet
			}
		}
		return uniqueLetters.length();
	}
}
