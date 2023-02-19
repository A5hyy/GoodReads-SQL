package GoodReads.SpringbootServer.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import GoodReads.SpringbootServer.Models.BookModel;
import GoodReads.SpringbootServer.Services.BookService;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

@Controller
@RequestMapping(path = "/api")
public class BookController {

    @Autowired
    private BookService bookService;


    // link with model jsonobject
    @GetMapping(path = "/books")
    public ResponseEntity<String> getBooks(){
        List<BookModel> books = bookService.getBooks();
        // create an arraybuilder
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        bookService.getBooks().stream().forEach(v -> {
            jsonArrayBuilder.add(v.toBookSummary());
        });
        return ResponseEntity.ok(jsonArrayBuilder.build().toString());
    }

    @GetMapping(path = "/book/{bookId}")
    public ResponseEntity<String> getBooksById( @PathVariable String bookId){
        Optional<BookModel> optional = bookService.getBookById(bookId);
        if (optional.isEmpty())
            return ResponseEntity.status(404)
                .body(Json.createObjectBuilder()
                .add("message", "Cannot find book id %s".formatted(bookId))
                .build()
                .toString()
            );
        return ResponseEntity.ok(optional.get().toBook().toString());
    }

    
}
