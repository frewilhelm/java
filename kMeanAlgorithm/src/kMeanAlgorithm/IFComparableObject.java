package kMeanAlgorithm;

/**
 * An interface of the datastructure of comparable objects.
 *  Necessary to compare datapoints and centroids
 *  
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public interface IFComparableObject {

	/**
	 * By this method, one gets the centroid-dimensions of a respective datapoint
	 * @return centroid
	 */
	public IFCentroid getCentroid();
	
	/**
	 * This method returns the values of a centroid or a datapoint, that are stored in an array.
	 *  Depeding on the given input (see Application.java) there can be several dimensions
	 * @return double[]
	 */
	double[] getDimensions();	
}
