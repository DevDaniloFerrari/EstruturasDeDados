package tests;

import fila.estatica.entities.FilaEstatica;
import fila.estatica.exceptions.FilaEstaticaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilaEstaticaTest {

    FilaEstatica filaEstatica;

    @Before
    public void inicializarTest() {
        filaEstatica = new FilaEstatica(5);
    }

    @Test
    public void testInserirUmValorNaFila() throws FilaEstaticaException {
        filaEstatica.enqueue("a");
        Assert.assertEquals("a", filaEstatica.dequeue());
    }

    @Test
    public void testInserirDoisValoresNaFila() throws FilaEstaticaException {
        filaEstatica.enqueue("a");
        filaEstatica.enqueue("b");
        Assert.assertEquals("a", filaEstatica.dequeue());
        Assert.assertEquals("b", filaEstatica.dequeue());
    }

    @Test
    public void testInserirTresValoresNaFila() throws FilaEstaticaException {
        filaEstatica.enqueue("a");
        filaEstatica.enqueue("b");
        filaEstatica.enqueue("c");
        Assert.assertEquals("a", filaEstatica.dequeue());
        Assert.assertEquals("b", filaEstatica.dequeue());
        Assert.assertEquals("c", filaEstatica.dequeue());
    }

    @Test(expected = FilaEstaticaException.class)
    public void testInserirComFilaCheia() throws FilaEstaticaException {
        filaEstatica.enqueue("a");
        filaEstatica.enqueue("b");
        filaEstatica.enqueue("c");
        filaEstatica.enqueue("d");
        filaEstatica.enqueue("e");
        filaEstatica.enqueue("f");
    }

    @Test(expected = FilaEstaticaException.class)
    public void testRemoverComFilaVazia() throws FilaEstaticaException {
        filaEstatica.dequeue();
    }

    @Test
    public void testTamanhoDaFila() throws FilaEstaticaException {
        Assert.assertEquals(0, filaEstatica.size());

        filaEstatica.enqueue("a");
        filaEstatica.enqueue("b");

        Assert.assertEquals(2, filaEstatica.size());

        filaEstatica.dequeue();

        Assert.assertEquals(1, filaEstatica.size());

    }

    @Test
    public void testUltimoValorDaFila() throws FilaEstaticaException {
        Assert.assertNull(filaEstatica.last());

        filaEstatica.enqueue("a");
        filaEstatica.enqueue("b");
        filaEstatica.enqueue("c");

        Assert.assertEquals("c", filaEstatica.last());

        filaEstatica.dequeue();

        Assert.assertEquals("c", filaEstatica.last());

        filaEstatica.enqueue("d");
        Assert.assertEquals("d", filaEstatica.last());

    }

}
