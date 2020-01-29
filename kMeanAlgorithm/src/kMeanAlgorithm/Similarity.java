package kMeanAlgorithm;

/**
 * Utility-class to calculate the lp-distance between a centroid and a datapoint.
 * 
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 */
public class Similarity {
	
	/**
	 * No constructor needed & no changes allowed (private)
	 */
	private Similarity()
	{		
	}
	
	/**
	 * Calculate the Lp-Distance 
	 * @param centroid
	 * @param datapoint
	 * @param pValue
	 * @return double - the lpDistance between centroid and datapoint at 
	 */
	public static double getLpDistance(Centroid centroid, Datapoint datapoint, int pValue)
	{		
		double sum = 0;			
		for(int i = 0; i < pValue; i++)
		{
			sum = sum + (Math.pow(datapoint.getValue(i) - centroid.getValue(i),  pValue));
		}		
		return Math.pow(sum, (double)1/pValue);
	}
}
