package feature.book;

import java.util.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookSearchSteps {
    Library library = new Library();
	List<Book> result = new ArrayList<>();

	@Given(".+book with the title {string}, written by {string}, published in (.+)")
	public void addNewBook(final String title, final String author, final Date published) {
		Book book = new Book(title, author, published);
		library.addBook(book);
	}

	@When("^the customer searches for books published between (\\d+) and (\\d+)$")
	public void setSearchParameters(final Date from, final Date to) {
		result = library.findBooks(from, to);
	}

	@Then("(\\d+) books should have been found$")
	public void verifyAmountOfBooksFound(final int booksFound) {
        assertEquals(result.size(), booksFound);
	}

	@Then("Book (\\d+) should have the title '(.+)'$")
	public void verifyBookAtPosition(final int position, final String title) {
        assertEquals(result.get(position - 1).getTitle(), title);
	}
}
