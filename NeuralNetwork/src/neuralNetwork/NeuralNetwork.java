package neuralNetwork;

/**
 * Class with wich the object neuralNetwork is created
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 * @based on https://github.com/fwilhelm92/python/blob/master/neuralNetworkWilson.py
 */
public class NeuralNetwork {
	
	// Variables		----------------------------------------------------------------------------------------
	
	private static Matrix input;
	private static Matrix output;
	private static Matrix weights;
	private static Matrix hidden;
	private static Matrix delta;
	private static Matrix error;
	double[] errorHistory;
	double[] epochList;
	


	// Constructor		----------------------------------------------------------------------------------------
	
	/**
	 * Create an object as neural network. Three matrices needed.
	 * @param input
	 * @param output
	 * @param weights
	 */
	public NeuralNetwork(Matrix input, Matrix output, Matrix weights){		
		this.input = input;
		this.output = output;	
		this.weights = weights;
	}
	
	// Objectmethods	----------------------------------------------------------------------------------------
	
	/**
	 * The activation function to adjust the weights
	 * @param function: sigmoid, .. (more to be added)
	 * @param x: value
	 * @param derivation
	 * @return outputMatrix as Matrix
	 */
	public static Matrix activationFunc(Matrix x, String function, boolean derivation) {
		
		// Temporary array to get the values
		double[][] tempArray = x.asArray();
		// New array to store output values
		double[][] tempArrayOutput = new double[x.rows][1];
			
		if (function == "sigmoid") {
			if (derivation == true) {
				for(int i = 0; i < x.rows; i++) {
					tempArrayOutput[i][0] = tempArray[i][0] * (1 - tempArray[i][0]);		
				}
				Matrix outputMatrix = new Matrix(tempArrayOutput);			
				return outputMatrix;			
			}
			else {
				for(int i = 0; i < x.rows; i++) {
					tempArrayOutput[i][0] = 1 / (1 + Math.exp(-tempArray[i][0]));			
				}				
				Matrix outputMatrix = new Matrix(tempArrayOutput);
				return outputMatrix;
			}	
		}

		// TODO add more functions
		
		else {
			throw new RuntimeException("The function name was not defined correctly.");
		}	
	}
	
	/**
	 * Calculate predicted output y as hidden matrix
	 */
	private static void feedForward() {		
		// hidden layer
		hidden = activationFunc(input.multiplMatrix(weights), "sigmoid", false);
	}
	
	/**
	 * Update weights and biases
	 */
	public static void backpropagation() {
		error = output.subtrMatrix(hidden);
		delta = error.multiplMatrix(activationFunc(hidden, "sigmoid", true));
		Matrix weightsDelta = input.transpose().multiplMatrix(delta);
		weights = weights.sumMatrix(weightsDelta);
	}
	
	/**
	 * Train neural network -> weights
	 * Store error-history
	 * @param epochs (amount of repitions)
	 */
	public void training(int epochs) {
		errorHistory = new double[epochs];
		epochList = new double[epochs];
		for(int i = 0; i < epochs; i++) {
			feedForward();
			backpropagation();	
			
			error.absMatrix();
			errorHistory[i] = error.aveMatrix();
			epochList[i] = i;
		}
		
		// TODO Maybe add tipping point, when method should stop.
	}
	
	/**
	 * Use trained neural network to predict new data.
	 * @param newInput
	 * @return predictions as matrix
	 */
	public Matrix predict(Matrix newInput) {	
		Matrix predictions = activationFunc(newInput.multiplMatrix(weights), "sigmoid", false);	
		return predictions;
	}

}
