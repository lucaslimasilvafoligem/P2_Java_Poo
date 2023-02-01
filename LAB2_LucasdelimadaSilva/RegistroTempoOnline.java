package LAB2_LucasdelimadaSilva;

/**
 * A Classe RegistroTempoOnline deve verificar quanto tempo um aluno gasta com a disciplina remota e
 * se esse tempo é o esperado.
 * 
 * @author Lucas de Lima da Silva
 */
public class RegistroTempoOnline {
    /**
     * São 3 atributos, o primeiro é o nome da disciplina em formato string,
     * o segundo é o tempo gasto online em e o terceiro é o tempo esperado para cada disciplina. 
     */
    private String nomedisciplina;
    private int tempogastoOnline;
    private int tempoEsperado;
    
    /**
     * Constrói a disciplina a partir do nome, com o tempo esperado tendo o padrão de 120 horas e
     * o tempo gasto online em 0 horas.
     * 
     * @param nomeDisciplina está no formato String que representa o nome da disciplina.
     */
    public RegistroTempoOnline (String nomeDisciplina) { 
        this.nomedisciplina = nomeDisciplina;
        this.tempoEsperado = 120;
        this.tempogastoOnline = 0;
    }
    
    /**
     * Constrói a disciplina a partir do nome e do seu tempo esperado.
     * 
     * @param nomeDisciplina está no formato String que representa o nome da disciplina.
     * @param tempoOnlineEsperado está no formato horas, o tempo esperado para gastar com uma disciplina. 
     */
    public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomedisciplina = nomeDisciplina;
        this.tempoEsperado = tempoOnlineEsperado;
        this.tempogastoOnline = 0;   
    }

    /**
     * Adiciona o tempo passado como parâmetro no tempo gasto online.
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempogastoOnline += tempo;
    }

    /**
     * Faz a verificação se o tempo gasto pelo aluno é igual ou superior ao esperado e
     * retorna uma variavel booleana.
     * 
     * @return a verificação verdadeira ou falsa do tempo gasto pelo aluno em relação ao tempo esperado pela disciplina
     */
    public boolean atingiuMetaTempoOnline() {
        return this.tempogastoOnline >= this.tempoEsperado;
    }
    
    /**
     * @return Retorna uma serie de dados no formato nome da disciplina tempo gasto/tempo esperado,
     * Exemplo: "LP2 32/30".
     */
    public String toString() {
        return this.nomedisciplina + " " + this.tempogastoOnline + "/" + this.tempoEsperado;
    }
}