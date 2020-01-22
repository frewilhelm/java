package kMeanAlgorithm;

import java.util.List;

public interface InterfaceCentroid extends InterfaceComparableObject 
{
	
	/**
	 * This method removes a datapoint (also if datastring) from the list of assigned datapoints.
	 * @param point
	 */
	void removeAssignedDataPoints(InterfacePoint point);
	
	/**
	 * This method adds a datapoint (also if datastring) to the respective centroid
	 * @param point
	 */
	void addAssignedDataPoints(InterfacePoint point);
	
	/**
	 * By this method, one gets all assigned datapoints (also if datastring) from the respective
	 *  centroid
	 * @return List<InterfacePoint>
	 */
	public List<InterfacePoint> getAssignedDataPoints();
	
	/**
	 * This method updates the dimensions
	 * @param varargs dimensions
	 */
	void updateDimensions(double... dimensions);

}
