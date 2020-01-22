package kMeanAlgorithm;

import java.util.ArrayList;
import java.util.List;

import kMeanAlgorithm.CentroidPoint;
import kMeanAlgorithm.InterfaceCentroid;
import kMeanAlgorithm.InterfacePoint;
import kMeanAlgorithm.Point;

public class CentroidPoint extends Point implements InterfaceCentroid {
	
	public static int nrOfCentroids;
		
	public static boolean change = true;	// Boolean to check, if the kMean algorithm has to stop or not

	private static List<InterfaceCentroid> centroids;

	private final int clusterMembership;	// This centroid belongs to a specific cluster

	private List<InterfacePoint> points = new ArrayList<>();	// List of datapoints
	
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
	public List<InterfacePoint> getAssignedDataPoints()
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
	public void removeAssignedDataPoints(InterfacePoint point)
	{
		points.remove(point);
	}
	
	/**
	 * This method adds a datapoint (also if datastring) to the respective centroid
	 * @param point
	 */
	public void addAssignedDataPoints(InterfacePoint point)
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
	
		
	/**
	 * This method chooses two random centroid from all points.
	 * @param list
	 * @param amountOfCentroids 
	 * @return
	 */
	public static List<InterfaceCentroid> randomCentroids(List<Object> list, int amountOfCentroids) 
	{
		if(amountOfCentroids > list.size()) {
			throw new RuntimeException("You have chosen more centroids than you have data?!?!");
		}
		
		else {
			// Chose random centroid for every given amountOfCentroids
			for(int i = 0; i < amountOfCentroids; i++) {
				int randInt = (int)
			}
			
		}
		
		for(int i = 0; i < amountOfCentroids; i++)
		{
			int randomNumber = (int) (Math.random() * list.size());
			
			Object dummyArray = list.get(0);
			String dummy = (String) dummyArray[0].toString();
			
			if(dummy.matches("[0-9]+\\.[0-9]+"))
			{
				Double[] dummy2 = (Double[]) list.get(randomNumber);
				
				double[] dummy3 = new double[dummy2.length];
				
				for(int u = 0; u < dummy2.length; u++)
				{
					dummy3[u] = dummy2[u];	
				}
				
				// Add centroid from all general points
				centroids.add(new CentroidPoint(dummy3));
				// Remove centroid from all general points
				list.remove(randomNumber);
			}
			
			else
			{
				String[] dummy2 = (String[]) list.get(randomNumber);
				
				String dummy4 = (String) dummy2[0].toString();
								
				int a = dummy4.length(); // word length
				
				// Find unique letters
				String uniqueLetters = "";
				for(int z = 0; z < dummy.length(); z++)
				{
					if(uniqueLetters.indexOf(dummy.charAt(z)) == -1)
					{
						uniqueLetters = uniqueLetters + dummy.charAt(z); // Add to uniqueLetters, if it is not contained yet
					}
				}
				
				int b = uniqueLetters.length(); // unique word length
				
				double[] centroidValue = {a,b};
				
				centroids.add(new CentroidPoint(centroidValue));
				// Remove centroid from all general points
				list.remove(randomNumber);
			}	
		}
		
		System.out.println("These are the centroids " + centroids);
		return centroids;	
	}



}
