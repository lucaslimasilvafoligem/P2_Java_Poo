package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos.
 * Também possuí o array de contatos favoritos;
 * 
 * @author nazareno e @author Lucas de Lima da Silva.
 *
 */
public class Agenda {
	/**
	 * Um array de contatos, o contato a ser criado,
	 * Um array de contatos favoritados e
	 * um atributo "removeFavorito" que auxilia na remoção de contato do array de favoritos.
	 */
	private static final int TAMANHO_AGENDA = 100;
	private Contato[] contatos;
	private Contato contato;
	private Contato[] contatosFavoritos;
	private int removeFavorito;

	/**
	 * O construtor Agenda padroniza o tamanho do array de contatos e do array de favoritos.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.contatosFavoritos = new Contato[10];
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return this.contatos[posicao - 1];
	}

	/**
	 * Cria e cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * Em caso de sobrescrita remove o contato da lista de favoritos. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		this.contato = new Contato(nome, sobrenome, telefone);
		this.contatos[posicao - 1] = this.contato;
		if(verificaFavorito(posicao)) {
			this.contatosFavoritos[removeFavorito] = null;
		}
	}

	/**
	 * Verifica se o contato na posição passada como parâmetro também está no array de contatos favoritos.
	 * @param posicaoContato Posição do contato.
	 * @return Retorna um valor booleano.
	 */
    public boolean verificaFavorito(int posicaoContato) {
		for(int w = 0; w < this.contatosFavoritos.length; w++) {
			if(this.contatosFavoritos[w] != null) {
				if(this.contatos[posicaoContato - 1].equals(this.contatosFavoritos[w])) {
					this.removeFavorito = w;
					return true;
				} 
			} 
		}
        return false;
    }

	/**
	 * Verifica se o contato já existe;
	 * para isso, se cria um contato, mas sem o adicionar no array de contatos,
	 * e se verifica se existe um contato com o mesmo nome e sobrenome.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @return Retorna um valor booleano.
	 */
	public boolean verificaContato(String nome, String sobrenome, String telefone) {
		Contato idealizacaoContato = new Contato(nome, sobrenome, telefone);
		for(int i = 0; i < contatos.length; i++) {
			if(this.contatos[i] != null) {
				if(idealizacaoContato.equals(this.contatos[i])) {
					return true;
				} 
			} 
		}
        return false;
    }

		/**
		 * Adiciona um contato do array de contatos ao array de contatos favoritos.
		 * @param contatoPosicao Posição do contato do array de contatos.
		 * @param posicaoFavoritos Posição do contato favorito do array de contatos favoritos.
		 */
	public void adicionaFavorito(int contatoPosicao, int posicaoFavoritos) {
		this.contatosFavoritos[posicaoFavoritos - 1] = this.contatos[contatoPosicao - 1];
	}

	/**
	 * Adiciona ou subistiui uma tag a um ou mais contatos; para isso,
	 * indentifica-se os contatos que devem ter a tag adicionada ou subistituída
	 * também verifica se o contato não está em uma posição nula,
	 * por fim, chama o método "adicionaTags" que dentro da classe contato atribuí ou subistitui uma tag a um contato.
	 * @param contatos Uma string com as posições dos contatos.
	 * @param tag Tag que devem ser atribuida a um ou mais contatos.
	 * @param posicaoTag Posição que a tag deve ser inserida no array de tags do contato.
	 */
	public void adicionaTags(String contatos, String tag, int posicaoTag) {
		String[] quantidadeContatos = contatos.split(" ");
		for(int z = 0; z < quantidadeContatos.length; z++) {
			if(this.contatos[Integer.parseInt(quantidadeContatos[z]) - 1] != null) {
				this.contatos[Integer.parseInt(quantidadeContatos[z]) - 1].adicionaTags(tag, posicaoTag);
			}
		}
	}

	/**
	 * Remove um ou mais contatos.
	 * Recebe um array com as posições dos contatos a serem apagados,
	 * verifica se há um contato correspondente no array de contatos favoritos usando o metódo "verificaFavorito",
	 * pega o "removeFavoritos" (dado passado pelo metódo de verificação) e, caso haja um correspondente,
	 * remove o contato do array de favoritos; por fim remove o contato do array de contatos.
	 * @param contatosAExcluir posições dos contatos.
	 */
	public void removeContato(String[] contatosAExcluir) {
		for(int p = 0; p < contatosAExcluir.length; p++) {
			if(verificaFavorito(Integer.parseInt(contatosAExcluir[p]))) {
				this.contatosFavoritos[this.removeFavorito] = null;
			} 
			this.contatos[Integer.parseInt(contatosAExcluir[p]) - 1] = null;
		}
	}

	/**
	 * Verifica se algum dos contatos nas posições passadas como parametro é nulo.
	 * @param contatosAExcluir
	 * @return Retorna um valor booleano.
	 */
	public boolean verificaNull(String[] contatosAExcluir) {
		for(int r = 0; r < contatosAExcluir.length; r++) {
				if(this.contatos[Integer.parseInt(contatosAExcluir[r]) - 1] == null) {
					return true;
				} 
			}
		return false;
	}

	/**
	 * Lista os contatos do array de contatos; retornando uma string com os contatos.
	 * Posições vazias não devem ser exibidas.
	 * @return Retorna uma string.
	 */
	public String listaContatos() {
		String listaContatosFormatada = "";
		for (int s = 0; s < this.contatos.length; s++) {
			if (this.contatos[s] != null) {
				listaContatosFormatada += formataContato(s, this.contatos[s]);
			}
		}
		return listaContatosFormatada;
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return (posicao + 1) + " - " + contato.getNomeSobrenome() + "\n";
	}

	/**
	 * Lista os contatos favoritos do array de contatos favoritos; retornando uma string com os contatos favoritos.
	 * Posições vazias não devem ser exibidas.
	 * @return Retorna uma string.
	 */
	public String listaFavoritos() {
		String listaContatosFavoritos = "";
		for (int x = 0; x < this.contatosFavoritos.length; x++) {
			if (this.contatosFavoritos[x] != null) {
				listaContatosFavoritos += formataContato(x, this.contatosFavoritos[x]);
			}
		}
		return listaContatosFavoritos;
	}

}