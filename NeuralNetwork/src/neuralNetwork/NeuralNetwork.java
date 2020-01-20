package neuralNetwork;

public class NeuralNetwork {
	
	private static Matrix input;
	private static Matrix x;
	private static Matrix error;
	private static Matrix hidden;
	private static Matrix output;
	private static Matrix weights;
	
	double[] errorHistory;
	double[] epochList;
	private static Matrix delta;

	//Matrix matrix;
	
	public NeuralNetwork(Matrix input, Matrix output, Matrix weights){
		
		this.input = input;
		this.output = output;
		
		this.weights = weights;
		
	}
	
	
	/**
	 * The activation function to adjust the weights
	 * @param function: sigmoid, .. (more to be added)
	 * @param x: value
	 * @param derivation: ?
	 * @return
	 */
	public static Matrix activationFunc(Matrix x,String function, boolean derivation) {
		
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
		
		else {
			throw new RuntimeException("The function name was not defined correctly.");
		}	
	}
	
	private static void feedForward() {		
		// hidden layer
		hidden = activationFunc(input.multiplMatrix(weights), "sigmoid", false);
	}
	
	public static void backpropagation() {
		Matrix error = output.subtrMatrix(hidden);

		
		delta = error.multiplMatrix(activationFunc(hidden, "sigmoid", true));

		
		Matrix weightsDelta = input.transpose().multiplMatrix(delta);
		weights = weights.sumMatrix(weightsDelta);

	}
	
	public void training(int epochs) {
		for(int i = 0; i < epochs; i++) {
			feedForward();
			backpropagation();			
		}
	}
	
	public Matrix predict(Matrix newInput) {	
		Matrix predictions = activationFunc(newInput.multiplMatrix(weights), "sigmoid", false);	
		//weights.display();
		return predictions;
	}

}
