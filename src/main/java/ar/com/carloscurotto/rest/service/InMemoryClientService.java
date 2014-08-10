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
		int clientId = this.idCounter.incrementAndGet();
		client.setId(clientId);
		this.clients.put(clientId, client);
	}

	@Override
	public void remove(int clientId) {
		this.clients.remove(clientId);
	}

	@Override
	public void update(Client client) {
		this.clients.put(client.getId(), client);
	}

	@Override
	public Client get(int clientId) {
		return this.clients.get(clientId);
	}

}
