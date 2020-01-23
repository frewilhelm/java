package kMeanAlgorithm;

/**
 *  * An interface for points that extends the interface of comparable objects.
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public interface IFPoint extends IFComparableObject  {

	/**
	 * By this method, one can set the centroid of a respective datapoint
	 * @param centroid of type 'InterfaceCentroid'
	 */
	void setCentroid(IFCentroid centroid);
	
	/**
	 * This method sets the calculated distance to the closest centroid of a given datapoint
	 * @param double distance
	 */
	void setDistanceToClosestCentroid(double distance);
	
	/**
	 * This method returns the distance of a datapoint to the closest centroid.
	 * @return double
	 */
	double getDistanceToClosestCentroid();
}
