package com.cg.jpacrud.client;

import com.cg.jpacrud.entities.Author;
import com.cg.jpacrud.service.AuthorService;
import com.cg.jpacrud.service.AuthorServiceImpl;

public class Client {

	public static void main(String[] args) {

		// Debug this program as Debug -> Debug as Java Application

		AuthorService service = new AuthorServiceImpl();

		Author author = new Author();
		author.setAuthorId(100);
		author.setFirstName("Sach");
		author.setPhoneNo(764346);
		service.addAuthor(author);

		/*
		 * // at this breakpoint, we have added one record to table author =
		 * service.findAuthorById(100); System.out.print("ID:" +
		 * author.getAuthorId()); System.out.println(" Name:" +
		 * author.getFirstName());
		 */

		author.setFirstName("Sachin");
		service.updateAuthor(author);

		/*
		 * // at this breakpoint, we have updated record added in first section
		 * author = service.findAuthorById(100); System.out.print("ID:" +
		 * author.getAuthorId()); System.out.println(" Name:" +
		 * author.getFirstName());
		 */

		// at this breakpoint, record is removed from table
		service.removeAuthor(author);

		System.out.println("End of program...");

	}

}
