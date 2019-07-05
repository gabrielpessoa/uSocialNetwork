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

package br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.SocialNetworkFacade;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.PostSocialNetworkFacade;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.UserSocialNetworkFacade;

/**
 * 
 * Contains all methods and attributes shared and useful the the handlers on this project.  
 * 
 * @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
 *
 */
public abstract class AbstractHandler implements HttpHandler {

	// the facade of the social network containing the methods needed for the operations performed by the handles 
	private UserSocialNetworkFacade facade = null;
	

	// object from the jackson library used the converts objects to JSOM and vice versa 
	private ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 
	 * Initializes the facade with the given parameter.  
	 * 	
	 * @param facade the facade of the 
	 */
	public AbstractHandler(UserSocialNetworkFacade facade) {
		this.facade = facade;
	}
	

	/**
	 * 
	 * Returns the facade of the social network
	 * 
	 * @return the facade of the social network
	 */
	public UserSocialNetworkFacade getFacade() {
		return this.facade;
	}

	/**
	 * 
	 * Returns the facade of the social network
	 * 
	 * @return the facade of the social network
	 */
	
	/**
	 * 
	 * Returns the JASON mapper object 
	 * 
	 * @return the JASON mapper object
	 */
	protected ObjectMapper getMapper() {
		return mapper;
	}

	/**
	 * Sets the JASON mapper object
	 * 
	 * @param mapper the new JASON mapper object
	 */
	protected void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}


	/**
	 * Parses the parameters of a POST request. This code of based on the following article: 	// code based on https://www.codeproject.com/Tips/1040097/Create-a-Simple-Web-Server-in-Java-HTTP-Server  
	 * 
	 * @param exchange metadata of the request
	 * 
	 * @return A <code><Map<String, Object>> containing the parameters of the request.
	 * 
	 * @throws UnsupportedEncodingException if the encoding used in the request is not supported
	 * @throws IOException if an I/O error occurs
	 */
	protected Map<String, Object> parsePostParameters(HttpExchange exchange) throws UnsupportedEncodingException, IOException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String query = br.readLine();
		parseQuery(query, parameters);
		
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}

		return parameters;
	}
	
	/**
	 * Auxiliary method to help parsing the parameters of a POST resquest
	 * 
	 * @param query the query to be parsed
	 * @param parameters the map where the data parsed will be stored
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public static void parseQuery(String query, Map<String, Object> parameters) throws UnsupportedEncodingException {
		if (query != null) {
			String pairs[] = query.split("[&]");
			for (String pair : pairs) {
				String param[] = pair.split("[=]");
				String key = null;
				String value = null;
				if (param.length > 0) {
					key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));
				}

				if (param.length > 1) {
					value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));
				}

				if (parameters.containsKey(key)) {
					Object obj = parameters.get(key);
					if (obj instanceof List<?>) {
						List<String> values = (List<String>) obj;
						values.add(value);

					} else if (obj instanceof String) {
						List<String> values = new ArrayList<String>();
						values.add((String) obj);
						values.add(value);
						parameters.put(key, values);
					}
				} else {
					parameters.put(key, value);
				}
			}
		}
	}


	/**
	 * 
	 * Prints on the standard output the metadata of a request 
	 * 
	 * @param exchange the metadata of a request
	 * 
	 * @throws MalformedURLException if the request contains a malformed URL
	 */
	public static void printRequestInfo(HttpExchange exchange) throws MalformedURLException {
		System.out.println("-- request --");
		System.out.println(exchange.getRequestBody());
		String requestedURL = "http://" + exchange.getRequestHeaders().getFirst("Host") + exchange.getRequestURI();
		System.out.println(requestedURL);
		URL u = new URL(requestedURL);
		System.out.println("Host: " + u.getHost());
		System.out.println("Port: " + u.getPort());

		System.out.println("-- headers --");
		Map<String, List<String>> requestHeaders = exchange.getRequestHeaders();
		requestHeaders.entrySet().forEach(System.out::println);

		System.out.println("-- principle --");
		Principal principal = exchange.getPrincipal();
		System.out.println(principal);

		System.out.println("-- HTTP method --");
		String requestMethod = exchange.getRequestMethod();
		System.out.println(requestMethod);

		System.out.println("-- query --");
		URI requestURI = exchange.getRequestURI();
		String query = requestURI.getQuery();
		System.out.println(query);

		System.out.println("-- context --");
		HttpContext context = exchange.getHttpContext();
		System.out.println(context.getPath());
	}

}
