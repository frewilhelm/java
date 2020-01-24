package kMeanAlgorithm;

public class Centroid {
	
	Double[] centroid;
	
	public Centroid(Centroids centroids, int index) {
		this.centroid = centroids.getCentroid(index);
	}

	public String toString() {
		
		String temp = "[" + this.centroid[0];
		for(int i = 1; i < this.centroid.length; i++) {
			temp = temp + ", " + this.centroid[i];
		}
		temp = temp + "]";
		return temp;
	}
	
	public double getValue(int index) {
		return this.centroid[index];
	}

}
