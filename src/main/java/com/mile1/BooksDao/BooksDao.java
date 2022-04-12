package com.mile1.BooksDao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.mile1.bean.Book;

public class BooksDao {
	public int addBook(Book obj) {
		SessionFactory conn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = conn.getCurrentSession();

		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			conn.close();
		}
		return 0;
	}

	public int deleteBook(int id) {
		SessionFactory conn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = conn.getCurrentSession();
		Book b = session.get(Book.class, id);
		if (b == null) {
			return 0;
		} else {
			try {
				session.beginTransaction();
				session.delete(b);
				session.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				session.close();
				conn.close();
			}
			return 1;

		}

	}

	public int updateBook(Book b2) {
		SessionFactory conn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = conn.getCurrentSession();
		Book obj = session.get(Book.class, b2.getId());
		if (obj == null) {
			return 0;
		} else {
			try {
				session.beginTransaction();
				obj.setBookName(b2.getBookName());
				obj.setAuthorName(b2.getAuthorName());
				obj.setDescription(b2.getDescription());
				obj.setPrice(b2.getPrice());
				session.update(obj);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				conn.close();
			}
			return 1;
		}

	}

	public void displayBooks() {
		SessionFactory conn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = conn.getCurrentSession();
		try {
			session.beginTransaction();
			List<Book> arr = session.createQuery("from Book").list();
			arr.stream().forEach(b -> System.out.println(b));
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
			conn.close();
		}
	}

	public int countBooks() {
		SessionFactory conn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = conn.getCurrentSession();
		try {
			session.beginTransaction();
			List<Book> arr = session.createQuery("from Book").list();
			session.getTransaction().commit();
			return arr.size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			conn.close();
		}
		return 0;
	}

	public void PriceLowToHigh() {
		SessionFactory conn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = conn.getCurrentSession();
		try {
			session.beginTransaction();
			List<Book> arr = session.createQuery("from Book").list();
			Comparator cl = Comparator.comparing(Book::getPrice);
			Collections.sort(arr, cl);
			arr.stream().forEach(a -> System.out.println(a));
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			conn.close();
		}
	}

	public void PriceHighToLow() {
		SessionFactory conn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = conn.getCurrentSession();
		try {
			session.beginTransaction();
			List<Book> arr = session.createQuery("from Book").list();
			Comparator cl = Comparator.comparing(Book::getPrice);
			Collections.sort(arr, cl);
			Collections.reverse(arr);
			arr.stream().forEach(a -> System.out.println(a));
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			conn.close();
		}
	}

	public void BestSelling() {
		SessionFactory conn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = conn.getCurrentSession();
		try {
			session.beginTransaction();
			List<Book> arr = session.createQuery("from Book").list();
			Comparator cl = Comparator.comparing(Book::getNo_of_booksSold);
			System.out.println(Collections.max(arr, cl));
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			conn.close();
		}
	}

	public void autobiographyGenre(String genre1) {
		SessionFactory conn = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = conn.getCurrentSession();
		try {
			session.beginTransaction();
			Query qry = session.createQuery("from Book b where b.genre = :a");
			qry.setParameter("a", genre1);
			List<Book> bk = qry.list();
			System.out.println(bk);

			// book.forEach(a->System.out.println(a));
//			List<Book> arr = session.createSQLQuery("select genre from Book").list();
//			arr.forEach(a -> System.out.println(a));
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			conn.close();
		}
	}
}