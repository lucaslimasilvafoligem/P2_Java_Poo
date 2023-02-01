package LAB2_LucasdelimadaSilva;

/**
 * A Classe Disciplina deve cadastrar as horas que um aluno estudou, somá-las, 
 * cadastar as notas de um aluno e os valores de cada uma delas, por fim deve calcular a média do aluno.
 * 
 * @author lucas de Lima da Silva
 */
public class Disciplina {
    /**
     * Nome da disciplina; horas de estudo; notas em inteiro,exemplo: "1, 2, 3, 4"; 
     * valor das notas em double, exemplo: "5.0, 4.0, 7.0, 10.0"; média em double, lista das notas, exemplo: "[5.0, 6.0, 7.0, 10.0]".
     */
    private String nomeDisciplina;
    private int horasEstudo;
    private int[] notas = new int[4];
    private double[] notasAluno = new double[4];
    private double media;
    private String listaNotas;

    /**
     * Constrói a disciplina com mŕdia inicial e horas de estudo com valor de 0, 
     * atribuindo o parâmetro ao nome das disciplina, 
     * por fim cria a quantidade de notas de acordo com o tamanho do array.
     * 
     * @param nomeDisciplina nome da disciplina no formato String.
     */
    public Disciplina(String nomeDisciplina) {
        this.media = 0;
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        for(int k = 0; k < notas.length; k++) { // Coloca a quantidade de notas no array de notas
            this.notas[k] = k + 1;
        }
    }

    /**
     * Acumula as horas que o aluno gastou estudando.
     * 
     * @param horas horas empenhadas estudando, está no formato horas.
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    /**
     * Cadastra as notas do aluno na disciplina e verifica se é necessário substituir alguma nota. 
     * 
     * @param nota nota a qual o doscente se refere, exemplo: "1, 2, 3, 4"
     * @param valornotas valor da nota; exemplo: "1: 7.0, 2: 7.0, 3; 8.0, 4: 10.0".
     */
    public void cadastraNota(int nota, double valornotas) {
        for(int i = 0; i < notas.length; i++) { 
            if(this.notas[i] == nota) {
                this.notasAluno[i] = valornotas;
            } 
        }
    }

    /**
     * Faz a soma dos valores de todas as notas do aluno e depois devide pela quantidade de notas.
     * 
     * @return media da soma de todas as notas.
     */
    private double calculaMedia() {
        double somaNotas = 0;
        this.media = 0;
        for(int j = 0; j < notas.length; j++) {
            somaNotas += this.notasAluno[j];
        }
        this.media = somaNotas / this.notas.length;
        return this.media;   
    }

    /**
     * Invoca o método calculaMedia() e verifica se a média é maior ou igual a 7.
     * 
     * @return boolean. 
     */
    public boolean aprovado() {
        return calculaMedia() >= 7;
    }

    /**
     * Organiza a saída de acordo com a formatação pedida, exemplo: "PROGRAMACAO 2 4 7.0 [5.0, 6.0, 7.0, 10.0]",
     * sendo a ordem: nome da disciplina, quantidade de horas estudadas, média, lista de notas.
     * 
     * @return dados do aluno na disciplina.
     */
    public String toString() {
        this.listaNotas = "[";
        calculaMedia();
        for(int x = 0; x < this.notas.length; x++) { 
            this.listaNotas += this.notasAluno[x];
            if(x + 1 < this.notas.length) {
                this.listaNotas += ",";
                this.listaNotas += " ";
            } else {
                this.listaNotas += "]";
            }
        }
        return this.nomeDisciplina + " " + this.horasEstudo + " " + this.media + " " + this.listaNotas;
    }
}
