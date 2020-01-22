package kMeanAlgorithm;

public class DataPoint extends AbstractDataPoint 
{
	
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