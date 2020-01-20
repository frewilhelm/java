package neuralNetwork;

/**
 * The application class to start the neural network-function
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 *
 */
public class Application {
	
	/**
	 * Main function to start the application (driver program)
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Test-Input-Array
		double inputArray[][] = {
			 {0, 1, 0}, 
			 {0, 1, 1},
			 {0, 1, 1},
			 {1, 0, 0},
			 {1, 1, 1},
			 {1, 0, 1}};
		
		// Test-Weights-Array
		double weightsArray[][] = {
				 {0.7},
				 {0.8},
				 {0.5}};
		
		// Test-Output-Array
		double outputArray[][] = {
			 {0},
			 {0},
			 {0},
			 {1},
			 {1},
			 {1}};
		
		// Converge to Matrix-Datastructure
		Matrix inputTrain = new Matrix(inputArray);
		Matrix weights = new Matrix(weightsArray);
		Matrix outputTrain = new Matrix(outputArray);

		// Create Neural-Network-Object
		NeuralNetwork NN = new NeuralNetwork(inputTrain, outputTrain, weights);
		
		// Train NeuralNetwork with x epochs
		NN.training(25000);
		
		// Set example data-sets to test neural network
		double[][] example = {{1, 1, 0}};
		double[][] example2 = {{0, 1, 1}};
		Matrix exampleMatrix1 = new Matrix(example);
		Matrix exampleMatrix2 = new Matrix(example2);
		
		Matrix x = NN.predict(exampleMatrix1);
		x.display(); // Same as in python. check
		
		Matrix y = NN.predict(exampleMatrix2);
		y.display(); // Same as in python. check
	}
}
