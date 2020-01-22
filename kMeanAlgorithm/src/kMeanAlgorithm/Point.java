package kMeanAlgorithm;

public class Point {
	
	private double[] dimensions;
	
	/**
	 * Empty Constructor
	 */
	public Point()
	{
		
	}
		
	/**
	 * This methods updates the given dimensions.
	 * @param varargs dimensions
	 */
	public void setDimensions(double... dimensions)
	{
		this.dimensions = dimensions;
	}
	
	/**
	 * This method returns the dimension of an given datapoint or centroid.
	 * @return double[] dimensions
	 */
	public double[] getDimensions()
	{
		return dimensions;
	}
	
	/**
	 * This method returns the centroid or datapoint as a string in a specific
	 *  format
	 * @return output
	 */
	public String toString()
	{
		String output = " (";
		
		// store every value of the dimensions-array in output except the last one
		//  to obtain the specific format
		for(int i = 0; i < dimensions.length - 1; i++)
		{
			output = output + dimensions[i] + "/";
		}
		
		// store the last value of the dimensions-array
		output = output + dimensions[dimensions.length-1] + ")";
		
		return output;
	}

}
