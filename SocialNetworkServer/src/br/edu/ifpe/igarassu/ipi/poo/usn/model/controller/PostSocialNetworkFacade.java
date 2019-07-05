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

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.post.Post;

/**
*
* Facade of the Social Network, contains all methods of its functionalities for a standard post 
* 
* @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
*
*/
public interface PostSocialNetworkFacade {

	/**
	 * 
	 * Add an Post
	 * 
	 * @param post the post to be added
	 */
	public void addPost(Post post);

	/**
	 * 
	 * Searches for an user
	 * 
	 * @param id the id of the user to be searched 
	 * 
	 * @return the user found or null if the user is not present on the collection 
	 */
	public Post searchPostById(int postId);

	/**
	 * 
	 * Returns the number of posts
	 * 
	 * @return the number of posts
	 */
	public int numberOfPosts();

	/**
	 * 
	 * Returns the posts stored as a List
	 * 
	 * @return the elements stored as a List
	 */
	public List<Post> listPosts();

	/**
	 * 
	 * Search for users containing the string <code>name</code> on their names
	 * 
	 * @param name the name to be searched
	 * 
	 * @return a list of <code>Users</code> the contain the string <code>name</code> on their names, if there is no results on the search, the method will return an empty list.
	 */
	public List<Post> searchPostByName(String name);

	/**
	 * 
	 * Removes an user
	 * 
	 * @param id the id of the user to be removed
	 */
	public void removePostById(int postId);
	
	public void updatePostById(int postId);

}