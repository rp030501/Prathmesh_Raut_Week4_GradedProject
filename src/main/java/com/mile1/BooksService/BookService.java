package com.mile1.BooksService;

import com.mile1.BooksDao.BooksDao;
import com.mile1.bean.Book;

public class BookService {
	public void addBook(Book b) {
		BooksDao b1 = new BooksDao();
		int a = b1.addBook(b);
		if (a == 1) {
			System.out.println("Record Added Succesfully");
		} else {
			System.out.println("Record not added");
		}
	}

	public void deleteBook(int id) {
		BooksDao b1 = new BooksDao();
		int a = b1.deleteBook(id);
		if (a == 1) {
			System.out.println("Record Deleted Succesfully");
		} else {
			System.out.println("Record not delete");
		}
	}

	public void updateBook(Book b) {
		BooksDao b1 = new BooksDao();
		int a = b1.updateBook(b);
		if (a == 1) {
			System.out.println("Record Updated Successfully");
		} else {
			System.out.println("Record not updated");
		}
	}

	public void DisplayBook() {
		BooksDao b1 = new BooksDao();
		b1.displayBooks();
	}

	public void countSize() {
		BooksDao b1 = new BooksDao();
		System.out.println(b1.countBooks());
	}

	public void PrintLowToHigh() {
		BooksDao b1 = new BooksDao();
		b1.PriceLowToHigh();
	}

	public void PrintHighToLow() {
		BooksDao b1 = new BooksDao();
		b1.PriceHighToLow();
	}

	public void BestSelling() {
		BooksDao b1 = new BooksDao();
		b1.BestSelling();
	}

	public void autobiographyGenre(String genre) {
		BooksDao b1 = new BooksDao();
		b1.autobiographyGenre(genre);
	}
}
