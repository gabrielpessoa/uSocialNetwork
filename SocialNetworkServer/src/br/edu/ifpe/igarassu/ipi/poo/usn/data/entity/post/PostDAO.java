package br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.post;

import java.util.List;

public interface PostDAO {

	/**
	 * 
	 * Returns the posts stored as a List
	 * 
	 * @return the posts stored as a List
	 */
	public List<Post> list();

	/**
	 * 
	 * Add an post to the collection
	 * 
	 * @param post the post to be added
	 */
	public void add(Post post);

	/**
	 * 
	 * Removes an post from the collection
	 * 
	 * @param id the id of the post to be removed
	 */
	public void removeById(int idPost);

	/**
	 * 
	 * Searches for an post on the collection
	 * 
	 * @param id the id of the post to be searched
	 * 
	 * @return the post found or null if the element is not present on the
	 *         collection
	 */
	public Post searchById(int idPost);

	/**
	 * 
	 * Returns the number of posts stored on the collection
	 * 
	 * @return the number of elements stored on the collection
	 */
	public int size();

	/**
	 * 
	 * Search for posts containing the string <code>name</code> on their names
	 * 
	 * @param name the name to be searched
	 * 
	 * @return a list of <code>posts</code> the contain the string <code>name</code> on their names, if there is no results on the search, the method will return an empty list.
	 */
	public List<Post> searchByName(String mensagem);

	public void updateById(int idPost);
	
}