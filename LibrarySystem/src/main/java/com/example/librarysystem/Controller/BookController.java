package com.example.librarysystem.Controller;

import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/get")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.OK).body("book added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @RequestBody @Valid Book book) {
        bookService.updateBook(id, book);
        return ResponseEntity.status(HttpStatus.OK).body("book updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("book deleted successfully");
    }

    @GetMapping("/getByCategory/{category}")
    public List<Book> getBooksByCategory(@PathVariable String category) {
        return bookService.getBooksByCategory(category);
    }

    @GetMapping("/getByPages")
    public List<Book> getBooksByPagesNumber() {
        return bookService.getBooksByPagesNumber();
    }

    @GetMapping("/getByAuthor/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/getByTitle/{title}")
    public ResponseEntity getBookByTitle(@PathVariable String title) {
        Book book = bookService.getBookByTitle(title);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }


}

