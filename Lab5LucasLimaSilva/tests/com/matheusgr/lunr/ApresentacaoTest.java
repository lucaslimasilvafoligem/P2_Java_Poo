package com.matheusgr.lunr;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ApresentacaoTest extends BaseTest{
	
	@Test
	/**
	 * Teste de conversão total do texto para maiúsculo.
	 */
	void testApresentaCaixaAlta1() {
		String texto = this.apresentacaoController.apresenta(TEXTO2_ID, "alta");
		assertEquals("um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r\nMAIS AVANÇO!".toUpperCase(), texto);
	}
	
	@Test
	/**
	 * Teste de conversão total do texto para maiúsculo.
	 */
	void testApresentaCaixaAlta2() {
		String texto = this.apresentacaoController.apresenta(TEXTO3_ID, "alta");
		assertEquals("E por falar em beleza\nOnde anda a canção?\nQue se ouvia na noite\nDos bares de então\nOnde a gente ficava\nOnde a gente se amava\nEm total solidão\nHoje eu saio na noite vazia\nNuma boemia\nSem razão de ser\nDa rotina dos bares\nQue apesar dos pesares\nMe trazem você".toUpperCase(), texto);
	}
	
	@Test
	/**
	 * Teste de n primeiras linhas.
	 */
	void testmetodoDeApresentaPrimeirasLinhas1() {
		String texto = this.apresentacaoController.apresenta(TEXTO2_ID, "primeiras 2");
		assertEquals("um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r", texto);
	}
	
	@Test
	/**
	 * Teste de n primeiras linhas.
	 */
	void testmetodoDeApresentaPrimeirasLinhas2() {
		String texto = this.apresentacaoController.apresenta(TEXTO3_ID, "primeiras 7");
		assertEquals("E por falar em beleza\nOnde anda a canção?\nQue se ouvia na noite\nDos bares de então\nOnde a gente ficava\nOnde a gente se amava\nEm total solidão", texto);
	}
	
	@Test
	/**
	 * Teste de n últimas linhas.
	 */
	void testmetodoDeApresentaUltimasLinhas1() {
		String texto = this.apresentacaoController.apresenta(TEXTO2_ID, "ultimas 2");
		assertEquals("use TRÊS linhas agora.\r\nMAIS AVANÇO!", texto);
	}
	
	@Test
	/**
	 * Teste de n últimas linhas.
	 */
	void testmetodoDeApresentaUltimasLinhas2() {
		String texto = this.apresentacaoController.apresenta(TEXTO3_ID, "ultimas 3");
		assertEquals("Da rotina dos bares\nQue apesar dos pesares\nMe trazem você", texto);
	}

}
