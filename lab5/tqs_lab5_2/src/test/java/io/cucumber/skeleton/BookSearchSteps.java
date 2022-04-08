package io.cucumber.skeleton;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookSearchSteps {
    Library library = new Library();
	List<Book> result = new ArrayList<>();

    //https://stackoverflow.com/questions/40163721/date-object-in-cucumber
    @ParameterType("([0-9]{2})-([0-9]{2})-([0-9]{4})")
    public LocalDateTime iso8601Date(String month, String day, String year){
        return LocalDateTime.of(Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(year),0, 0);
    }
 
	@Given("(a|another) book with the title {string}, written by {string}, published in {iso8601Date}")
	public void addNewBook(final String title, final String author, final Date published) {
        Date p = Date.from(published.toInstant());
		Book book = new Book(title, author, p);
		library.addBook(book);
	}
 
	@When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
	public void setSearchParameters(final Date from, final Date to) {
        Date p1 = Date.from(from.toInstant());
        Date p2 = Date.from(to.toInstant());
		result = library.findBooks(p1, p2);
	}
 
	@Then("{int} books should have been found")
	public void verifyAmountOfBooksFound(final int booksFound) {
		assertThat(result.size(), equalTo(booksFound));
	}
 
	@Then("Book {int} should have the title {string}")
	public void verifyBookAtPosition(final int position, final String title) {
		assertThat(result.get(position - 1).getTitle(), equalTo(title));
	}
}