
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;

class ContatoTest {
	private Contato contatoTeste;
	
	
	@Test
	void testEquals() {
		contatoTeste = new Contato("Matheus", "Gaudencio", "90028922");
		Contato contato1 = new Contato("Matheus", "Gaudencio", "90028922"); 
		assertEquals(this.contatoTeste.equals(contato1), true, "deu erro");
	}
	
	
}
	
	
	
	/**@Test
	void testAdicionaTags() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsContato() {
		fail("Not yet implemented");
	}

}*/
