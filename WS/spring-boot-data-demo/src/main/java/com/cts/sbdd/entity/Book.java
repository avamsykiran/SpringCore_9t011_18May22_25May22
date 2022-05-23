package com.cts.sbdd.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bcode;
	private String title;
	private Double price;
	private LocalDate publishDate;
	
	public Book() {
		super();
	}

	public Book(Long bcode, String title, Double price, LocalDate publishDate) {
		super();
		this.bcode = bcode;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
	}

	public Long getBcode() {
		return bcode;
	}

	public void setBcode(Long bcode) {
		this.bcode = bcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [bcode=" + bcode + ", title=" + title + ", price=" + price + "]";
	}
	
	
}
