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
	
	public Item get(int row, int col) {
		// Returns a copy of the item at that location
		return cloneItem(grid[row][col]);
	}
	
	public void plant(int row, int col, Item item) {
		// Stores a given item at a given location
		grid[row][col] = cloneItem(item);
	}

	private Item cloneItem(Item item) {
		if (item instanceof Apples) {
			return new Apples((Apples) item);
		} else if (item instanceof Grain) {
			return new Grain((Grain) item);
		} else if (item instanceof Soil) {
            return new Soil((Soil) item);
        } else if (item instanceof Weed) {
            return new Weed((Weed) item);
        } else if (item instanceof UntilledSoil) {
            return new UntilledSoil((UntilledSoil) item);
        }
        return null;
	}
	
}
