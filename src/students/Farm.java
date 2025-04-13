package students;

import students.items.*;
import java.util.Scanner;

public class Farm {
	
	private Field field;
	private int bankBalance;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
		this.field = new Field(fieldHeight, fieldWidth);
		this.bankBalance = startingFunds;
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
            
            // Handle input (build this next)
            if (parts.length > 0) {
                String command = parts[0].toLowerCase();

                // Placeholders — implement these next
                if (command.equals("q")) {
                    running = false;
                } else if (command.equals("w")) {
                    // wait = do nothing except tick
                } else if (command.equals("s")) {
                    System.out.println(field.getSummary());
                } else {
                    System.out.println("Unknown or incomplete command.");
                }
            }

            // Always tick the field at end of each turn
            field.tick();
        }

        System.out.println("Game over!");
	}
	
}
