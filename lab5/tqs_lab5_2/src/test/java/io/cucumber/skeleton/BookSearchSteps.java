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

    //https://github.com/cucumber/cucumber-expressions#readme
    //https://stackoverflow.com/questions/40163721/date-object-in-cucumber
    @ParameterType("([0-9]{2})-([0-9]{2})-([0-9]{4})")
    public LocalDateTime date(String month, String day, String year){
        return LocalDateTime.of(Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(year),0, 0);
    }
 
	@Given("(a|another) book with the title {string}, written by {string}, published in {date}")
	public void addNewBook(final String title, final String author, final LocalDateTime published) {
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
		assertThat(result.size(), equalTo(booksFound));
	}
 
	@Then("Book {int} should have the title {string}")
	public void verifyBookAtPosition(final int position, final String title) {
		assertThat(result.get(position - 1).getTitle(), equalTo(title));
	}
}