package HashSetApp;

import java.util.Objects;

public class Animal {

    @Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    // Override the toString method
    @Override
    public String toString() {
        return "Animal [name=" + name + ", age=" + age + "]";
    }

}
