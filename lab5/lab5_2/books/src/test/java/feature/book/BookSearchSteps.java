package feature.book;

import java.time.*;
import java.util.*;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookSearchSteps {
    Library library = new Library();
	List<Book> result = new ArrayList<>();
	List<Book> authors = new ArrayList<>();
	List<Book> categories = new ArrayList<>();

	@ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }

	@Given("a book with the title {string}, written by {string}, published in {date}")
	public void addNewBook(final String title, final String author, final LocalDateTime published) {
		Date p = Date.from(published.toInstant(ZoneOffset.UTC));
		Book book = new Book(title, author, p);
		library.addBook(book);
	}

	@And("another book with the title {string}, written by {string}, published in {date}")
	public void addAnotherBook(final String title, final String author, final LocalDateTime published) {
		Date p = Date.from(published.toInstant(ZoneOffset.UTC));
		Book book = new Book(title, author, p);
		library.addBook(book);

	}

	@When("the customer searches for books published between {date} and {date}")
	public void setSearchParameters(final LocalDateTime from, final LocalDateTime to) {
		Date p1 = Date.from(from.toInstant(ZoneOffset.UTC));
        Date p2 = Date.from(to.toInstant(ZoneOffset.UTC));
		result = library.findBooks(p1, p2);
	}

	@Then("{int} books should have been found")
	public void verifyAmountOfBooksFound(final int booksFound) {
        assertEquals(result.size(), booksFound);
	}

	@Then("Book {int} should have the title {string}")
	public void verifyBookAtPosition(final int position, final String title) {
        assertEquals(result.get(position - 1).getTitle(), title);
	}

	@When("the customer searches for books written by {string}")
    public void searchForBooksWithTitle(String author) {
        authors = library.findBooksByAuthor(author);
		//for (Book b: authors)
		//	System.out.println(b);
    }

	@Then("{int} book(s) written by {string} should have been found")
	public void verifyAmountOfBooksFoundBy(final int booksFound, String author) {
		assertEquals(authors.size(), booksFound);
	}

	@Then("Book {int} should have the title {string} and published in {date}")
	public void verifyBooksByAuthorTitle(final int booksFound, String title, final LocalDateTime d) {
		assertEquals(authors.get(booksFound - 1).getTitle(), title);
	}
}
