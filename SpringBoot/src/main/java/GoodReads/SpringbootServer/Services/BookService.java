package GoodReads.SpringbootServer.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GoodReads.SpringbootServer.Models.BookModel;
import GoodReads.SpringbootServer.Repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> getBooks(){
        return bookRepository.getBooks();
        
    }

    public Optional<BookModel> getBookById(String bookId){
        return bookRepository.getBook(bookId);
    }
    
}
