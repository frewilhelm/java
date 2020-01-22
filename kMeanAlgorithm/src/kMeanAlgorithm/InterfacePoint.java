package kMeanAlgorithm;

import kMeanAlgorithm.InterfaceCentroid;
import kMeanAlgorithm.InterfaceComparableObject;

public interface InterfacePoint extends InterfaceComparableObject 
{
	
	/**
	 * By this method, one can set the centroid of a respective datapoint
	 * @param centroid of type 'InterfaceCentroid'
	 */
	void setCentroid(InterfaceCentroid centroid);
	
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
