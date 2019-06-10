package com.cg.bookauthor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int ISBN;

	private String name;

	private double price;

	@ManyToMany(fetch=FetchType.LAZY, mappedBy = "book")
	private Set<Author> author = new HashSet<>();

	public int getISBN() {
		return ISBN;
	}

	public void setId(int ISBN) {
		this.ISBN = ISBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Author> getOrders() {
		return author;
	}

	public void setAuthor(Set<Author> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", name=" + name + ", price=" + price
				+ ", author=" + author + "]";
	}
	
	

}
