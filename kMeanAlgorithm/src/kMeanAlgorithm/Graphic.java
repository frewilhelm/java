package kMeanAlgorithm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Graphic extends Application {

	@Override
	public void start(Stage stageProject) throws Exception {
		
		double scale = 5;
		
		if(max(Clustering.maxX) < 50 && max(Clustering.maxY) < 50) {
			scale = 50;
		}
		if(max(Clustering.maxX) < 25 && max(Clustering.maxY) < 25) {
			scale = 100;
		}
		else {
			scale = 5;
		}
	
		

		int width = (int) (200 + scale * max(Clustering.maxX));

		int height = (int) (200 + scale * max(Clustering.maxY));
		
		// Create root to add graphical objects
		Pane root = new Pane();
		
		double opacity;
		
		// Centroids, Lines between changing centroids, ellipses
		for(int z = 0; z < Clustering.runs; z++) {
			for(int i = 0; i < Clustering.centroidsGraph.get(z).length; i++) { // relates to amount of centroids
				// Centroids
				Rectangle rect = new Rectangle();
				rect.setX(Clustering.centroidsGraph.get(z)[i][0] * scale);
				rect.setY(Clustering.centroidsGraph.get(z)[i][1] * scale);
				rect.setHeight(10);
				rect.setWidth(10);
				opacity = ((double) z / (double) Clustering.runs) + 0.1;
				if(Clustering.centroidsGraph.get(0).length > ColorScheme.colorScheme.length) {
					rect.setFill(Color.rgb(228,26,28, opacity));
				}
				else {
					rect.setFill(Color.rgb(ColorScheme.colorScheme[i][0],ColorScheme.colorScheme[i][1],ColorScheme.colorScheme[i][2], opacity));
				}
				root.getChildren().add(rect);
				// Lines between changing centroids
				if(z > 0) {
					Line line = new Line();
					line.setStartX(Clustering.centroidsGraph.get(z - 1)[i][0] * scale);
					line.setStartY(Clustering.centroidsGraph.get(z - 1)[i][1] * scale);
					line.setEndX(Clustering.centroidsGraph.get(z)[i][0] * scale);
					line.setEndY(Clustering.centroidsGraph.get(z)[i][1] * scale);
					line.setStrokeWidth(1);
					if(Clustering.centroidsGraph.get(0).length > ColorScheme.colorScheme.length) {
						line.setStroke(Color.rgb(228,26,28, opacity));
					}
					else {
						line.setStroke(Color.rgb(ColorScheme.colorScheme[i][0],ColorScheme.colorScheme[i][1],ColorScheme.colorScheme[i][2], opacity));
					}
					root.getChildren().add(line);
				}	
				// Ellipse around centroids at the end (Not that valid)
				/*if(z == Clustering.runs - 1) {
					Ellipse  ellipse = new Ellipse ();
					ellipse.setCenterX(Clustering.centroidsGraph.get(z)[i][0] * scale);
					ellipse.setCenterY(Clustering.centroidsGraph.get(z)[i][1] * scale);
					if(Clustering.maxX[i] == 0 && Clustering.maxY[i] == 0) { // If there are no values to draw an ellipse
						continue;
					}
					else {
						ellipse.setRadiusX(Clustering.maxX[i]/2 * scale); // divide by 2, since radius
						ellipse.setRadiusY(Clustering.maxY[i]/2 * scale);
						ellipse.setFill(Color.TRANSPARENT);
						ellipse.setStroke(Color.rgb(0,0,0, opacity));
						root.getChildren().add(ellipse);
					}
	
				}*/
			}
		}

		
		// Points
		for(int i = 0; i < Clustering.datapointsGraph.amDatapoints; i++) {
			Rectangle rect = new Rectangle();		
			rect.setX(Clustering.datapointsGraph.getDatapoint(i).getValue(0) * scale);
			rect.setY(Clustering.datapointsGraph.getDatapoint(i).getValue(1) * scale);
			rect.setHeight(5);
			rect.setWidth(5);
			if(Clustering.centroidsGraph.get(0).length > ColorScheme.colorScheme.length) {
				rect.setFill(Color.BLACK);
			}
			else {
				rect.setFill(Color.rgb(ColorScheme.colorScheme[Clustering.datapointsGraph.getDatapoint(i).centrAssigned][0], 
						ColorScheme.colorScheme[Clustering.datapointsGraph.getDatapoint(i).centrAssigned][1], 
						ColorScheme.colorScheme[Clustering.datapointsGraph.getDatapoint(i).centrAssigned][2]));
			}
			root.getChildren().add(rect);
		}	
		

		
		// Create the scene with root, width and height
		Scene scene = new Scene(root, width, height);
		
		stageProject.setTitle("Algorithm Animation");
		stageProject.setScene(scene);
		stageProject.show();
	}
	
	private double max(Double[] array) {
		double max = 0;
		for(int i = 0; i < array.length; i++) {
			double temp = array[i];
			if(temp > max) {
				max = temp;
			}	
		}
		return max;
	}

}
