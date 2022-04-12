package com.mile1.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String bookName;
	private String authorName;
	private String Description;
	private double Price;
	private int No_of_booksSold;
	private String genre;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String bookName, String authorName, String description, double price, int no_of_booksSold,
			String genre) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		Description = description;
		Price = price;
		No_of_booksSold = no_of_booksSold;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getNo_of_booksSold() {
		return No_of_booksSold;
	}

	public void setNo_of_booksSold(int no_of_booksSold) {
		No_of_booksSold = no_of_booksSold;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", Description="
				+ Description + ", Price=" + Price + ", No_of_booksSold=" + No_of_booksSold + ", genre=" + genre + "]";
	}

}
