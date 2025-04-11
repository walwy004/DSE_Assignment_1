package students.items;

public class Weed extends Item {
	
	public Weed() {
	    super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);
	}

	public Weed(Weed other) {
	    super(other);
	}

	@Override
	public String toString() {
		return "#";
	}
}
