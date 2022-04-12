package grupo1.demo.repositories;

import grupo1.demo.models.Book;

public interface BookRepository {
    public int countBooks();

    public String createBook(Book book);

    public List<Book> getAllBooks();

    public String updateBook(Long id, Book book);

    public boolean deleteBook(Long id);
}
