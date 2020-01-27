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
	
	public List<Datapoint> datapoints;
	private Data data;
	public int amDatapoints;
	public int dimDatapoints;
	public String dataName;
	
	/**
	 * Constructor
	 * @throws IOException 
	 */
	public Datapoints(String path) throws IOException {
		data = new Data(path);
		this.datapoints = data.readFile("numbers");
		this.amDatapoints = data.rows;
		this.dimDatapoints = data.dimensions;
		this.dataName = data.getName();
	}
	
	/**
	 * Print all datapoints.
	 */
	public void print() {	
		for(int i = 0; i < amDatapoints; i++) {
			datapoints.get(i).print();
		}
	}
	
	public Datapoint getDatapoint(int row) {
		return this.datapoints.get(row);
	}
	
	public void removeDatapoint(int row) {
		this.datapoints.remove(row);
	}
	
	public void updateAmount() {
		this.amDatapoints--;
	}
	
	public void add(Datapoint datapoint) {
		
	}

}
