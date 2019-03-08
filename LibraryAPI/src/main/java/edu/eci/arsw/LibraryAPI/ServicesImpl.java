package edu.eci.arsw.LibraryAPI;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class ServicesImpl implements Services {
	
	public ArrayList<Library> libraries;

	@Override
	public ArrayList<Library> getAllLibraries() {
		libraries = new ArrayList<Library>();
		libraries.add(new Library(1, "CarloMagno", 3103, "Calle 94 # 54-78"));
		return libraries;
	}

	@Override
	public ArrayList<Book> getAllBooks(String library) {
		libraries = new ArrayList<Library>();
		libraries.add(new Library(1, "CarloMagno", 3103, "Calle 94 # 54-78"));
		Library ll= libraries.get(0);
		ll.libros.add(new Book (1,"Cien años de soledad","Gabo","Muy buen libro"));
		for (Library l:libraries) {
			if (l.getNombre().equals(library)) return l.getLibros();
		}
		return null;
	}

	@Override
	public void delLibrary(String name) {
		for (Library l : libraries) {
			if (l.getNombre().equals(name)) {
				libraries.remove(l);
				break;
			}
		}
		
	}

	@Override
	public void addBook(String library, Book libro) {
		libraries = new ArrayList<Library>();
		libraries.add(new Library(1, "CarloMagno", 3103, "Calle 94 # 54-78"));
		for (Library l : libraries) {
			if (l.getNombre().equals(library)) {
				l.libros.add(libro);
				break;
			}
		}
		sendEmail();
		
	}
	


	public void sendEmail(){
		Properties properties= new Properties();
		Session session;
		properties.put("mail.smtp.host", "mail.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port",25);
		properties.put("mail.smtp.mail.sender","nicolasnc010@gmail.com");
		properties.put("mail.smtp.user", "nicolasnc010@gmail.com");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("nicolasnc010@gmail.com"));
			message.setSubject("LibraryAPI");
			message.setText("El libro fue añadido con éxito");
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("nicolasnc010@gmail.com"), "nontoacaballero");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
                        //Aqui se deberia o mostrar un mensaje de error o en lugar
                        //de no hacer nada con la excepcion, lanzarla para que el modulo
                        //superior la capture y avise al usuario con un popup, por ejemplo.
			return;
		}
		
	}

}
