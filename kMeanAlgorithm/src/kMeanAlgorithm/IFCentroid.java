package kMeanAlgorithm;

import java.util.List;

/**
 * An interface for centroid-points that extends the interface of comparable objects.
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public interface IFCentroid extends IFComparableObject {
	
	/**
	 * This method removes a datapoint (also if datastring) from the list of assigned datapoints.
	 * @param point
	 */
	void removeAssignedDataPoints(IFPoint point);
	
	/**
	 * This method adds a datapoint (also if datastring) to the respective centroid
	 * @param point
	 */
	void addAssignedDataPoints(IFPoint point);
	
	/**
	 * By this method, one gets all assigned datapoints (also if datastring) from the respective
	 *  centroid
	 * @return List<InterfacePoint>
	 */
	public List<IFPoint> getAssignedDataPoints();
	
	/**
	 * This method updates the dimensions
	 * @param varargs dimensions
	 */
	void updateDimensions(double... dimensions);

}
