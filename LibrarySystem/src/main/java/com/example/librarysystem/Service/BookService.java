package com.example.librarysystem.Service;

import com.example.librarysystem.Api.ApiException;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Integer id, Book book) {
        Book oldBook = bookRepository.findBookById(id);
        if (oldBook == null) throw new ApiException("Book not exist");
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        bookRepository.save(oldBook);
    }

    public void deleteBook(Integer id) {
        Book oldBook = bookRepository.findBookById(id);
        if (oldBook == null) throw new ApiException("Book not exist");
        bookRepository.delete(oldBook);
    }

    public List<Book> getBooksByCategory(String category) {
        List<Book> books = bookRepository.findBooksByCategory(category);
        if (books.isEmpty()) throw new ApiException("no books");

        return books;
    }

    public List<Book> getBooksByPagesNumber() {
        List<Book> books = bookRepository.findBookByNumberOfPages();
        if (books.isEmpty()) throw new ApiException("no book");
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> books = bookRepository.findBookByAuthor(author);
        if (books.isEmpty()) throw new ApiException("no books");

        return books;
    }

    public Book getBookByTitle(String title) {
        Book book = bookRepository.findBookByTitle(title);
        if (book == null) throw new ApiException("this book not exist");

        return book;
    }

}
