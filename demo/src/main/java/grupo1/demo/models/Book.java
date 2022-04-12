package grupo1.demo.models;

public class Book {
    private Long id;
    private String titulo;
    private String autor;
    private String editorial;
    private Integer paginas;
    private Integer precio;
    private Integer volumen;
    private Integer softDelete;//1 significa borrado xd
    //getters y setters de la wea de libro
    public Long getId() {
        return id;
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
    
}
