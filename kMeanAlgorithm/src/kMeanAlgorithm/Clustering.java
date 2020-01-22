package kMeanAlgorithm;

import java.util.Iterator;
import java.util.List;

public class Clustering 
{
			
	/**
	 * By this constructor the kMean algorithm is started. 
	 * @param centroids
	 * @param points
	 */
	public Clustering(List<InterfaceCentroid> centroids, List<InterfacePoint> points)
	{
		//kMean-algorithm
		while(CentroidPoint.change)	// Boolean-check, if moving the centroids make a difference
		{
			CentroidPoint.change = false;

			assignDataPointToCentroids(centroids, points);  // Assigns datapoints to centroids

			if(CentroidPoint.change == true)	// If there are assigned datapoints, move the centroid
			{
				moveCentroids(centroids);
			}
			else	 // If there are no new assigned datapoints the clustering is done
			{
				System.out.println("No change!");
			}
		}
		System.out.println("Clustering DONE");
	}
		
	/**
	 * This method assigns the datapoints to the centroid
	 * @param centroids
	 * @param points
	 */
	private void assignDataPointToCentroids(List<InterfaceCentroid> centroids, List<InterfacePoint> points)
	{
		System.out.println("Assign data points to centroids");

		Iterator<InterfaceCentroid> iterCen = centroids.iterator();	// Iterate over every centroid
		
		while(iterCen.hasNext())
		{
			InterfaceCentroid centroid = iterCen.next();
			
			Iterator<InterfacePoint> iterPoints = points.iterator();	// For every centroid, iter over every datapoint if LpDistance is bigger than before
		
			while(iterPoints.hasNext())
			{
				InterfacePoint point = iterPoints.next();

				// Assign datapoints to centroids based on the distance
				// If the datapoint already belongs to the closest centroid there will be no further calculations
				if(point.getDistanceToClosestCentroid() > Similarity.getLpDistance(centroid, point) && point.getCentroid() != centroid)
				{
					CentroidPoint.change = true;	// run again, if change
					
					// Remove data point from assigned centroid if assigned to another
					if(point.getCentroid() != null)
					{
						point.getCentroid().removeAssignedDataPoints(point);;
					}
					
					// Update the point to contain information about the new centroid
					point.setDistanceToClosestCentroid(Similarity.getLpDistance(centroid, point));
					point.setCentroid(centroid);
						
					// Update new centroid
					centroid.addAssignedDataPoints(point);
					
					// Print what happened
					System.out.println("The L" + Similarity.pValue + "-distance between: " + centroid + " and " + point + " = " + Similarity.getLpDistance(centroid, point));
					System.out.println(point + " is assigned to cluster " + point.getCentroid());
				}
			}
		}
	}
		
	/**
	 * This method is used after the datapoints were assigned to a specific centroid. The next step, is to calculate
	 *  the new position of the centroids by using moveSingleCentroid(centroid). Furthermore, the Lp-distance gets
	 *  updated.
	 * @param centroids
	 */
	private void moveCentroids(List<InterfaceCentroid> centroids)
	{
		System.out.println("Move centroids");
		Iterator<InterfaceCentroid> iterCen = centroids.iterator();
		while(iterCen.hasNext())
		{
			InterfaceCentroid centroid = iterCen.next();
			moveSingleCentroid(centroid);
			updateDistances(centroid);
		}
	}
	
	/**
	 * This method calculates the new position of the choosen centroid by calculating the mean of the assigned datapoints.
	 *  If no datapoints were assigned, the centroid remains on its position.
	 * @param centroids
	 * @param centroid
	 */
	private void moveSingleCentroid(InterfaceCentroid centroid)
	{
		// Only change centroid, if there are datapoints assigned to it
		if(centroid.getAssignedDataPoints().size() > 0)
		{
			Iterator<InterfacePoint> iterPoints = centroid.getAssignedDataPoints().iterator();	// all datapoints that are assigned to respective centroid

			if(iterPoints.hasNext())
			{
				double[] mid = new double[centroid.getAssignedDataPoints().get(0).getDimensions().length]; // length of centroids
			
				while(iterPoints.hasNext())
				{
					InterfacePoint point = iterPoints.next();
					for(int i = 0; i < point.getDimensions().length; i++)
					{
						mid[i] = mid[i] + point.getDimensions()[i]; 
					}
				}
					
				for(int i = 0; i < centroid.getDimensions().length; i++)
				{
					mid[i] = mid[i] / centroid.getAssignedDataPoints().size();	// move centroid
				}
				
				centroid.updateDimensions(mid); 	// Update centroid
				System.out.println(centroid);
			}

		}
		
		else
		{
			System.out.println(centroid);
		}
	}
		
	/**
	 * Updates the LpDistance after moving the centroids for every assigned datapoint
	 * @param centroid
	 */
	private void updateDistances(InterfaceCentroid centroid)
	{
		Iterator<InterfacePoint> iterPoints = centroid.getAssignedDataPoints().iterator();
		while(iterPoints.hasNext())
		{
			InterfacePoint point = iterPoints.next();
			point.setDistanceToClosestCentroid(Similarity.getLpDistance(centroid, point));
		}
	}
}
