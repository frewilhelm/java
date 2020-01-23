package kMeanAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public class CentroidPoint extends Point implements IFCentroid {

	public static int nrOfCentroids;
	
	public static boolean change = true;	// Boolean to check, if the kMean algorithm has to stop or not

	private final int clusterMembership;	// This centroid belongs to a specific cluster

	private List<IFPoint> points = new ArrayList<>();	// List of datapoints
	
	/**
	 * Constructor that can contain a various amount of points.
	 * Additionally the nrOfCentroids gets incremented to know to which centroids the datapoints are assigned
	 *  (see toString()).
	 * @param dimnesion
	 */
	public CentroidPoint(double... dimensions)
	{
		this.setDimensions(dimensions);
		
		nrOfCentroids++;
		this.clusterMembership = nrOfCentroids;
	}

	/**
	 * This method returns the value of 'clusterMembership'
	 * @return integer
	 */
	public int getClusterMembership()
	{
		return this.clusterMembership;
	}
	
	/**
	 * This methord returns the ArrayList of datapoints that are assigned to the respective centroid
	 * @return ArrayList with datapoints (also if datastrings)
	 */
	public List<IFPoint> getAssignedDataPoints()
	{
		return this.points;
	}
		
	/**
	 * Returns the respective centroid
	 * @return centroid
	 */
	public CentroidPoint getCentroid()
	{
		return this;
	}
	
	/**
	 * This method removes a datapoint (also if datastring) from the list of assigned datapoints.
	 * @param point
	 */
	public void removeAssignedDataPoints(IFPoint point)
	{
		points.remove(point);
	}
	
	/**
	 * This method adds a datapoint (also if datastring) to the respective centroid
	 * @param point
	 */
	public void addAssignedDataPoints(IFPoint point)
	{
		points.add(point);
	}
	
	/**
	 * This method returns the centroid as a string in a specific format
	 * @return output
	 */
	public String toString()
	{
		return "Centroid" + clusterMembership + super.toString() + " size: " + this.getAssignedDataPoints().size();
	}

	/**
	 * This method updates the dimensions
	 * @param varargs dimensions
	 */
	public void updateDimensions(double... dimensions)
	{
		this.setDimensions(dimensions);
	}

}
