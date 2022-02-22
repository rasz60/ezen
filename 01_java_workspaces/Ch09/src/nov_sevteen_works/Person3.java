package nov_sevteen_works;

public class Person3 {

	private StringBuffer name = new StringBuffer();
	private Integer age;
	
	public Person3 () {}
	
	public Person3 (StringBuffer name) {
		this.name = name;
	}
	
	public Person3 (StringBuffer name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public StringBuffer getName() {
		return name;
	}
	
	public void setName(StringBuffer name) {
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
