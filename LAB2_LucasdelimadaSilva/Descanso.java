package LAB2_LucasdelimadaSilva;

/**
 * A Classe Descanso define se um aluno está descansado ou cansado.
 * 
 * um aluno descansado é aquele que tem 26 horas ou mais de descanso por semana
 * a definição do tempo de descanso se deve pela divisão de horasDescanso por numerosSemana.
 * 
 * @author Lucas de Lima da Silva
 */
public class Descanso {
    /**
     * Começa com 2 atributos horasDescanso(tempo que o aluno descansou) e
     * numerosSemana(a quantidade de semanas em relação ao tempo de descanso).
     */
    private int horasDescanso;
    private int numerosSemana;

    /**
     * O construtor Descanso constrói cum aluno, por padrão, com 0 horas de descanso e
     * 1 semana no numeroSemana, o construtor, o constrói com valor diferente de 0 para evitar um erro de divisão;
     * iniciar o aluno com o valor de 1 não afeta em nada, pois se não tiver ao menos 26 horas, estará cansado,
     * além disso, o valor da horasDescanso e do numerosSemana sempre será redefinido quando os métodos forem invocados.
     * horasDescanso está no formato hora.
     * numerosSemana está no formato semana.
     */
    public Descanso() {
        this.horasDescanso = 0;
        this.numerosSemana = 1;
    }

    /**
     * Redefine a quantidade de horas de descanso.
     */
    void defineHorasDescanso(int horasDescanso) {
        this.horasDescanso = horasDescanso;
    }

    /**
     * Redefine a quantidade de numero de semanas.
     */
    public void defineNumeroSemanas(int numerosSemana) {
        this.numerosSemana = numerosSemana;
    }
    
    /**
     * Retorna a String que representa a quantidade de descanso de um aluno por semana.
     * O retorno é uma string que infotma se aluno está "cansado" ou "descansado".
     * Se horasDescanso dividido por numeroSemana for maior ou igual a 26 horas,
     * o retorno será descansado, caso seja falso o aluno está cansado.
     * 
     * @return a representação do vigor de um aluno.
     */
    public String getStatusGeral() {
        if((horasDescanso / numerosSemana) >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }
}