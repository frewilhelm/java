package kMeanAlgorithm;

public class Similarity {
	
	/**
	 * No constructor needed & no changes allowed (private)
	 */
	private Similarity()
	{		
	}
	
	/**
	 * Calculate the Lp-Distance 
	 * (@param p = 2)
	 * @param co1
	 * @param co2
	 * @return
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
