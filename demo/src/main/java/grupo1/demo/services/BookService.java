package grupo1.demo.services;

import org.springframework.web.bind.annotation.RestController;

import grupo1.demo.models.Book;
import grupo1.demo.repositories.BookRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class BookService {

    private final BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/count")
    public String countBooks() {
        int total = bookRepository.countBooks();
        return String.format("Tienes %s Libros!", total);
    }

    // Create
    @PostMapping("/books")
    @ResponseBody
    public String createBook(@RequestBody Book book) {
        return bookRepository.createBook(book);
    }

    // Read all
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    // Update
    @PutMapping("/books/update/{id}")
    @ResponseBody
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookRepository.updateBook(id, book);
    }

    // Delete
    @DeleteMapping("/books/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable int id) {
        return bookRepository.deleteBook(id);
    }
}
