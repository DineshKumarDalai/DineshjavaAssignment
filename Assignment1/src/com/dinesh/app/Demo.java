package com.dinesh.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Demo {
	
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<Book>();

		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			
			Connection conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net/sql6400624",  "sql6400624","djZTpQeLFb" );
			System.out.println("Connected database successfully...");

			Statement stmt = conn.createStatement();

			String sql = "SELECT * FROM Books where BookType=1 ORDER BY BookName asc";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Book book = new Book();
				book.setBookType(rs.getInt("BookType"));
				book.setBookName(rs.getString("BookName"));
				book.setAuthor(rs.getString("Author"));

				books.add(book);
				for (Book book2 : books) {
					System.out.println("Book type ="+book2.getBookType() + "  Book Name = " + book2.getBookName()+"  Author name ="+book2.getAuthor());
				}
			}

			rs.close();
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
