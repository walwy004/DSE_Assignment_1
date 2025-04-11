package students.items;

public class UntilledSoil extends Item {

	public UntilledSoil() {
	    super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);
	}

	public UntilledSoil(UntilledSoil other) {
	    super(other);
	}

    @Override
    public String toString() {
        return "/";
    }
}
