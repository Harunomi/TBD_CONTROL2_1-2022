package grupo1.demo.repositories;

import grupo1.demo.models.Book;
import java.util.*;

public interface BookRepository {
    public int countBooks();

    public String createBook(Book book);

    public List<Book> getAllBooks();

    //public String updateBook(Integer id, Book book);

    //public boolean deleteBook(Integer id);
}
