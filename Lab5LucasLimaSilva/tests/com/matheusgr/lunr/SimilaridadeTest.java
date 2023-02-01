package com.matheusgr.lunr;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimilaridadeTest extends BaseTest {
	
	@Test
	/**
	 * Testa a semelhança entre dois textos diferentes, mas com semelhanças entre si.
	 */
	void similaridade1() {
		double similaridade = similaridadeController.similaridade(TEXTO1_ID, TEXTO2_ID);
		assertEquals(0.5,similaridade, 0.01);
	}
	
	@Test
	/**
	 * Testa a semelhança de dpos textos extamente iguais, mostrando que são identicos.
	 */
	void similaridade2() {
		double similaridade = similaridadeController.similaridade(TEXTO1_ID, TEXTO1_ID);
		assertEquals(1.0,similaridade, 0.01);
	}
	
	@Test
	/**
	 * Testa a semelhança entre dois textos diferentes, mas com semelhanças entre si.
	 */
	void similaridade3() {
		double similaridade = similaridadeController.similaridade(TEXTO2_ID,TEXTO4_ID);
		assertEquals(0.4,similaridade, 0.01);
	}
	
	@Test
	/**
	 * Testa a semelhança entre dois textos totalmente diferentes.
	 */
	void similaridade4() {
		double similaridade = similaridadeController.similaridade(TEXTO2_ID,TEXTO5_ID);
		assertEquals(0.0,similaridade, 0.01);
	}

}
