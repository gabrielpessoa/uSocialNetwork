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

package br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.post;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.access.arraylist.ArrayListDAO;

/**
 * 
 * Data access object for posts using a ArrayList as collection
 * 
 * @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
 *
 */
public class PostArrayListDAO extends ArrayListDAO<Post> implements PostDAO {
	

	/**
	 * 
	 * Search for users containing the string <code>mensagem</code> on their
	 * mensagems
	 * 
	 * @param name the name to be searched
	 * 
	 * @return a list of <code>Users</code> the contain the string <code>name</code>
	 *         on their names, if there is no results on the search, the method will
	 *         return an empty list.
	 */
	@Override
	public List<Post> searchByName(String mensagem) {
		List<Post> result = new ArrayList<Post>(); // the list with users to be returned

		// notice who the code utilizes an Iterator in order to navigate through all
		// elements on the collection
		for (Iterator<Post> iterator = this.list().iterator(); iterator.hasNext();) {
			Post element = iterator.next();
			if (element.getMensagem().toLowerCase().contains(mensagem.toLowerCase())) {
				result.add(element);
			}
		}

		return result;
	}

	@Override
	public Post searchById(int idPost) {
		return null;
	}

	@Override
	public void updateById(int idPost) {

	}




}
