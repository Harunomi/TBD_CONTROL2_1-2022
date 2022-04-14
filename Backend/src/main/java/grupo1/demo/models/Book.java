package grupo1.demo.models;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.*;

@EntityScan
public class Book {
    private Integer id;
    private String titulo;
    private String autor;
    private String editorial;
    private Integer paginas;
    private Integer precio;
    private Integer volumen;
    private Integer softDelete;

    
    // 1 significa borrado xd
    /*
     * public Book() {
     * 
     * }
     * 
     * public Book(long id, String titulo, String autor, String editorial, Integer
     * paginas, Integer precio,
     * Integer volumen, Integer softDelete) {
     * this.id = id;
     * this.titulo = titulo;
     * this.autor = autor;
     * this.editorial = editorial;
     * this.paginas = paginas;
     * this.precio = precio;
     * this.volumen = volumen;
     * this.softDelete = softDelete;
     * }
     */

    // getters y setters de la wea de libro
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public Integer getSoftDelete() {
        return this.softDelete;
    }

    public void setSoftDelete(Integer softDelete) {
        this.softDelete = softDelete;
    }

}
