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
    public int countBooks(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM book";
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }
}
