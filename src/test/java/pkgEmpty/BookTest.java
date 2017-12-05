
package pkgEmpty;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;

public class BookTest {

@Test
	public void TestCatalog()
	{
		Catalog cat = Catalog.ReadXMLFile();
		System.out.println(cat.getId());
		System.out.println(cat.getBooks().size());
		Book b = new Book();
		b.setAuthor("Alvin");
		b.setTitle("Harry Potter");
		b.setGenre("Novel");
		b.setDescription("Harry Potter is a series of fantasy novels written by British author J. K. Rowling, "
				+ "The novels chronicle the life of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry. "
				+ "The main story arc concerns Harry's struggle against Lord Voldemort, a dark wizard who intends to become immortal, "
				+ "overthrow the wizard governing body known as the Ministry of Magic, and subjugate all wizards and muggles, a reference term that means non-magical people.");
		b.setId("bk112");
	
		String inputString = "09-03-1995";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = null;
		try {
			inputDate = dateFormat.parse(inputString);
		} catch (ParseException e) {
			fail("Exception raised");
		}
		b.setPublish_date(inputDate);
		b.setPrice(19.99);
		
		try {
			Book.addBook(cat, b);
		} catch (BookException e) {
			fail("Exception raised");
		}
		
		System.out.println(cat.getBooks().size());
		
		Book bookGet=null;
		try {
			 bookGet = Book.getBook(cat, b.getId());
		} catch (BookException e) {
			fail("Exception raised");
		}
		assertEquals(b.getId(), bookGet.getId());
		System.out.println("passed");
	}

}