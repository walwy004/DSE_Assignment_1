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
		
	}
	
}
