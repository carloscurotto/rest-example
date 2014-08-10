package ar.com.carloscurotto.rest.service;

import ar.com.carloscurotto.rest.domain.Client;

public interface ClientService {

	public void store(Client client);
	
	public void remove(int clientID);
	
	public Client get(int clientID);
}
