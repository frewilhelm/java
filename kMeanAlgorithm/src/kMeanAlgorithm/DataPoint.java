package kMeanAlgorithm;

/**
 * Datastructure of datapoints
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public class DataPoint extends AbstractDataPoint {

	/**
	 * Constructor that can contain a various amount of points.
	 * @param dimension
	 */
	public DataPoint(double... dimensions)
	{
		this.setDimensions(dimensions);
	}
	
	/**
	 * This method prints the datapoint as a string in a specific format
	 */
	public String toString()
	{
		return "Point" + super.toString();
	}

}
