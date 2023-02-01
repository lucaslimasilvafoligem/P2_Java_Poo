package agenda;

/**
 * Mantém os dados do contato, suas tags, nome, sobrenome e número.
 * 
 * @author Lucas de Lima da Silva.
 *
 */
public class Contato {
	/**
	 * Atríbutos do contato e o objeto contato.
	 */
    private String contato;
    private String nome; 
    private String sobrenome;
    private String telefone;
    private String nomeSobrenome;
    private String[] tagsArray;

    /**
     * O construtor cria o contato e atribuí o nome, sobrenome, telefone, inicia o array de tags
     * e formata onomeSobrenome.
     * @param nome Nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefone Telefone do contato.
     */
    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.contato = nome + " " + sobrenome + "\n" + telefone;
        this.nomeSobrenome = nome + " " + sobrenome;
        this.tagsArray = new String[5];
    }

    /**
     * Adiciona a tag ao array de tags do contato na posição desejada.
     * @param tag Uma string com a tag
     * @param posicaoTag
     */
    public void adicionaTags(String tag, int posicaoTag) {
        this.tagsArray[posicaoTag - 1] = tag;
    }

    /**
     * Retorna a representação do objeto contato.
     */
    public String toString() {
        return this.contato;
    }

    /**
     * Verifica se dois contatos são iguais.
     * 
     * @override Compara nome e sobrenome do contato separadamente.
     * @param Contato Contato a ser comparado
     * @return Retorna um valor booleano.
     */
    public boolean equals(Contato contato) {
        if(this.nome.equals(contato.getNome()) && this.sobrenome.equals(contato.getSobrenome())) {
            return true;
        }
        return false;
    }

    public String getTelefone() {
        return this.telefone;
    }

    private String getNome() {
        return this.nome;
    }

    private String getSobrenome() {
        return this.sobrenome;
    }

    /**
     * Retorna uma string formatada apenas com o nome e sobrenome.
     * @return
     */
    public String getNomeSobrenome() {
        return this.nomeSobrenome;
    }

    /**
     * Formata uma string com as tags do contato.
     * @return Retorna uma String com as tags do contato.
     */
    public String getTags() {
        String tags = "";
        for(int i = 0; i < this.tagsArray.length; i++) {
            if(this.tagsArray[i] != null) {
                tags += this.tagsArray[i];
                tags += " ";
            }
            if(this.tagsArray.length - 1 == i && !tags.equals("")) {
                tags += "\n";
            }
        }
        tags.trim();
        return tags;
    }
}