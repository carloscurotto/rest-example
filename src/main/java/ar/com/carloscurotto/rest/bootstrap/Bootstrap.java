package ar.com.carloscurotto.rest.bootstrap;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * This class handles the application lifecycle.
 * 
 * @author carloscurotto
 * 
 */
public class Bootstrap {
	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:9090/client-profile";

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// create a resource config that scans for JAX-RS resources and
		// providers
		// in ar.com.carloscurotto.rest package
		final ResourceConfig rc = new ResourceConfig()
				.packages("ar.com.carloscurotto.rest");

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),
				rc);
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
		System.out.println("Jersey app started with WADL available at "
				+ BASE_URI + "/application.wadl\nHit enter to stop it...");
		System.in.read();
		server.stop();
	}
}
