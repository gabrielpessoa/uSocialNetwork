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

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.Entity;
import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.exception.InvalidDataException;

/**
 * 
 * Represents an post on the social network 
 * 
 * @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
 *
 */
public class Post extends Entity {
	// the name of the post
	private int idPost;
	private String mensagem;

	public Post(long id, int idPost, String mensagem) throws InvalidDataException {
		super(id);
		this.setIdPost(idPost);
		this.setMensagem(mensagem);
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) throws InvalidDataException {
		if(mensagem==null || mensagem.length()==0){
			throw new InvalidDataException("Mensagem Inválida");
		}
		this.mensagem = mensagem;
	}

}
