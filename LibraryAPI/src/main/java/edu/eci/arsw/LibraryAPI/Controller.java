package edu.eci.arsw.LibraryAPI;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/Libraries")
public class Controller {
	@Autowired
	Services s;
	
	
	@GetMapping("/Libraries")
	public ResponseEntity<?> getLibraries(){
		Object data = s.getAllLibraries();
		return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Libraries/{name}")
	public ResponseEntity<?> getBooks(@PathVariable("name") String name){
		try{
			Object data = s.getAllBooks(name);
			return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/Libraries/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteLibrary(@PathVariable("name") String name){
		ArrayList<Book> data = s.getAllBooks(name);
		if (data.size()==0) {
			return new ResponseEntity<>(data, HttpStatus.FORBIDDEN);
		}
		else {
			s.delLibrary(name);
			return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
		}
	}
	
	/*@RequestMapping(value = "/Libraries/{name}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> addLibrary(@PathVariable("name") String name,int id, String libro, String autor, String sinopsis){
		try {
			s.addBook(name,id,libro,autor,sinopsis);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}*/
	
	@RequestMapping(value = "/Libraries/{name}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> addLibrary(@PathVariable("name") String name, Book libro){
		try {
			s.addBook(name,libro);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}
