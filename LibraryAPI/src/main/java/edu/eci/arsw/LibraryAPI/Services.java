package edu.eci.arsw.LibraryAPI;

import java.util.ArrayList;

public interface Services {

	public ArrayList<Library> getAllLibraries();
	
	public ArrayList<Book> getAllBooks(String library);

	public void delLibrary(String name);
	
	public void addBook(String library, Book libro);
	
	
}
