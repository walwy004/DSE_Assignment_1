package students.items;

public abstract class Item {
	
	private int age;
	private int maturationAge;
	private int deathAge;
	private int value;
	
	public Item(int maturationAge, int deathAge, int value) {
		this.age = 0;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
        this.value = value;
        
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public int getMaturationAge() {
		return maturationAge;
	}

	public int getDeathAge() {
		return deathAge;
	}

	public int getValue() {
		return value;
	}
	
	
	
}
