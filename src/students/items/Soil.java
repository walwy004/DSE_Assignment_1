package students.items;

public class Soil extends Item {

	public Soil() {
	    super(Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
	}

	public Soil(Soil other) {
	    super(other);
	}

    @Override
    public String toString() {
        return ".";
    }
}
