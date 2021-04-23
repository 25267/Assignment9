package kz.example.controller;

import kz.example.entity.Book;
import kz.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/status")
    public List<Book> getBooksByStatus(@RequestParam boolean status){
        return bookRepository.findBooksByStatus(status);
    }

    @GetMapping("")
    public List<Book> getAllBooks(){
        return  bookRepository.findAll();
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book){
        return bookRepository.saveAndFlush(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {

        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book){
        book.setId(id);
        return  bookRepository.saveAndFlush(book);
    }

    @PatchMapping("/update/id")
    public Book updateBookStatus(@PathVariable Long id,
                                 @RequestParam boolean status){
        Book book = bookRepository.findById(id).get();
        book.setIs_issued(status);
        return bookRepository.saveAndFlush(book);

    }

}
