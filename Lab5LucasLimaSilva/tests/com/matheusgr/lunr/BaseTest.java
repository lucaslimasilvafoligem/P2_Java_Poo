package com.matheusgr.lunr;

import org.junit.jupiter.api.BeforeEach;

import com.matheusgr.apresentacao.ApresentacaoController;
import com.matheusgr.lunr.busca.BuscaController;
import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.similaridade.SimilaridadeController;

class BaseTest {

	public static final String TEXTO1_ID = "789";
	public static final String TEXTO2_ID = "ABC";
	public static final String TEXTO3_ID = "VIC";
	public static final String TEXTO4_ID = "CBA";
	public static final String TEXTO5_ID = "BAC";
	public static final String JAVA_ID = "456";
	public static final String HTML_ID = "123";
	
	protected DocumentoController documentoController;
	protected BuscaController buscaController;
	protected SimilaridadeController similaridadeController;
	protected ApresentacaoController apresentacaoController;

	@BeforeEach
	void setUp() throws Exception {
		LunrApp lunrApp = new LunrApp();
		this.documentoController = lunrApp.getDocumentoController();
		this.buscaController = lunrApp.getBuscaController();
		this.similaridadeController = lunrApp.getSimilaridadeController();
		this.apresentacaoController = lunrApp.getApresentacaoController();
		var exemplo = new DocumentoExemplos();
		this.documentoController.adicionaDocumentoHtml(HTML_ID, exemplo.sampleHTML());
		this.documentoController.adicionaDocumentoJava(JAVA_ID, exemplo.sampleJava());
		this.documentoController.adicionaDocumentoTxt(TEXTO1_ID, "um arquivo! texto simples.\r\nuse DUAS linhas apenas.");
		this.documentoController.adicionaDocumentoTxt(TEXTO2_ID, "um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r\nMAIS AVANÇO!");
		this.documentoController.adicionaDocumentoTxt(TEXTO3_ID, "E por falar em beleza\nOnde anda a canção?\nQue se ouvia na noite\nDos bares de então\nOnde a gente ficava\nOnde a gente se amava\nEm total solidão\nHoje eu saio na noite vazia\nNuma boemia\nSem razão de ser\nDa rotina dos bares\nQue apesar dos pesares\nMe trazem você");
		this.documentoController.adicionaDocumentoTxt(TEXTO4_ID, "um arquivo! texto simples.");
		this.documentoController.adicionaDocumentoTxt(TEXTO5_ID, "aaa");
	}
	
}
