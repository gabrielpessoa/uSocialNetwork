package br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.user;

import java.util.List;

public interface UserDAO {

	/**
	 * 
	 * Returns the users stored as a List
	 * 
	 * @return the users stored as a List
	 */
	public List<User> list();

	/**
	 * 
	 * Add an user to the collection
	 * 
	 * @param user the user to be added
	 */
	public void add(User user);

	/**
	 * 
	 * Removes an user from the collection
	 * 
	 * @param id the id of the user to be removed
	 */
	public void removeById(int id);

	/**
	 * 
	 * Searches for an user on the collection
	 * 
	 * @param id the id of the user to be searched
	 * 
	 * @return the user found or null if the element is not present on the
	 *         collection
	 */
	public User searchById(long id);

	/**
	 * 
	 * Returns the number of users stored on the collection
	 * 
	 * @return the number of elements stored on the collection
	 */
	public int size();

	/**
	 * 
	 * Search for users containing the string <code>name</code> on their names
	 * 
	 * @param name the name to be searched
	 * 
	 * @return a list of <code>Users</code> the contain the string <code>name</code> on their names, if there is no results on the search, the method will return an empty list.
	 */
	public List<User> searchByName(String name);

	public void updateById(long id);
	
}