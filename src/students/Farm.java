package students;

import students.items.*;
import java.util.Scanner;

public class Farm {
	
	private Field field;
	private int bankBalance;
	private Weather weather;

	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
		this.field = new Field(fieldHeight, fieldWidth);
		this.bankBalance = startingFunds;
		this.weather = new Weather();
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display field and bank balance
            System.out.println(field);
            System.out.println("Bank balance: $" + bankBalance);
            System.out.println();
            System.out.println("Enter your next action:");
            System.out.println("  t x y: till");
            System.out.println("  h x y: harvest");
            System.out.println("  p x y: plant");
            System.out.println("  s: field summary");
            System.out.println("  w: wait");
            System.out.println("  q: quit");
            
            // Read input
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");
            
            // Handle input
            if (parts.length > 0) {
                String command = parts[0].toLowerCase();

                try {
                	// Quit
                    if (command.equals("q")) {
                        running = false;
                    } 
                    
                    // Wait
                    else if (command.equals("w")) {
                    	// Wait: do nothing except tick 	
                    } 
                    
                    // Field summary
                    else if (command.equals("s")) {
                        System.out.println(field.getSummary());

                    } else if ((command.equals("t") || command.equals("h") || command.equals("p")) && parts.length == 3) {
                    	// Offset of -1 to match with actual grid coordinates
                        int x = Integer.parseInt(parts[1]) - 1;
                        int y = Integer.parseInt(parts[2]) - 1;

                        if (x < 0 || x >= field.getWidth() || y < 0 || y >= field.getHeight()) {
                            System.out.println("Invalid coordinates. Try again.");
                        } else {
                        	
                        	// Till
                            if (command.equals("t")) {
                                field.till(y, x); // y = row, x = col
                            }
                            
                            // Harvest
                            else if (command.equals("h")) {
                                Item item = field.get(y, x);
                                int value = item.getValue();
                                if (value > 0) {
                                    bankBalance += value;
                                    field.till(y, x); // harvest = till
                                    System.out.println("Sold '" + item.toString() + "' for $" + value);
                                    System.out.println();
                                } else {
                                    System.out.println("Item is not harvestable.");
                                }
                            }
                            
                            // Plant
                            else if (command.equals("p")) {
                                Item spot = field.get(y, x);
                                if (!(spot instanceof Soil)) {
                                    System.out.println("Can only plant in soil.");
                                } else {
                                    System.out.println("Enter:\n - 'a' to buy an apple for $2\n - 'g' to buy grain for $1");
                                    String choice = scanner.nextLine().trim().toLowerCase();

                                    if (choice.equals("a")) {
                                        if (bankBalance >= 2) {
                                            field.plant(y, x, new Apples());
                                            bankBalance -= 2;
                                        } else {
                                            System.out.println("Not enough funds. You lose your turn.");
                                        }

                                    } else if (choice.equals("g")) {
                                        if (bankBalance >= 1) {
                                            field.plant(y, x, new Grain());
                                            bankBalance -= 1;
                                        } else {
                                            System.out.println("Not enough funds. You lose your turn.");
                                        }

                                    } else {
                                        System.out.println("Invalid crop choice. Turn forfeited.");
                                    }
                                }
                            }
                        }

                    } else {
                        System.out.println("Unknown or incomplete command.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input format. Please enter numbers where expected.");
                } catch (Exception e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
            }
            
            /*
             * === Custom Feature: Weather System ===
             * On each turn, the WeatherManager determines if a weather event occurs.
             * - Drought (5%): crops do not age (tick is skipped)
             * - Flood (5%): all Apples and Grain are wiped out and replaced with UntilledSoil
             * This feature introduces environmental randomness and challenges the player to plan ahead.
             */
            int weatherEvent = weather.getWeatherEvent();

            if (weatherEvent == Weather.FLOOD) {
                System.out.println("A flood has hit the farm! All crops are lost!");
                floodField();
            } else if (weatherEvent == Weather.DROUGHT) {
                System.out.println("A drought has hit! Crops will not age this turn.");
                continue; // skip tick()
            }

            // Always tick the field at end of each turn
            field.tick();
        }

        System.out.println("Game over!");
        scanner.close();
	}
	
	private void floodField() {
		// Draws new field after flood hits
	    for (int row = 0; row < field.getHeight(); row++) {
	        for (int col = 0; col < field.getWidth(); col++) {
	            Item item = field.get(row, col);
	            if (item instanceof Apples || item instanceof Grain) {
	                field.plant(row, col, new UntilledSoil());
	            }
	        }
	    }
	}

	
}
