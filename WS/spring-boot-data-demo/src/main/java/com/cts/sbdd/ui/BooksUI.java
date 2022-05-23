package com.cts.sbdd.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sbdd.entity.Book;
import com.cts.sbdd.service.BooksService;

@Component
public class BooksUI implements CommandLineRunner {

	@Autowired
	private BooksService booksService;

	private Scanner scanner;
	
	private DateTimeFormatter format;
	
	@Override
	public void run(String... args) throws Exception {
		scanner = new Scanner(System.in);
		
		format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		int option=0;
		while(option!=4) {
			System.out.println("[1.Add,2.List,3.Delete,4.Quit]?? ");
			option = scanner.nextInt();
			
			switch(option) {
			case 1: doAdd(); break;
			case 2: doList(); break;
			case 3: doDelete(); break;
			case 4: System.out.println("We are done!"); break;
			}
		}
	}
	
	private void doAdd() {
		System.out.print("Title? ");
		String title = scanner.next();
		System.out.print("Price? ");
		double price = scanner.nextDouble();
		System.out.print("PublishDate(dd-MM-yyyy)?? ");
		LocalDate publishDate = LocalDate.parse(scanner.next(), format);
		
		Book book = new Book(null, title, price, publishDate);
		book = booksService.add(book);
		System.out.println("Book saved with book-code: "+book.getBcode());
	}
	
	private void doList() {
		List<Book> books =booksService.getAll();
		
		if(books.isEmpty())
			System.out.println("No Books in the store");
		else
			books.stream().forEach(System.out::println);
	}
	
	private void doDelete() {
		System.out.print("bcode? ");
		long bcode = scanner.nextInt();
		booksService.deleteById(bcode);
		System.out.println("DELETED!");
	}
}
