package ar.com.carloscurotto.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ar.com.carloscurotto.rest.domain.Client;
import ar.com.carloscurotto.rest.dto.ClientDTO;
import ar.com.carloscurotto.rest.resource.ClientResource;
import ar.com.carloscurotto.rest.service.ServiceProvider;

@Path("/clients")
public class ClientController implements ClientResource {

	public ClientController() {
		System.out.println("creating client controller");
	}

	@Override
	@Path("/store")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void store(ClientDTO clientDTO) {
		Client client = ClientDTO.toDomain(clientDTO);
		ServiceProvider.getInstance().getClientService().store(client);
	}
	
	@Override
	@Path("/remove/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void remove(int clientID) {
		ServiceProvider.getInstance().getClientService().remove(clientID);
	}	

	@Override
	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ClientDTO get(@PathParam("id") int clientID) {
		Client client = ServiceProvider.getInstance().getClientService()
				.get(clientID);
		if (client == null) {
			throw new NotFoundException();
		}
		return ClientDTO.fromDomain(client);
	}

	@Path("/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "hello world";
	}

}
