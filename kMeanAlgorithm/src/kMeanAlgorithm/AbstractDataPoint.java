package kMeanAlgorithm;

/**
 * Abstract class of datapoints in general(?). used in DataPoint.java
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public abstract class AbstractDataPoint extends Point implements IFPoint {

	private IFCentroid centroid;
	private double distanceToClosestCentroid = Double.MAX_VALUE; // set as max so k-mean can start
	
	/**
	 * Empty constructor
	 */
	public AbstractDataPoint()
	{
		
	}
	
	/**
	 * By this method, one can set the centroid of a respective datapoint
	 * @param centroid of type 'InterfaceCentroid'
	 */
	public void setCentroid(IFCentroid centroid)
	{
		this.centroid = centroid;
	}
	
	/**
	 * This method returns the specific centroid of the respecitve datapoint
	 * @return double[] centroid
	 */
	public IFCentroid getCentroid()
	{
		return this.centroid;
	}
	
	/**
	 * This method returns the distance of a datapoint to the closest centroid.
	 * @return double
	 */
	public double getDistanceToClosestCentroid()
	{
		return this.distanceToClosestCentroid;
	}
	
	/**
	 * This method sets the calculated distance to the closest centroid of a given datapoint
	 * @param double distance
	 */
	public void setDistanceToClosestCentroid(double distance)
	{
		this.distanceToClosestCentroid = distance;
	}
	
}
