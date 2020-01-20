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
		
		// 
		
		double inputArray[][] = {
			 {0, 1, 0}, 
			 {0, 1, 1},
			 {0, 1, 1},
			 {1, 0, 0},
			 {1, 1, 1},
			 {1, 0, 1}};
		double weightsArray[][] = {
				 {0.7},
				 {0.8},
				 {0.5}};
		double outputArray[][] = {
			 {0},
			 {0},
			 {0},
			 {1},
			 {1},
			 {1}};
		
		Matrix inputTrain = new Matrix(inputArray);
		Matrix weights = new Matrix(weightsArray);
		Matrix outputTrain = new Matrix(outputArray);
		inputTrain.display();
		weights.display();
		outputTrain.display();
		
		NeuralNetwork NN = new NeuralNetwork(inputTrain, outputTrain, weights);
		
		NN.training(25000);
		
		double[][] example = {{1, 1, 0}};
		double[][] example2 = {{0, 1, 1}};
		Matrix exampleMatrix1 = new Matrix(example);
		Matrix exampleMatrix2 = new Matrix(example2);
		
		Matrix x = NN.predict(exampleMatrix1);
		x.display();
		
		Matrix y = NN.predict(exampleMatrix2);
		y.display();
		
		//System.out.println(NeuralNetwork.predict(exampleM).display() + " - Correct: " + example[0][0]);
		//System.out.println(NeuralNetwork.predict(exampleM2) + " - Correct: " + example[0][0]);
		
		

	}
}
