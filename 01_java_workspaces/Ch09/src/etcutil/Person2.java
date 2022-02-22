package etcutil;

public class Person2 {

	private String name;
	private Integer age;
	
	public Person2 () {}
	
	public Person2 (String name) {
		this.name = name;
	}
	
	public Person2 (String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String toString() {
		return this.name + ", " + this.age;
	}
	
}
