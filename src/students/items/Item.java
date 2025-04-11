package students.items;

public abstract class Item {
	
	protected int age;
	protected int maturationAge;
	protected int deathAge;
	protected int value;
	
	public Item(int maturationAge, int deathAge, int value) {
		this.age = 0;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
        this.value = value;
        
	}
	
}
