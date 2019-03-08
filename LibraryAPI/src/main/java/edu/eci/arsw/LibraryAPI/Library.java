package edu.eci.arsw.LibraryAPI;

import java.util.ArrayList;

public class Library {
	
	public int id,telefono;
	public String nombre,direccion;
	public static ArrayList<Book> libros;

	public Library() {}
	
	public Library(int id,String nombre,int telefono, String direccion) {
		this.id=id;
		this.nombre=nombre;
		this.telefono=telefono;
		this.direccion=direccion;
		libros= new ArrayList<Book>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Book> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Book> libros) {
		this.libros = libros;
	}
	

}
