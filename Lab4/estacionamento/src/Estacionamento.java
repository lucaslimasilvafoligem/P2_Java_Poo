package src;

/**
 * Class que representa o estacionamento EstacionAqui.
 * 
 * @author Hernandes Matheus da Silva
 *
 */
public class Estacionamento {
    public static final int QUANTIDADE_VAGAS = 100;
    public static final int QUANTIDADE_COMENTARIOS = 5;
    private Vaga vagas[];
    private int idVagaLivre;
    private Comentario[] comentarios;
    private int zeradorComentarios;

    public Estacionamento() {
        this.vagas = new Vaga[QUANTIDADE_VAGAS];
        this.idVagaLivre = 0;
        this.zeradorComentarios = 0;
        this.comentarios = new Comentario[QUANTIDADE_COMENTARIOS];
    }

    public int adicionarVaga(String endereco, Double area) {
        return adicionarVaga(endereco, "", area);
    }

    public int adicionarVaga(String endereco, String link, Double area) {
        if (idVagaLivre >= QUANTIDADE_VAGAS)
            return -1;
        Vaga vaga = new Vaga(endereco, "", area);
        vagas[idVagaLivre] = vaga;
        idVagaLivre++;
        return idVagaLivre - 1;
    }

    private boolean isIdValid(int id) {
        if (id >= 0 && id < QUANTIDADE_VAGAS && vagas[id] != null)
            return true;
        return false;
    }

    public void mudarStatusDaVaga(int id) {
        if (!isIdValid(id))
            throw new IllegalArgumentException();
        vagas[id].mudarStatus();
    }

    public double simularPrecoDaVaga(int id, int horasGasta) {
        if (!isIdValid(id))
            throw new IllegalArgumentException();
        if (horasGasta < 0)
            throw new IllegalArgumentException();

        return vagas[id].simularPreco(horasGasta);
    }

    public int listarVagasAtivas() {
        return idVagaLivre;
    }

    public int vagaLivre() {
        return idVagaLivre < QUANTIDADE_VAGAS ? idVagaLivre : -1;
    }

    public int vagaLivreEnderecoArea(String endereco, Double area) {
        Vaga vaga = new Vaga(endereco, area);
        int idVagaBuscada = -1;
        for (int i = 0; i < idVagaLivre; i++) {
            if (vagas[i].equals(vaga) && vaga.getLivre())
                return i;
        }
        return idVagaBuscada;
    }

    public String relatorioDeUsoDasVagas() {
        String retorno = "";

        for (int i = 0; i < idVagaLivre; i++) {
            retorno += "VAGA " + i + " - " + vagas[i].getQuantidadeDeVezesOcupada() + "\n";
        }

        return retorno;
    }

    public String listarVagas() {
        String retorno = "";

        for (int i = 0; i < idVagaLivre; i++) {
            retorno += i + " - " + vagas[i].toString() + "\n";
        }

        return retorno;
    }

    public void adicionarComentario(String descricao) {
        adicionarComentario(descricao, "");

    }

    public void adicionarComentario(String descricao, String author) {
        Comentario comentario = new Comentario(descricao, author);

        comentarios[zeradorComentarios] = comentario;
        zeradorComentarios++;

        if (zeradorComentarios >= 5)
            zeradorComentarios = 0;

    }

    public String listarComentarios(){
        String retorno = "";
        for (int i = 0; i < 5; i++) {
            if(comentarios[i] == null) continue;
            retorno += comentarios[i].toString();
        }
        return retorno;
    }



}
