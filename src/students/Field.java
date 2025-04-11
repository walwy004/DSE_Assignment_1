package students;

import students.items.*;

public class Field {
	
	private Item[][] grid;
	private int height;
	private int width;
	
	public Field(int height, int width) {
		this.height = height;
		this.width = width;
		grid = new Item[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				grid[row][col] = new Soil(); // Starts with all soil
			}
		}
	}
	
}
