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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.net.httpserver.HttpExchange;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.post.Post;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.PostSocialNetworkFacade;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.UserSocialNetworkFacade;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.AbstractHandler;

/**
*
* Handles a request to get an post by its id.
* 
* @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
*
*/
public class GetPostByIdHandler extends AbstractHandler {

	/**
	 * 
	 * Initializes its attributes
	 * 
	 * @param facade the facade of the system, containing the methods necessary to
	 *               the operation handled by this class
	 */
	public GetPostByIdHandler(UserSocialNetworkFacade facade) {
		super(facade);
	}


	/**
	 * 
	 * Handles a request to get an post by its id.
	 * 
	 * @param exchange the object containing the metadata of the request
	 * 
	 */
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		printRequestInfo(exchange);

		try {
			String[] path = exchange.getRequestURI().getPath().split("/");

			// TODO add error verifications
			String postId = path[3];
			System.out.println(postId);

			Post post = getFacade().searchPostById(Integer.parseInt(postId));
			String response = getMapper().writeValueAsString(post);
			System.out.println(response);
			
			exchange.sendResponseHeaders(200, response.length());
			
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();

		} catch (JsonProcessingException ex) {
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
