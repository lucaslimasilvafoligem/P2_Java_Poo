package com.matheusgr.apresentacao;

import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Componente para tratamento da lógica de negócio relativa 
 * a apresentação de documentos.
 */
public class ApresentacaoService {

	private DocumentoService documentoService;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         ApresentacaoService.
	 */
	public ApresentacaoService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	/**
	 * Possiveis tipos de apresentação:
	 * Imprimir as primeiras n linhas;
	 * Imprimir as últimas n linhas;
	 * Imprimir o conteúdo todo em caixa alta. 
	 * 
	 * Realiza a apresentação do documento indicado.
	 * Primeiro, verifica-se o documento e o tipo de apresentação são válidos.
	 * Após a verificação, pega o texto do documento e inicia o atributo local: "linhasFinais",
	 * esse atributo serve para idenfificar quantas linhas devem ser imprimidas considerando o final do texto como inicio e fim.
	 * Também há um atributo "tudoMaisculo" que começa com um inteiro postivo. 
	 * Em seguida é chamado um método que identifica o tipo de apresentação, esse método retorna um inteiro que serve para a identificação do tipo de apresentação.
	 * Há duas verificações antes do for, a primeira serve para identificar se o tipo de apresentação será as ultimas n linhas; caso sim,
	 * ele altera o valor de linhas finais para auxiliar no tratamento adequado e muda o valor de tipoRepresentacao para a quantidade de linhas no texto;
	 * Dessa forma, caso sejam as últimas n linhas o for começará do ponto certo.
	 * A segunda identifica se o valo de "tipoRepresentacao" é igual a 0, caso seja, ele altera o valor de "tipoRepresentacao" para a mesma quantidade de linhas do texto,
	 * porquê siginifica que todo o texto deve ser convertido para Maiúsculo e "tudoMaisculo" tem o seu valor zerado.
	 * entrando no for, o atributo usado para a contagem terá o valor de "linhasFinais", caso esse atributo seja diferente de 0,
	 * significa que deve ser imprimidas as últimas n linhas, caso seja igual a 0, talvez signifique que devem ser impressas as primeiras n linhas.
	 * Após o tratamento do texto dentro do for, se faz uma ultima verificação, caso o valor de "tudoMaisculo" seja igual a 0, todo o texto é convertido para maiúsculo e retornado,
	 * caso seja diferente de 0, siginifica que devem ser impressas as n primeiras linhas e por fim o texto é retornado.
	 *  
	 * @param docId1 Documento a ser apresentado.
	 * @param tipoApresentacao modo de apresentacao a ser aplicado sobre o documento.
	 */
	public String apresenta(String docId, String tipoApresentacao) {
		if (this.documentoService.recuperaDocumento(docId).isEmpty() || tipoApresentacao.isEmpty()) {
			return "";
		}
		String[] texto = this.documentoService.recuperaDocumento(docId).get().getOriginal().split("\n");
		String apresentacao = "";
		int linhasFinais = 0;
		int tudoMaisculo = 1;
		int tipoRepresentacao = metodoDeApresentacao(tipoApresentacao);
		if (tipoRepresentacao < 0) {
			linhasFinais = texto.length + tipoRepresentacao;
			tipoRepresentacao = texto.length;
		}
		if (tipoRepresentacao == 0) {
			tipoRepresentacao = texto.length;
			tudoMaisculo = 0;
		}
		for (int w = linhasFinais; w < tipoRepresentacao; w++) {
			apresentacao += texto[w];
			
			if(w != tipoRepresentacao -1) {
				apresentacao += "\n";
			}
		}
		if(tudoMaisculo == 0) {
			return apresentacao.toUpperCase();
		}
		return apresentacao;
	}

	/**
	 * Indentifica o tipo de apresentação.
	 * Inteiro negativo significa ultimas n linhas,
	 * Inteiro positivo significa primeiras n linhas,
	 * 0 significa tudo maiúsculo.
	 * 
	 * @param tipoApresentacao a ser indentificada
	 * @return tipo de apresentação
	 */
	private int metodoDeApresentacao(String tipoApresentacao) {
		String[] apresentacaoTipo = tipoApresentacao.split(" ");
		for (int i = 0; i < apresentacaoTipo.length; i++) {
			
			if(apresentacaoTipo[i].toUpperCase().equals("PRIMEIRAS")) {
				return Integer.parseInt(apresentacaoTipo[i + 1]);
			}
			if(apresentacaoTipo[i].toUpperCase().equals("ULTIMAS")) {
				return Integer.parseInt(apresentacaoTipo[i + 1]) * -1;
			}
			if(apresentacaoTipo[i].toUpperCase().equals("ALTA")) {
				return 0;
			}
		}
		return 0;
	}
}
