package ar.com.carloscurotto.rest.dto;

import ar.com.carloscurotto.rest.domain.Client;

/**
 * This class contains all the details for a particular client to show on the
 * UI.
 * 
 * @author carloscurotto
 * 
 */
public class ClientDTO {

	private static final int NO_ID = -1;

	private int id;
	private String firstName;
	private String lastName;
	private int age;

	public ClientDTO() {
	}

	public ClientDTO(int id, String firstName, String lastName, int age) {
		// TODO validate input parameters
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public ClientDTO(String firstName, String lastName, int age) {
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static ClientDTO fromDomain(Client client) {
		return new ClientDTO(client.getId(), client.getFirstName(),
				client.getLastName(), client.getAge());
	}

	public static Client toDomain(ClientDTO clientDetailsDTO) {
		return new Client(clientDetailsDTO.getId(),
				clientDetailsDTO.getFirstName(),
				clientDetailsDTO.getLastName(), clientDetailsDTO.getAge());
	}

}
