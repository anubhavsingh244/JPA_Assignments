package com.cg.bookauthor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		
		Author author1 = new Author();
		author1.setName("Arnab");
		author1.setId(1);
		
		Author author2 = new Author();
		author2.setName("Atanu");
		author2.setId(2);
		
		Book book1 = new Book();
		book1.setId(1234);
		book1.setName("physics");
		book1.setPrice(100);
		
		Book book2 = new Book();
		book2.setId(4556);
		book2.setName("chemistry");
		book2.setPrice(200);
		
		Book book3 = new Book();
		book3.setId(859);
		book3.setName("Math");
		book3.setPrice(300);
		
		author1.addBook(book1);
		author1.addBook(book2);
		author1.addBook(book3);
		
		em.persist(author1);
			
		
		//------------------2.2.a Select Book---------------------//
		
			String qStr1 = "SELECT book FROM Book book";
			TypedQuery<Book> query1 = em.createQuery(qStr1, Book.class);
			
			List<Book> bookList1 = query1.getResultList();
			for(Book b : bookList1)
				System.out.println(b.toString());
			
			
			//-------------------2.2.c------------------------------------//		
			
			
				String qStr2 = "SELECT book FROM Book book WHERE book.price between :low and : high";
				TypedQuery<Book> query2 = em.createQuery(qStr2, Book.class);
				query2.setParameter("low", 200.0);
				query2.setParameter("high", 1000.0);
				List<Book> bookList2 = query2.getResultList();
				for(Book b : bookList2)
					System.out.println(b.toString());
				

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	
	
	

}
