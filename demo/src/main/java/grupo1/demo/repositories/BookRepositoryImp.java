package grupo1.demo.repositories;

import grupo1.demo.models.Book;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository

public class BookRepositoryImp implements BookRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countBooks() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM book";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createBook(Book book) {

        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO book(id, titulo, autor, editorial, paginas, precio, volumen, softDelete)" +
                    "VALUES(:id, :titulo, :autor, :editorial, :paginas, :precio, :volumen, :softDelete)";
            int idBook = countBooks() + 1;

            conn.createQuery(sql)
                    .addParameter("id", idBook)
                    .addParameter("titulo", book.getTitulo())
                    .addParameter("autor", book.getAutor())
                    .addParameter("editorial", book.getEditorial())
                    .addParameter("paginas", book.getPaginas())
                    .addParameter("precio", book.getPrecio())
                    .addParameter("volumen", book.getVolumen())
                    .addParameter("softDelete", book.softDelete())
                    .executeUpdate();

            book.setId(idBook);

            return "Se ha creado el libro con id: " + idBook;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM Book";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Book.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateBook(Long id, Book book) {
        String sql = "UPDATE Book" +
                "SET titulo = :bookTitulo, " +
                "autor = :bookAutor, " +
                "editorial = :bookEditorial, " +
                "paginas = :bookPaginas, " +
                "precio = :bookPrecio, " +
                "volumen = :bookVolumen";

        try (Connection con = sql2o.open()) {
            Book bookAntiguo = conn.createQuery("SELECT * FROM Book where id = :bookId")
                    .addParameter("bookId", id)
                    .executeAndFetchFirst(Book.class);

            // Verificamos si existe el dato solicitado
            if (bookAntiguo == null) {
                return ("No existe el libro solicitado. ID: " + id);
            }

            // Se ejectua la actualizacion, llenando los parametros de la consulta segun
            // corresponda
            Query consulta = con.createQuery(sql);
            consulta.addParameter("emergenciaID", id);

            if (book.getTitulo() != null) {
                consulta.addParameter("bookTitulo", book.getTitulo());
            } else {
                consulta.addParameter("bookTitulo", bookAntiguo.getTitulo());
            }

            if (book.getAutor() != null) {
                consulta.addParameter("bookAutor", book.getAutor());
            } else {
                consulta.addParameter("bookAutor", bookAntiguo.getAutor());
            }

            if (book.getEditorial() != null) {
                consulta.addParameter("bookEditorial", book.getEditorial());
            } else {
                consulta.addParameter("bookEditorial", bookAntiguo.getEditorial());
            }

            if (book.getPaginas() != null) {
                consulta.addParameter("bookPaginas", book.getPaginas());
            } else {
                consulta.addParameter("bookPaginas", bookAntiguo.getPaginas());
            }

            if (book.getPrecio() != null) {
                consulta.addParameter("bookPrecio", book.getPrecio());
            } else {
                consulta.addParameter("bookPrecio", bookAntiguo.getPrecio());
            }

            if (book.getVolumen() != null) {
                consulta.addParameter("bookVolumen", book.getVolumen());
            } else {
                consulta.addParameter("bookVolumen", bookAntiguo.getVolumen());
            }

            consulta.executeUpdate();

            return ("Se actualizo el libro ID: " + id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteBook(Long id) {
        String sql = "UPDATE Book set softDelete = 1 where id = :id and softDelete = 0";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}