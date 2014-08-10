package ar.com.carloscurotto.rest.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import ar.com.carloscurotto.rest.domain.Client;

public class InMemoryClientService implements ClientService {

	private Map<Integer, Client> clients = new ConcurrentHashMap<Integer, Client>();
	private AtomicInteger idCounter = new AtomicInteger();

	public InMemoryClientService() {
		System.out.println("creating in memory client service");
	}

	@Override
	public void store(Client client) {
		int clientID = this.idCounter.incrementAndGet();
		client.setID(clientID);
		this.clients.put(clientID, client);
	}

	@Override
	public void remove(int clientID) {
		this.clients.remove(clientID);
	}

	@Override
	public Client get(int clientID) {
		return this.clients.get(clientID);
	}

}
