package kMeanAlgorithm;

import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * By this class the graph is created
 *  Every point has a x- and y-coordinate that are translated into to graph.
 *  Centroids are displayed a bit bigger than datapoints and are colored red.
 *  Datapoints are display in black.
 * Furthermore, the size of the scene is depending on the biggest x- and y-
 *  coordination to assure that the scene is big enough.
 *  Since some points are very small, the default size of the graph is 500x500
 * Additionally, the datapoints are scaled by the factor 9 to assure that the 
 *  datapoints are visible. 
 * Concerning the scaling.. One could improve it with an adequate control-structure,
 *  but I do not have the time :/ 
 */
public class Graph extends Application {
	
	// Initialize lists to get centroids and datapoints
	public static List<InterfaceCentroid> centroids = new LinkedList<>();
	public static List<InterfacePoint> points = new LinkedList<>();
	
	/**
	 * The init()-method would start certain non-graphical algorithms.
	 * However, it is not needed here, since the sequential structure of 
	 *  eclipse is used to get the graph after the k-mean clustering
	 */
	public void init()
	{
		
	}

	/**
	 * The start(Stage XY) runs the creation of the graph.
	 *  It defines the stage, scene and the nodes.
	 */
	public void start(Stage stageProject) throws Exception 
	{
		//Get points from datapoints and centroids
		points = DataPoint.getPoints();
		centroids = CentroidPoint.getCentroids();
		
		// Create root to add graphical objects
		Pane root = new Pane();
		
		// Centroids
		for(int i = 0; i < centroids.size(); i++)
		{
			Rectangle rect = new Rectangle();
			rect.setX(centroids.get(i).getDimensions()[0] * 9);
			rect.setY(centroids.get(i).getDimensions()[1] * 9);
			rect.setHeight(10);
			rect.setWidth(10);
			rect.setFill(Color.RED);
			root.getChildren().add(rect);
		}
		
		// Points
		for(int i = 0; i < points.size(); i++)
		{
			Rectangle rect = new Rectangle();
			rect.setX(points.get(i).getDimensions()[0] * 9);
			rect.setY(points.get(i).getDimensions()[1] * 9);
			rect.setHeight(5);
			rect.setWidth(5);
			rect.setFill(Color.BLACK);
			root.getChildren().add(rect);
		}
		
		// Legend
		Rectangle rectLegendCentroid = new Rectangle();
		rectLegendCentroid.setX(115);
		rectLegendCentroid.setY(6);
		rectLegendCentroid.setHeight(5);
		rectLegendCentroid.setWidth(5);
		rectLegendCentroid.setFill(Color.BLACK);
		root.getChildren().add(rectLegendCentroid);
		
		Rectangle rectLegendPoint = new Rectangle();
		rectLegendPoint.setX(192);
		rectLegendPoint.setY(3);
		rectLegendPoint.setHeight(10);
		rectLegendPoint.setWidth(10);
		rectLegendPoint.setFill(Color.RED);
		root.getChildren().add(rectLegendPoint);

		// Label as shown in example
		Label label = new Label();
		// Not really generic... I know^^
		label.setText("K-Means Clustering:     Datapoints        Centroids");
		label.setUnderline(true);
		root.getChildren().add(label);
		
		// Set width of the scene. At least 500 or the greatest x-
		//  coordinate multiplied by 10
		// It is multiplied to assure a certain border to the stage
		//  It could have be done with a BorderPane but I am lacking 
		//  time, so this also works.
		Double width = Project.getWidth() * 10;
		if(width < 500) // at least 500
		{
			width = (double) 500;
		}

		// Set height of the scene. At least 500 or the greatest y-
		//  coordinate multiplied by 10
		Double height = Project.getHeight() * 10;
		if(height < 500) // at least 500
		{
			height = (double) 500;
		}
		
		// Create the sccene with root, width and height
		Scene scene = new Scene(root, width, height);
		
		stageProject.setTitle("Algorithm Animation");
		stageProject.setScene(scene);
		stageProject.show();
				
	}

}
