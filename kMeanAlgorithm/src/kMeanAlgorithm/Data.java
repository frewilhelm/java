package kMeanAlgorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
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

	public Data(String pathname) {
		super(pathname);
	}

	/**
	 * Object[] file, since not clear if number or strings. 
	 * @param file - only support .csv/.txt
	 * @param listNcsv
	 * @return
	 * @throws IOException
	 */
	public List<Datapoint> readFile(String type) throws IOException {
		
		fileName = this.getName(); // Get name of file
						
		if(fileName.matches("([a-zA-Z0-9\\s_\\.\\-\\(\\):])+(.csv)$")) { // If .csv
			System.out.print(".csv data detected");		
			if(type == "strings") {
				System.out.print(" and these are strings! ");
				return readCSVStrings(this);
			}			
			if(type == "numbers") {
				System.out.print(" and these are numbers! ");	
				return readCSVDoubles(this);
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
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private List<Datapoint> readCSVDoubles(Data data) throws IOException {
		
		BufferedReader input = new BufferedReader(new FileReader(data)); // Start reader
		String line; // Stores the lines from file
		String[] tempString; // Stores the separated parts from file
		rows = 0; // If it is csv, we have to consider the dimensions

		while((line = input.readLine()) != null) // read line for line
		{
			tempString = line.split("[,;]"); // since CSV
			
			tempList = new Double[tempString.length];

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
	
	private List<Datapoint> readCSVStrings(Data data) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(data)); // Start reader
		String line; // Stores the lines from file
		String[] tempString; // Stores the separated parts from file
		rows = 0; // If it is csv, we have to consider the dimensions

		while((line = input.readLine()) != null) // read line for line
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
				rows++;
			}
		}
		System.out.println("The file " + fileName + " has " + dimensions + " dimensions and " + rows + " datapoints.");
		// close reading
		input.close();
		return datapoints;
	}
	
	
	private double uniqueLetters(String string) {
		String uniqueLetters = "";
		
		for(int i = 0; i < string.length(); i++)
		{
			if(uniqueLetters.indexOf(string.charAt(i)) == -1)
			{
				uniqueLetters = uniqueLetters + string.charAt(i); // Add to uniqueLetters, if it is not contained yet
			}
		}
		
		return uniqueLetters.length();
	}
	
	
	
	
}
