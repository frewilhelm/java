package kMeanAlgorithm;

import java.io.IOException;
import java.util.*;

/**
 * This defines the datastructure that contains the datapoints of the data
 * - double[][]
 * 
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public class Datapoints {
	
	public List<Double[]> datapoints;
	private Data data;
	public int amDatapoints;
	public int dimDatapoints;
	
	/**
	 * Constructor
	 * @throws IOException 
	 */
	public Datapoints(String path) throws IOException {
		data = new Data(path);
		this.datapoints = data.readFile("numbers");
		this.amDatapoints = data.rows;
		this.dimDatapoints = data.dimensions;
	}
	
	/**
	 * Print all datapoints.
	 */
	public void print() {	
		for(int i = 0; i < amDatapoints; i++) {
			System.out.print("[" + this.datapoints.get(i)[0]);
			for(int j = 1; j < dimDatapoints; j++) {
				System.out.print(", " +this.datapoints.get(i)[j]);
			}
			System.out.println("]");
		}	
	}
	
	public Double getValues(int row, int dimension) {
		return this.datapoints.get(row)[dimension];
	}
	
	public Double[] getDatapoint(int row) {
		return this.datapoints.get(row);
	}


	public void add(Double[] datapoint) {
		//datapoints.add(datapoint);
	}

}
