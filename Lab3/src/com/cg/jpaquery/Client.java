package com.cg.jpaquery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Book book = new Book();
		book.setISBN(1043);
		book.setTitle("Secret of Chambers");
		book.setPrice(100);

		Author author = new Author();
		author.setId(354);
		author.setName("J.K.Rowling");

		author.addBook(book);

		em.persist(author);

		System.out.println("Added author and book to database");

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

}
