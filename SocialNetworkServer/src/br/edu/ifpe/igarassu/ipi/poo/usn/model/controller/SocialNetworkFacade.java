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

package br.edu.ifpe.igarassu.ipi.poo.usn.model.controller;

import java.util.List;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.user.User;
import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.user.UserArrayListDAO;
import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.user.UserDAO;

/**
 *
 * Facade of the Social Network, contains all methods of its functionalities for
 * a standard user
 * 
 * @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
 *
 */
public class SocialNetworkFacade implements UserSocialNetworkFacade {

	// the collection of users
	private UserDAO UsersDAO = new UserArrayListDAO();

	/**
	 * 
	 * Add an user
	 * 
	 * @param user the user to be added
	 */
	@Override
	public void addUser(User user) {
		this.UsersDAO.add(user);
	}

	/**
	 * 
	 * Searches for an user on
	 * 
	 * @param id the id of the user to be searched
	 * 
	 * @return the user found or null if the user is not present on the collection
	 */
	@Override
	public User searchUserById(long id) {
		return this.UsersDAO.searchById(id);
	}

	/**
	 * 
	 * Returns the number of users stored
	 * 
	 * @return the number of users stored
	 */
	@Override
	public int numberOfUsers() {
		return this.UsersDAO.size();
	}

	/**
	 * 
	 * Returns the users stored as a List
	 * 
	 * @return the elements stored as a List
	 */
	@Override
	public List<User> listUsers() {
		return this.UsersDAO.list();
	}

	/**
	 * 
	 * Search for users containing the string <code>name</code> on their names
	 * 
	 * @param name the name to be searched
	 * 
	 * @return a list of <code>Users</code> the contain the string <code>name</code>
	 *         on their names, if there is no results on the search, the method will
	 *         return an empty list.
	 */
	@Override
	public List<User> searchUserByName(String name) {
		return this.UsersDAO.searchByName(name);
	}

	/**
	 * 
	 * Remove an user
	 * 
	 * @param id the id of the user to be removed
	 */
	@Override
	public void removeUserById(int id) {
		this.UsersDAO.removeById(id);

	}
	@Override
	public void updateUserById(int id) {
		this.UsersDAO.updateById(id);
	}


}
