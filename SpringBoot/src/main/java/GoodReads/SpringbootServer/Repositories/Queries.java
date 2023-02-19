package GoodReads.SpringbootServer.Repositories;

public interface Queries {

    // the sql query to retrieve all bookdata from book2018
    public String SQL_SELECT_BOOKS = "select * from book2018 limit 20";

    // the sql query to retrieve all bookdata from book2018 by the book_ID
    public String SQL_SELECT_BOOK_BY_BOOKID = "select * from book2018 where book_id = ?";
    
}
