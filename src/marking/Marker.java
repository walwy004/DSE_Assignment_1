package marking;

import students.Farm;
import students.Field;
import students.items.*;

public class Marker {

	public static void main(String[] args) {
		
		// Section ONE
		
		//you should NOT be able to make an Item - following line shouldn't compile if uncommented
		//new Item(0, 0, 0);

		// Apple testing
//		System.out.println(Apples.getGenerationCount()); // should print 0
//		Apples a = new Apples();
//		System.out.println(Apples.getGenerationCount()); // should print 1
//		System.out.println(a); // should print "a"
//		System.out.println(a.getValue()); // should print 0
//		a.setAge(5);
//		System.out.println(a.getValue()); // should print 3
//		System.out.println(a); // should print "A"
//		System.out.println(a.died()); // should print false
//		a.tick();
//		System.out.println(a.died()); // should print true
//		Food testFood = a; //this should be possible
//		Item testItem = testFood; //this should be possible
		
//		// Grain testing
//		System.out.println(Grain.getGenerationCount()); // should print 0
//		Grain g = new Grain();
//		System.out.println(Grain.getGenerationCount()); // should print 1
//		System.out.println(g); // should print "g"
//		System.out.println(g.getValue()); // should print 0
//		g.setAge(6);
//		System.out.println(g.getValue()); // should print 2
//		System.out.println(g); // should print "G"
//		System.out.println(g.died()); // should print false
//		g.tick();
//		System.out.println(g.died()); // should print true
	
		
//		System.out.println(new Weed()); // should print "#"
//		System.out.println(new UntilledSoil()); // should print "/"
//		System.out.println(new Soil()); // should print "."

		// Section TWO
		// uncomment this section once you get to it
		
//		Field testField = new Field(5, 5);
//		System.out.println(testField.get(3, 3)); //should print "."
//		System.out.println(testField); //should print the field
//		System.out.println(testField.getValue()); //should print 0
//		Apples a = new Apples();
//		a = new Apples();
//		a.setAge(5);
//		testField.plant(0, 0, a);
//		System.out.println(testField.getValue()); //should print 3
//		System.out.println(a.equals(testField.get(0, 0))); //should print true
//		System.out.println(testField); // should print the field with apple
//		testField.till(0, 0);
//		System.out.println(a.equals(testField.get(0, 0))); //should print false
//		System.out.println(testField.get(0, 0).equals(new Soil())); //should print true
//		System.out.println(testField.getSummary()); // should print summary of field
//		System.out.println(testField); // should print empty field
		

		// Section THREE
		// uncomment this section once you get to it
		//remember, your farm should work on varies size fields (assuming all fields are less than 10x10)
		Farm f = new Farm(10, 5, 10);
		f.run();
		
	}

}
