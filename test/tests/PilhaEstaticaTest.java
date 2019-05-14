package tests;

import pilha.estatica.entities.PilhaEstatica;
import pilha.estatica.exceptions.PilhaEstaticaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PilhaEstaticaTest {

    private final int TAMANHO_DA_PILHA;

    public PilhaEstaticaTest() {
        this.TAMANHO_DA_PILHA = 5;
    }

    PilhaEstatica pilhaEstatica;

    @Before
    public void inicializarTest() {
        pilhaEstatica = new PilhaEstatica(TAMANHO_DA_PILHA);
    }

    @Test
    public void testColocarUmValorNaPilha() throws PilhaEstaticaException {
        pilhaEstatica.push("a");
        Assert.assertEquals("a", pilhaEstatica.pop());
    }

    @Test
    public void testColocarDoisValoresNaPilha() throws PilhaEstaticaException {
        pilhaEstatica.push("a");
        pilhaEstatica.push("b");
        Assert.assertEquals("b", pilhaEstatica.pop());
        Assert.assertEquals("a", pilhaEstatica.pop());
    }

    @Test
    public void testColocarTresValoresNaPilha() throws PilhaEstaticaException {
        pilhaEstatica.push("a");
        pilhaEstatica.push("b");
        pilhaEstatica.push("c");
        Assert.assertEquals("c", pilhaEstatica.pop());
        Assert.assertEquals("b", pilhaEstatica.pop());
        Assert.assertEquals("a", pilhaEstatica.pop());
    }

    @Test(expected = PilhaEstaticaException.class)
    public void testColocarValorComPilhaCheia() throws PilhaEstaticaException {
        pilhaEstatica.push("a");
        pilhaEstatica.push("b");
        pilhaEstatica.push("c");
        pilhaEstatica.push("d");
        pilhaEstatica.push("e");
        pilhaEstatica.push("f");
    }

    @Test(expected = PilhaEstaticaException.class)
    public void testRemoverValorComPilhaVaiza() throws PilhaEstaticaException {
        pilhaEstatica.pop();
    }

    @Test
    public void testTamahoDaPilha() throws PilhaEstaticaException {
        Assert.assertEquals(0, pilhaEstatica.size());

        pilhaEstatica.push("a");
        pilhaEstatica.push("b");

        Assert.assertEquals(2, pilhaEstatica.size());

        pilhaEstatica.pop();

        Assert.assertEquals(1, pilhaEstatica.size());

    }

    @Test
    public void testObterDadoDoTopo() throws PilhaEstaticaException {
        Assert.assertNull(pilhaEstatica.peek());

        pilhaEstatica.push("a");
        pilhaEstatica.push("b");
        
        Assert.assertEquals("b", pilhaEstatica.peek());
    }
}
