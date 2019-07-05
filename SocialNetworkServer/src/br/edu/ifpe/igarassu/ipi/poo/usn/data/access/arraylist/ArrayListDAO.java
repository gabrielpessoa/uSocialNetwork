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

package br.edu.ifpe.igarassu.ipi.poo.usn.data.access.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.Entity;


/**
 * 
 * Represents a template of Data Access Object that saves its data on memory.
 * You can extend this class to easily create new Data Access Objects for
 * distinct types entities.
 * 
 * @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
 *
 * @param <T> The type to be stored
 */
public class ArrayListDAO<T extends Entity> {

	// the elements stored by the system
	private ArrayList<T> elements;

	/**
	 * 
	 * Initializes the attributes of this class
	 * 
	 */
	public ArrayListDAO() {
		this.setElements(new ArrayList<T>());
	}

	/**
	 * 
	 * Returns the elements stored by this object as a List
	 * 
	 * @return the elements stored by this object as a List
	 */
	public List<T> list() {
		return elements;
	}

	/**
	 * 
	 * Sets the elements stored by this object as a List
	 * 
	 * @param elements the list of elements.
	 */
	private void setElements(ArrayList<T> elements) {
		this.elements = elements;
	}

	/**
	 * 
	 * Add an element to the collection
	 * 
	 * @param element the element to be added
	 */
	public void add(T element) {

		if (element == null) {
			// TODO change to a distinct exception
			throw new NullPointerException();
		}

		// TODO autogenerate the id

		this.list().add(element);
	}

	/**
	 * 
	 * Removes an element from the collection
	 * 
	 * @param id the id of the element to be removed
	 */
	public void removeById(int id) {
		for (int i = 0; i < this.elements.size(); i++) {
			if (this.elements.get(i).getId() == id) {
				this.elements.remove(i);
				return; // once the element is found, the loop stops
			}
		}
	}


	/**
	 * 
	 * Searches for an element on the collection
	 * 
	 * @param id the id of the element to be searched
	 * 
	 * @return the element found or null if the element is not present on the
	 *         collection
	 */
	public T searchById(long id) {
		for (Iterator<T> iterator = this.list().iterator(); iterator.hasNext();) {
			T element = iterator.next();
			if (element.getId() == id) {
				return element;
			}
		}

		return null;
	}

	/**
	 * 
	 * Returns the number of elements stored on the collection
	 * 
	 * @return the number of elements stored on the collection
	 */
	public int size() {
		return this.list().size();
	}

}
