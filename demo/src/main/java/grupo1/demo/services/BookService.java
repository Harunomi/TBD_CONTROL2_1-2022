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

@RestController
public class BookService {
    
    private final BookRepository bookRepository;
    BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/count")
    public String countBooks(){
        int total = bookRepository.countBooks();
        return String.format("Tienes %s Libros!", total);
    }
}
