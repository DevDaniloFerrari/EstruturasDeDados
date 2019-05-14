package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pilha.dinamica.entities.PilhaDinamica;
import pilha.dinamica.exceptions.PilhaDinamicaException;

public class PilhaDinamicaTest {

    PilhaDinamica pilhaDinamica;

    @Before
    public void inicializarTest() {
        pilhaDinamica = new PilhaDinamica();
    }

    @Test
    public void testInserirUmValorNaPilha() throws PilhaDinamicaException {
        pilhaDinamica.push("a");
        Assert.assertEquals("a", pilhaDinamica.pop());
    }

    @Test
    public void testInserirDoisValoresNaPilha() throws PilhaDinamicaException {
        pilhaDinamica.push("a");
        pilhaDinamica.push("b");
        Assert.assertEquals("b", pilhaDinamica.pop());
        Assert.assertEquals("a", pilhaDinamica.pop());
    }

    @Test
    public void testInserirTresValoresNaPilha() throws PilhaDinamicaException {
        pilhaDinamica.push("a");
        pilhaDinamica.push("b");
        pilhaDinamica.push("c");
        Assert.assertEquals("c", pilhaDinamica.pop());
        Assert.assertEquals("b", pilhaDinamica.pop());
        Assert.assertEquals("a", pilhaDinamica.pop());
    }

    @Test(expected = PilhaDinamicaException.class)
    public void testRemoverComPilhaVazia() throws PilhaDinamicaException {
        pilhaDinamica.pop();
    }

    @Test
    public void testObterTopo() {
        Assert.assertNull(pilhaDinamica.peek());

        pilhaDinamica.push("a");
        pilhaDinamica.push("b");

        Assert.assertEquals("b", pilhaDinamica.peek());

    }

    @Test
    public void testObterTamanhoDaPilha() throws PilhaDinamicaException {
        Assert.assertEquals(0, pilhaDinamica.size());

        pilhaDinamica.push("a");
        pilhaDinamica.push("b");

        Assert.assertEquals(2, pilhaDinamica.size());

        pilhaDinamica.pop();
            
        Assert.assertEquals(1, pilhaDinamica.size());

    }
}
