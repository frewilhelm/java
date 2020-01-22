package kMeanAlgorithm;

public class Similarity 
{
	
	public static int pValue = 2;
	
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
	public static double getLpDistance(InterfaceComparableObject co1, InterfaceComparableObject co2)
	{
		double[] dimensionsC01 = co1.getDimensions();
		double[] dimensionsC02 = co2.getDimensions();
		
		double sum = 0;
		
		for(int i = 0; i < dimensionsC01.length; i++)
		{
			sum = sum + Math.abs(Math.pow(dimensionsC01[i] - dimensionsC02[i],  pValue));
		}
		return Math.pow(sum,  (double)1/pValue);
	}
}
