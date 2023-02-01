package LAB2_LucasdelimadaSilva;

/**
 * Registra as atividades complementares do aluno e conta a quantidade de créditos acumuludados.
 * 
 * @author Lucas de Lima da Silva
 */
public class AtividadesComplementares {
    /**
     * Array das atividades do aluno de strings, string que armazena os projetos, string que armazena estágios,
     * horas gastas com os cursos, créditos dos estágios, créditos dos projetos, créditos dos cursos,
     * créditos totais, quantidade de projetos e quantidde de estágios.
     */
    private String[] atividadesRealizadas;
    private String listaEstagio;
    private String listaProjeto;
    private double horasCurso;
    private int creditosEstagio;
    private int creditosProjeto;
    private int creditosCurso;
    private int creditosTotais;
    private int estagios;
    private int projetos;

    /**
     * Constrói o registro de atividades do aluno, começa com todos os atributos vazios ou zerados.
     */
    public AtividadesComplementares() {
        this.estagios = 0;
        this.projetos = 0;
        this.listaEstagio = "";
        this.listaProjeto = "";
    }
    
    /**
     * Recebe as horas gastas com estágio, adiciona 1 estágio, conta os créditos e adiciona o estágio ao atributo listaEstagio junto com o tempo gasto.
     * Adiciona até 9 estágios.
     * 
     * @param horas quantidade de tempo em horas gastas com o estágio.
     */
    public void adicionarEstagio(int horas) {
        if(this.estagios <= 9) {
            this.estagios += 1;
            this.creditosEstagio += 5 * (horas / 300);
            this.listaEstagio += "Estagio " + horas + "!";
        }
    }

    /**
     * Recebe os meses gastas com projetos, adiciona 1 projeto,
     * conta os créditos e adiciona o projeto ao atributo listaProjetos junto com o tempo gasto
     * Adiciona até 16 projetos.
     * 
     * @param meses recebe quantidadde de tempo em meses gastas com projetos.
     */
    public void adicionarProjeto(int meses) {
        if(projetos <= 16) { 
            this.projetos += 1;
            this.creditosProjeto += 2 * (meses / 3); 
            this.listaProjeto += "Projeto " + meses + "!";
        }
    }

    /**
     * Recebe as horas gastas comcursos, adciona o tempo gasto com esse curso ao atributo horasCursos e conta os créditos.
     * A quantidade de tempo de cursos que podem ser adicionados é ilimitada.
     * Os créditos de cursos são zerados toda vez que o método é invocado, isso é feito para evitar soma extra nos créditos.
     * 
     * @param horas recebe quantidade de tempo em horas gastas com cursos.
     */
    public void adicionarCurso(double horas) {
        this.creditosCurso = 0;
        this.horasCurso += horas;
        this.creditosCurso += this.horasCurso / 30;
    }
    
    /**
     * Define o tamanho do array atividadesRealizadas, 
     * para isso se soma a quantidade de projetos mais a quantidade estágios mais 4,
     * esse quatro representa o tempo gasto com cursos e os créditos de cada uma das atividades complementares.
     * Cria-se um array de estágios(arrayEstagio), o tamanho deste array será a quantidadde de elementos após o uso do split("!"),
     * com parametro de quebra igual a "!", no atributo listaEstagio.
     * Cria-se um array de projetos(arrayProjeto), o tamanho deste array será a quantidadde de elementos após o uso do split("!"),
     * com parametro de quebra igual a "!", no atributo listaProjeto.
     * O array atividadesRealizadas terá espaço para adicionar os 2 arrays mais os 4 fixos, porém deve-se seguir a ordem de prioridade,
     * que é: estagios, depois projetos, por fim os 4 últimos que são fixos.
     * 
     * @return um array com todos os estagios e o tempo de duração em horas, 
     * os projetos e o tempo de duração em meses, as horas gastas com cursos e por fim
     * os créditos dos estágios, projetos e cursos.
     */
    public String[] pegaAtividades() {
        this.atividadesRealizadas = new String[this.estagios + this.projetos + 4];
        String[] arrayEstagio = listaEstagio.split("!");
        String[] arrayProjeto = listaProjeto.split("!");
        for(int x = 0; x < this.atividadesRealizadas.length - this.projetos - 4; x++) { 
            this.atividadesRealizadas[x] = arrayEstagio[x];
        }

        for(int i = 0; i < this.atividadesRealizadas.length - this.estagios - 4; i++) {
            this.atividadesRealizadas[estagios + i] = arrayProjeto[i];
        }

        for(int w = 0; w < 5; w++) {
            if(w == 0) {
                atividadesRealizadas[estagios + projetos + w] = "Cursos " + this.horasCurso;
            }
            if(w == 1) {
                atividadesRealizadas[estagios + projetos + w] = "Creditos_Estagio " + this.creditosEstagio;
            }
            if(w == 2) {
                atividadesRealizadas[estagios + projetos + w] = "Creditos_Projeto " + this.creditosProjeto;
            }
            if(w == 3) {
                atividadesRealizadas[estagios + projetos + w] = "Creditos_Cursos " + this.creditosCurso;
            }

        }
        return atividadesRealizadas;
    }

    /**
     * Soma os créditos recebidos de todas as atividades.
     * 
     * @return a soma dos créditos.
     */
    public int contaCreditos() {
        this.creditosTotais = creditosCurso + creditosEstagio + creditosProjeto;
        return creditosTotais;
    }
}