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
	
	public void till(int row, int col) {
		// Takes in the location in the field to till and turn into new Soil
		grid[row][col] = new Soil();
	}
	
	public void tick() {
		// Calls every Items tick function to increase its age
		// If an Item is Soil, 20% of the time the location will turn into a new Weed
		// If an item in the field has died after ageing, it turns into UntilledSoil
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Item item = grid[row][col];
				item.tick();
				
				if (item.died()) {
					grid[row][col] = new UntilledSoil();
				} else if (item instanceof Soil) {
					if (Math.random() < 0.2) {	// 20% chance
						grid[row][col] = new Weed();
					}
				}
			}
		}
	}
	
	public int getValue() {
		// Returns the total monetary value of each item in the field
		int total = 0;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < height; col++) {
				total += grid[row][col].getValue();
			}
		}
		return total;
	}
	
	public String getSummary() {
		// Returns a string representing the quantities and overall value of the field
		int apples = 0, grains = 0, soil = 0, untilled = 0, weed = 0;
		int value = 0;
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Item item = grid[row][col];
				
				if (item instanceof Apples) {
					apples++;
				} else if (item instanceof Grain) {
					grains++;
				} else if (item instanceof Soil) {
	                soil++;
	            } else if (item instanceof UntilledSoil) {
	                untilled++;
	            } else if (item instanceof Weed) {
	                weed++;
	            }

	            value += item.getValue();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Apples:        %d\n", apples));
	    sb.append(String.format("Grain:         %d\n", grains));
	    sb.append(String.format("Soil:          %d\n", soil));
	    sb.append(String.format("Untilled:      %d\n", untilled));
	    sb.append(String.format("Weed:          %d\n", weed));
	    sb.append(String.format("For a total of $%d\n", value));
	    sb.append(String.format("Total apples created: %d\n", Apples.getGenerationCount()));
	    sb.append(String.format("Total grain created: %d\n", Grain.getGenerationCount()));

	    return sb.toString();
	}
	
	@Override
	public String toString() {
		// Prints out a numbered grid with the contents of each location
		StringBuilder sb = new StringBuilder();
		
		// Column headers
		sb.append("  ");
		for (int col = 1; col <= width; col++) {
			sb.append(col).append(" ");
		}
		sb.append("\n");
		
		// Rows with row numbers
		for (int row = 0; row < height; row++) {
			sb.append(row + 1).append(" ");
			for (int col = 0; col < width; col++) {
				sb.append(grid[row][col].toString()).append(" ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
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
