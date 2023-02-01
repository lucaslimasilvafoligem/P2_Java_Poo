package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Estacionamento;

public class TestEstacionamento {
    private Estacionamento estacionamento;
    private final int menosUm = 1;
    
    @BeforeEach
    void criandoEstacionamento() {
        this.estacionamento = new Estacionamento();
    }

    @Test
    void testInformarIdVagaLivreTodasVagasLivres() {
        assertEquals(0, estacionamento.vagaLivre());
    }

    @Test
    void testInformarIdVagaLivreTodasVagasPreenchidas() {
        for (int i = 0; i < estacionamento.QUANTIDADE_VAGAS; i++) {
            estacionamento.adicionarVaga("" + i, (double) i);
        }

        assertEquals(-1, estacionamento.vagaLivre());
    }

    @Test
    void testInformarIdVagaLivreUmaVagaLivre() {
        for (int i = 0; i < estacionamento.QUANTIDADE_VAGAS - 1; i++) {
            estacionamento.adicionarVaga("" + i, (double) i);
        }

        assertEquals(estacionamento.QUANTIDADE_VAGAS-1, estacionamento.vagaLivre());
    }

    @Test
    void testVerificarVagaLivrePassandoParamentro() {
        String endereco = "Rua dr Joao Moura, Sao Jose";
        double area  = 13.75;
        estacionamento.adicionarVaga(endereco, area);
        assertEquals(0, estacionamento.vagaLivreEnderecoArea(endereco, area));
    }

    @Test
    void testVerificarVagaLivrePassandoParamentroInvalid() {
        String endereco = "Rua dr Joao Moura, Sao Jose";
        double area  = 13.75;
        estacionamento.adicionarVaga(endereco, area);
        assertEquals(-1, estacionamento.vagaLivreEnderecoArea("zezinho", area));
    }


    @Test
    void testAdicionarVaga() {
        assertEquals(0, estacionamento.adicionarVaga("" + 100, (double) 100));
    }

    @Test
    void testAdicionarVagaNaUltimaVaga() {

        for (int i = 0; i < estacionamento.QUANTIDADE_VAGAS-menosUm; i++) {
            estacionamento.adicionarVaga("" + i, (double) i);
        }

        assertEquals(estacionamento.QUANTIDADE_VAGAS-1, estacionamento.adicionarVaga("" + (estacionamento.QUANTIDADE_VAGAS-1), (double) 99));
    }

    @Test
    void testAdicionarVagaAlemDoLimite() {
        for (int i = 0; i < estacionamento.QUANTIDADE_VAGAS; i++) {
            estacionamento.adicionarVaga("" + i, (double) i);
        }
        assertEquals(-1, estacionamento.adicionarVaga("" + 100, (double) 100));
    }


    @Test
    void testSimularPrecoVaga() {
        estacionamento.adicionarVaga("rua joao", 13.75);
        assertEquals(10.37, estacionamento.simularPrecoDaVaga(0, 3), 0.1);
    }
    @Test

    void testSimularPrecoVagaNaoExiste() {
        estacionamento.adicionarVaga("rua joao", 13.75);
        assertThrows(IllegalArgumentException.class, () -> estacionamento.simularPrecoDaVaga(1, 3));
    }

    @Test
    void testSimularPrecoVagaAlemDoLimite() {
        assertThrows(IllegalArgumentException.class, () -> estacionamento.simularPrecoDaVaga(100, 5));
    }


    @Test
    void testListarVagasComDuasVagas(){
        estacionamento.adicionarVaga("rua joao", 13.75);
        estacionamento.adicionarVaga("rua jose", 13.75);
        estacionamento.listarVagas();
        assertEquals("0 - rua joao - https:// - LIVRE\n1 - rua jose - https:// - LIVRE\n", estacionamento.listarVagas());
    }

}
