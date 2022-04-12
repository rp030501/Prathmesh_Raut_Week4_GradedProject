package com.mile1.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.mile1.BooksService.BookService;
import com.mile1.bean.Book;
//Prathmesh Raut
public class Source {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		InputStreamReader a = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(a);

		String con;
		do {
			BookService bs = new BookService();
			int id;
			String bookName;
			String autorName;
			String desc;
			double price;
			int NumberOfBookSold;
			String genre;
			
			System.out.println("******* Welcome To Books Management System *******");
			System.out.println("Enter 1: To add the Book");
			System.out.println("Enter 2: To delete the Book");
			System.out.println("Enter 3: To update the Book");
			System.out.println("Enter 4: To display all the books");
			System.out.println("Enter 5: To see the count of all books");
			System.out.println("Enter 6: To see the all the books under Autobiography genre");
			System.out.println("Enter 7: To see the book price from Low to High");
			System.out.println("Enter 8: To see the book price from High to Low");
			System.out.println("Enter 9: To see best sellings book");
			int check = sc.nextInt();
			switch (check) {
			case 1:
				System.out.println("Enter the book ID: ");
				id = sc.nextInt();
				Book b1 = new Book();
				b1.setId(id);
				System.out.println("Enter the Book name: ");
				bookName = bf.readLine();
				b1.setBookName(bookName);
				System.out.println("Enter the Author Name:");
				autorName = bf.readLine();
				b1.setAuthorName(autorName);
				System.out.println("Enter the Description: ");
				desc = bf.readLine();
				b1.setDescription(desc);
				System.out.println("Enter the book price: ");
				price = sc.nextDouble();
				b1.setPrice(price);
				System.out.println("Enter the NumberOfBookSolds: ");
				NumberOfBookSold = sc.nextInt();
				b1.setNo_of_booksSold(NumberOfBookSold);
				System.out.println("Enter the book genre: ");
				genre = bf.readLine();
				b1.setGenre(genre);
				bs.addBook(b1);
				break;
			case 2:
				System.out.println("Enter the book id ");
				id = sc.nextInt();
				bs.deleteBook(id);
				break;
			case 3:
				System.out.println("Enter the book ID:");
				id = sc.nextInt();
				Book b2 = new Book();
				b2.setId(id);
				System.out.println("Enter the Book name:");
				bookName = bf.readLine();
				b2.setBookName(bookName);
				System.out.println("Enter the Author Name:");
				autorName = bf.readLine();
				b2.setAuthorName(autorName);
				System.out.println("Enter the Description");
				desc = bf.readLine();
				b2.setDescription(desc);
				System.out.println("Enter the book price: ");
				price = sc.nextDouble();
				b2.setPrice(price);
				System.out.println("Enter the NumberOfBookSolds: ");
				NumberOfBookSold = sc.nextInt();
				b2.setNo_of_booksSold(NumberOfBookSold);
				System.out.println("Enter the book genre: ");
				genre = bf.readLine();
				b2.setGenre(genre);
				bs.addBook(b2);
				bs.updateBook(b2);
				break;
			case 4:
				bs.DisplayBook();
				break;
			case 5:
				bs.countSize();
				break;
			case 6:
				System.out.println("Enter the Autobiography genre: ");
				genre = bf.readLine();
				bs.autobiographyGenre(genre);
				break;
			case 7:
				bs.PrintLowToHigh();
				break;
			case 8:
				bs.PrintHighToLow();
				break;
			case 9:
				bs.BestSelling();
				break;
			default:
				System.out.println("Enter the valid Choice");
				break;
			}
			System.out.println("Do u want to continue?");
			con = sc.next();
		} while (con.equalsIgnoreCase("yes"));
	}

}
