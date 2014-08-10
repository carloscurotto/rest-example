package ar.com.carloscurotto.rest.domain;

public class Client {

	private static final int NO_ID = -1;

	private int id;
	private String firstName;
	private String lastName;
	private int age;

	public Client(int id, String firstName, String lastName, int age) {
		// TODO validate input parameters
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Client(String firstName, String lastName, int age) {
		this(NO_ID, firstName, lastName, age);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

}
