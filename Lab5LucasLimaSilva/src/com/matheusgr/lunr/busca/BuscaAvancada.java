package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

public class BuscaAvancada {

	private Map<String, String> metadados;

	/**
	 * Construtor guarda osmetadados passados na busca.
	 * 
	 * @param metadados. Metadados passados para a busca.
	 */
	public BuscaAvancada(Map<String, String> metadados) {
		this.metadados = metadados;
	}

	/**
	 * Inicia um atributo do tipo Map<Documento, Integer> que é usado para retornar o resultado da busca.
	 * O for pega os metadados e busca, em seguida atribui a variavél d,
	 * por fim insere o resultado dentro do atributo "respostaDocumento"
	 * 
	 * @param ds documento de onde se extraí os dados necessarios
	 * @return Retorna o resultado das buscas usando metadados
	 */
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for (Documento d : ds.busca(this.metadados)) {
			respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
		}
		return respostaDocumento;
	}

	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada linha representa um parâmetro de busca e as colunas representam um detelhamento de cada parâmetro.
	 */
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.metadados.size()][];
		int i = 0;
		for (String meta : this.metadados.values()) {
		resultado[i] = new String[] {"Metadados " + (i + 1), meta};
		}
		return resultado;
		}

}
