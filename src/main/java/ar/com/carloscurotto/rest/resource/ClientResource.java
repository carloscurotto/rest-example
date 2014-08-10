package ar.com.carloscurotto.rest.resource;

import ar.com.carloscurotto.rest.dto.ClientDTO;

public interface ClientResource {

	public void store(ClientDTO clientDTO);
	
	public void remove(int clientID);
	
	public void update(ClientDTO clientDTO);
	
	public ClientDTO get(int clientID);
	
	public String test();
	
}
