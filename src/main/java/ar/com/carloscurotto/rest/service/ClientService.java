package ar.com.carloscurotto.rest.service;

import ar.com.carloscurotto.rest.domain.Client;

public interface ClientService {

	public void store(Client client);
	
	public void remove(int clientID);
	
	public void update(Client client);
	
	public Client get(int clientID);
}
