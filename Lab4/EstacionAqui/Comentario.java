public class Comentario {
    String texto;
    String autor;

    public Comentario(String texto) {
        this.texto = texto;
        this.autor = "";
    }

    public Comentario(String texto,String autor) {
        this.texto = texto;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return texto + " (" + autor + ")";
    }
    
}
