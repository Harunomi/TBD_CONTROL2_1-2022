package grupo1.demo.repositories;


import grupo1.demo.models.Dog;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

//Implementación de Dog
@Repository
public class DogRepositoryImp implements DogRepository {
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countDogs(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM dog";
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }
}
