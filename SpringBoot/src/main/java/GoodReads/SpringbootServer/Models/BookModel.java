package GoodReads.SpringbootServer.Models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class BookModel {


    private String bookId;
    private String title;
    private String authors;
    private String description;
    private Float rating;

    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }
    public void setRating(Float rating) {
        this.rating = rating;
    }

    // return bookid and title only
    @Override
    public String toString(){
        return "Book[bookId=%s, title=%s]".formatted(bookId, title);
    }

    // what i want to display when i /books(link with controller), for this only bookid and title will be outputted
    public JsonObject toBookSummary(){
        return Json.createObjectBuilder()
        .add("bookId", bookId)
        .add("title", title)
        .build();
    }

    public JsonObject toBook(){
        return Json.createObjectBuilder()
        .add("bookId", bookId)
        .add("title", title)
        .add("authors", authors)
        .add("description", description)
        .add("rating", rating)
        .build();
    }

    //exact fields from the database
    public static BookModel create(SqlRowSet sqlRowSet) {
        BookModel bookModel = new BookModel();
        bookModel.setBookId(sqlRowSet.getString("book_id"));
        bookModel.setTitle(sqlRowSet.getString("title"));
        bookModel.setAuthors(sqlRowSet.getString("authors"));
        bookModel.setDescription(sqlRowSet.getString("description"));
        bookModel.setRating(sqlRowSet.getFloat("rating"));
        return bookModel;
    }

    
}
