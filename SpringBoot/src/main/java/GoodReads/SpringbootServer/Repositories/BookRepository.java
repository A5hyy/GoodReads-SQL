package GoodReads.SpringbootServer.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import GoodReads.SpringbootServer.Models.BookModel;

// Import the queries for queryforrowset()
import static GoodReads.SpringbootServer.Repositories.Queries.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

//To retrieve info from BookModel
@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //create a list of books
    public List<BookModel> getBooks(){
        // use jdbc template and insert the query you want to make
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(SQL_SELECT_BOOKS);

        List<BookModel> results = new LinkedList<>();
        // while running the query, add to results
        while (sqlRowSet.next())
            results.add(BookModel.create(sqlRowSet));

        // return result once the query is complete
        return results; 
    }

    //Optional because may or may not get the book
    public Optional<BookModel> getBook(String bookId){
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(SQL_SELECT_BOOK_BY_BOOKID, bookId);

        // if does not return the query return empty
        if(!sqlRowSet.next())
            return Optional.empty();
        // else, return the the bookmodel data
        return Optional.of(BookModel.create(sqlRowSet));



    }


    
}
