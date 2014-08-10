package ar.com.carloscurotto.rest.service;

public class ServiceProvider {
	
	public static final ServiceProvider INSTANCE = new ServiceProvider();
	
	private ClientService clientService = new InMemoryClientService();
	
	private ServiceProvider() {}
	
	public static ServiceProvider getInstance() {
		return INSTANCE;
	}
	
	public ClientService getClientService() {
		return clientService;
	}

}
