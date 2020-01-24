package kMeanAlgorithm;

import java.io.BufferedReader;
import java.io.File;
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
	private List<Double[]> datapoints = new LinkedList<>();

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
	public List<Double[]> readFile(String type) throws IOException {
		
		fileName = this.getName(); // Get name of file
						
		if(fileName.matches("([a-zA-Z0-9\\s_\\.\\-\\(\\):])+(.csv)$")) { // If .csv
			System.out.print(".csv data detected");		
			if(type == "strings") {
				System.out.print(" and these are strings! ");
				//return readCSV(this);
				return null;
			}			
			if(type == "numbers") {
				System.out.print(" and these are numbers! ");	
				return readCSVDoubles(this);
			}			
			else {
				throw new RuntimeException("Your data-type is not declared/supported. Add parameters 'strings' or 'numbers' or adjust your data.");
			}
		}
		
		if(fileName.matches("([a-zA-Z0-9\\s_\\.\\-\\(\\):])+(.txt)$")){ // If .txt
			System.out.print(".txt data detected. Whitespaces assumed. ");
			if(type == "strings") {
				System.out.print("These are strings! ");
				//return readTxt(this);
				return null;
			}			
			if(type == "numbers") {
				System.out.print("These are numbers! ");	
				//return readTxt(this);
				return null;
			}			
			else {
				throw new RuntimeException("Your data-type is not declared/supported. Add parameters 'strings' or 'numbers' or adjust your data.");
			}
		}
		
		else {
			throw new RuntimeException("Your file-format is not supported. Only .csv and .txt are able, yet!");	
		}	
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 * @throws IOException
	 */
	private List<Object> readTxt(Data data) throws IOException {
		
		BufferedReader input = new BufferedReader(new FileReader(data)); // Start reader
		String line; // Stores the lines from file
		String[] tempArray; // Stores the separated parts from file
				
		//list = new ArrayList<Object>();
		
		while((line = input.readLine()) != null) // read line for line
		{
			tempArray = line.split("\\s"); // since CSV
			
			for(int i = 0; i < tempArray.length; i++) {			
				String temp = tempArray[i];
				temp = temp.toLowerCase();
				Object tempObject = (Object) temp;
				//list.add(tempObject);				
			}
		}
			
		dimensions = 0;
		//System.out.println("No clear structure of " + fileName + " wherefore we don't know if it has dimensions. But there are " + list.size() + " data points.\n");
		
		// close reading
		input.close();
		//return list;
		return null;
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private List<Double[]> readCSVDoubles(Data data) throws IOException {
		
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
				tempDatapoint = Double.parseDouble(temp);		
				tempList[i] = tempDatapoint;
				dimensions = i + 1;
			}
			
			//datapoint = new Datapoint(tempList);
			datapoints.add(tempList);
			
			rows++; // Increments with every line, so we know how many points we have actually
			
		}
		
		//dimLength = list.size() / rows; // dimensions
		
		System.out.println("The file " + fileName + " has " + dimensions + " dimensions and " + rows + " datapoints.\n");
		
		// close reading
		input.close();
		return datapoints;
	}
	

	
	
	
	
}
