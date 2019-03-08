package edu.eci.arsw.LibraryAPI;

public class Book {

	int id;
	String nombre, autor, sinopsis;

	public Book() {
	}

	public Book(int id, String nombre, String autor, String sinopsis) {
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.sinopsis = sinopsis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

}
