package kMeanAlgorithm;

import java.io.IOException;
import java.util.*;

/**
 * This defines the datastructure that contains the datapoints of the data
 *
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 */
public class Datapoints {
	
	public List<Datapoint> datapoints;
	private Data data;
	public int amDatapoints;
	public int dimDatapoints;
	public String dataName;
	
	/**
	 * Constructor starts the constructor of class Data, by which the data is read and returned as List<Datapoint>
	 * @throws IOException 
	 */
	public Datapoints(String path, String type) throws IOException {
		data = new Data(path);
		this.datapoints = data.readFile(type);
		this.amDatapoints = data.rows;
		this.dimDatapoints = data.dimensions;
		this.dataName = data.getName();
	}
	
	/**
	 * Getter for datapoint in datapoints
	 * @param index
	 * @return datapoint - Given datapoint at index
	 */
	public Datapoint getDatapoint(int index) {
		return this.datapoints.get(index);
	}
	
	/**
	 * Remove datapoint in datapoints. (Used to chose random centroids and remove these datapoints from the list.)
	 * @param index
	 */
	public void removeDatapoint(int index) {
		this.datapoints.remove(index);
	}
	
	/**
	 * Update amount of datapoints, when random centroids are chosen.
	 */
	public void updateAmount() {
		this.amDatapoints--;
	}
}
