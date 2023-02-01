package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Repositório de documentos. O repositório pode ter opreações simples de busca,
 * mas a lógica de ranking, limitação e ordenação deve ficar em outra entidade.
 * 
 * O ID de um documento é único.
 */
class DocumentoRepository {

	private HashSet<Documento> documentos;
	private ValidadorDocumentos validador;

	/**
	 * Construção padrão do repositório de documentos.
	 */
	DocumentoRepository() {
		this.documentos = new HashSet<>();
		this.validador = new ValidadorDocumentos();
	}

	/**
	 * Adiciona o documento. O documento é validado para garantir a consistência do
	 * documento (sem termos e id vazios).
	 * 
	 * @param d Documento a ser adicionado.
	 */
	void adiciona(Documento d) {
		this.validador.validacao(d.getId(), d.getTexto());
		this.documentos.add(d);
	}

	/**
	 * Recupera um documento do repositório.
	 * 
	 * @param id ID do documento.
	 * @return Documento, caso exista.
	 */
	Optional<Documento> recupera(String id) {
		Documento doc = null;
		this.validador.validacao(id);
		
		for (Documento d : this.documentos) {
		      if (id.equals(d.getId())) {
		    	  doc = d;
		      }
		}
		
		return Optional.ofNullable(doc);
	}

	/**
	 * Retorna o total de documentos cadastrados.
	 * 
	 * @return O total de documentos cadastrados.
	 */
	int totalDocumentos() {
		return this.documentos.size();
	}

	/**
	 * Realiza uma busca pelos termos.
	 * 
	 * @param termo Termo a ser buscado.
	 * @return Conjunto de documentos com o termo.
	 */
	public Set<Documento> busca(String termo) {
		return this.documentos.stream()
					.filter((x) -> Arrays.binarySearch(x.getTexto(), termo) > 0)
					.collect(Collectors.toSet());
	}
	
	/**
	 * 0000000 tentar quebrar o metódo, comparar entrada e saida.
	 * @param metadados
	 * @return
	 */
	public Set<Documento> busca(Map<String, String> metadados) {
		Set<Documento> resultado = new HashSet<Documento>();
		for (Documento documento : this.documentos) {
			if(ehIgual(documento.getMetadados(), metadados)) {
				resultado.add(documento);
			}
		}
		return resultado;
	}
	
	/**
	 * 
	 * @param map1
	 * @param map2
	 * @return
	 */
	private boolean ehIgual(Map<String, String> map1, Map<String, String> map2) {
		for (String metadado : map2.values()) {
			if(!map1.values().contains(metadado)) {
				return false;
			}
		}
		return true;
	}

}
