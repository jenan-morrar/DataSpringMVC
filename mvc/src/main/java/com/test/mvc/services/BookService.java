package com.test.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.test.mvc.models.Book;
import com.test.mvc.repositories.BookRepository;

@Service
public  class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // edit a book 
    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
    	Book book = findBook(id);
    	book.setId(id);
    	book.setTitle(title);
    	book.setDescription(desc);
    	book.setLanguage(lang);
    	book.setNumberOfPages(numOfPages);
    	return bookRepository.save(book);
    }
    
    // delete a book 
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}