package students.items;

import java.util.Objects;

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
	
	// Copy constructor
	public Item(Item other) {
	    this.age = other.age;
	    this.maturationAge = other.maturationAge;
	    this.deathAge = other.deathAge;
	    this.value = other.value;
	}
	
	public void tick() {
		age++;
	}
	
	public boolean died() {
		return age > deathAge;
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
		// for food items, returns their value ONLY if the item’s age is passed it’s maturation age
		if (age >= maturationAge) {
			return value;
		} else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, deathAge, maturationAge, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return age == other.age && deathAge == other.deathAge && maturationAge == other.maturationAge
				&& value == other.value;
	}
	
	public abstract String toString();
	
}
