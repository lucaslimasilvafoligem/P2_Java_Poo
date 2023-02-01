package src;
/**
 * Class que representa um comentário para o estaciomento.
 * 
 * @author Hernandes Matheus da Silva
 *
 */
public class Comentario {
    private String author;
    private String descricao;
    public Comentario(String descricao){
        this(descricao, "");
    }
    public Comentario(String descricao, String author){
        this.descricao = author;
        this.author = author;
    }

    @Override
    public String toString() {
        return descricao+" ("+author+")";
    }

}
