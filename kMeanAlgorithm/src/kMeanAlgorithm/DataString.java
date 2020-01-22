package kMeanAlgorithm;

public class DataString extends AbstractDataPoint 
{
	
	// Basically, neither the length of a word nor the length of the respective unique letters of this
	//  word, can be decimal. However, the assignment shows that they are stored as double, wherefore
	//  I'll do the same.
	private double a; 
	private double b;
	private String dummy;
	
	/**
	 * Constructor:
	 *  The given string is getting converted in numerical values to gain a datapoint
	 *  The first value is gained by the length of the given string. The second value by the amount of
	 *   unique letters of the string.
	 * @param string
	 */
	public DataString(String string) 
	{
		
		dummy = string;
				
		// The string is converted to lower case letters, since with the following count of unique letters
		//  a 'T' and a 't' count as two unique letters.
		//  Basically, 'T' and 't' are different letters, but counting them as two unique letters does not
		//   seem to be reasonable.
		
		dummy = dummy.toLowerCase();
				
		// Change string to data point
		//  a -> the length of the string
		//  b -> the amount of unique letters in the string
		
		a = dummy.length();
		
		// Find unique letters
		String uniqueLetters = "";
		
		/*
		 *  Example 'aauto'
		 *  uniqueLetters is empty at the beginning.
		 *  uniqueLetters.indexOf(dummy.charAt(0)) looks for the index of 'a' in 'uniqueLetters'. Since 'uniqueLetters'
		 *   is empty, 'a' cannot be found, it returns '-1'. Thus, the letter 'a' will be added to 'uniqueLetters.
		 *  Then, uniqueLetters.indexOf(dummy.charAt(1)) looks for an 'a' again and this time, it is found in 'unique-
		 *   letters' at the index = 0, which is also the returned value. Thus, nothing happens.
		 *  uniqueLetters.indexOf(dummy.charAt(2)) looks for an 'u' in 'uniqueLetters'. It will return the value '-1'
		 *   since 'uniqueLetters' does not contain an 'u'. Thus, 'u' will be added to the string 'uniqueLetters'.
		 *  And so on and so on. At the end, we have the string 'uniqueLetters' with all the unique letters of dummy/the
		 *   specific string.
		 */ 
		for(int i = 0; i < dummy.length(); i++)
		{
			if(uniqueLetters.indexOf(dummy.charAt(i)) == -1)
			{
				uniqueLetters = uniqueLetters + dummy.charAt(i); // Add to uniqueLetters, if it is not contained yet
			}
		}
		
		// Amount of unique letters
		b = uniqueLetters.length();
				
		double[] dimension = {a,b};
		
		this.setDimensions(dimension);	
	}
	
	/**
	 * This method prints the datapoint as a string in a specific format.
	 * Actually, it does not use the previous implemented code for 'toString' from the class Point, that is extended by
	 *  AbstractDataPoint
	 * Since we know that there can only be two dimensions, the method is relatively easy.
	 */
	public String toString()
	{	
		return "Token: " + dummy + " (" + a + "/" + b + ")"; 	
	}

}
