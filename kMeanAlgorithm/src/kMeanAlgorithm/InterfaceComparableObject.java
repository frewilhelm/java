package kMeanAlgorithm;

public interface InterfaceComparableObject 
{
	
	/**
	 * By this method, one gets the centroid-dimensions of a respective datapoint
	 * @return centroid
	 */
	public InterfaceCentroid getCentroid();
	
	/**
	 * This method returns the values of a centroid or a datapoint, that are stored in an array.
	 *  Depeding on the given input (see Project.java) there can be several dimensions
	 * @return double[]
	 */
	double[] getDimensions();

}
