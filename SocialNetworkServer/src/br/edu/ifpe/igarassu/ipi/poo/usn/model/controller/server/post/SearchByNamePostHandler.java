/*
 *
 * IFPE - Federal Institute of Education, Science and Technology of Pernambuco
 * Informatics for the Internet
 * Object Oriented Programming
 * Professor: Allan Lima - allan.lima@igarassu.ifpe.edu.br
 * 
 * Public domain code, feel free to use, modify and redistribute it 
 *
 */

package br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.post;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.post.Post;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.UserSocialNetworkFacade;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.AbstractHandler;

/**
 *
 * Handles a request to search for posts by their names.
 * 
 * @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
 *
 */
public class SearchByNamePostHandler extends AbstractHandler {

	/**
	 * 
	 * Initializes its attributes
	 * 
	 * @param facade the facade of the system, containing the methods necessary to
	 *               the operation handled by this class
	 */
	public SearchByNamePostHandler(UserSocialNetworkFacade facade) {
		super(facade);
	}

	/**
	 * 
	 * Handles a request to search for posts by their names.
	 * 
	 * @param exchange the object containing the metadata of the request
	 * 
	 */
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		try {
			printRequestInfo(exchange);

			Map<String, Object> parameters = parsePostParameters(exchange);

			Object parameter = parameters.get("name");
			String name = "";

			if (parameter != null) {
				name = parameter.toString();
			}

			System.out.println("search post: " + name);
			List<Post> posts = super.getFacade().searchPostByName(name);

			ObjectMapper mapper = new ObjectMapper();

			String response = mapper.writeValueAsString(posts);
			System.out.println(response);
			exchange.sendResponseHeaders(200, response.length());
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();

		} catch (Exception ex) {
			ex.printStackTrace();

			// TODO change the response to a JSON Object
			String response = "Failure";

			exchange.sendResponseHeaders(401, response.length());

			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

}
