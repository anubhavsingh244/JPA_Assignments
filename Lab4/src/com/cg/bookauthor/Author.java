package com.cg.bookauthor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;


	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "Book_aUTHOR", joinColumns = { @JoinColumn(name = "author_id") }, inverseJoinColumns = { @JoinColumn(name = "isbn") })
	private Set<Book> book = new HashSet<>(); // required to avoid
													// NullPointerException

	
	

	public void setProducts(Set<Book> book) {
		this.book = book;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addBook(Book book) {
		this.getBook().add(book);
	}
	
	public Set<Book> getBook() {
		return book;
	}

}
