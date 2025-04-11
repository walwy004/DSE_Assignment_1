package students.items;

public class Weed extends Item {
	public Weed() {
		// Using Integer.MAX_VALUE so maturation and death age are close to infinite
		super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);
	}
	
	@Override
	public String toString() {
		return "#";
	}
}
