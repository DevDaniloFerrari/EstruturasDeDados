package tests;

import fila.dinamica.entities.FilaDinamica;
import fila.dinamica.exceptions.FilaDinamicaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilaDinamicaTest {

    FilaDinamica filaDinamica;

    @Before
    public void inicializarTest() {
        filaDinamica = new FilaDinamica();
    }

    @Test
    public void testInserirUmValorNaFila() throws FilaDinamicaException {
        filaDinamica.enqueue("a");
        Assert.assertEquals("a", filaDinamica.dequeue());
    }

    @Test
    public void testInserirDoisValorNaFila() throws FilaDinamicaException {
        filaDinamica.enqueue("a");
        filaDinamica.enqueue("b");
        Assert.assertEquals("a", filaDinamica.dequeue());
        Assert.assertEquals("b", filaDinamica.dequeue());
    }

    @Test
    public void testInserirTresValorNaFila() throws FilaDinamicaException {
        filaDinamica.enqueue("a");
        filaDinamica.enqueue("b");
        filaDinamica.enqueue("c");
        Assert.assertEquals("a", filaDinamica.dequeue());
        Assert.assertEquals("b", filaDinamica.dequeue());
        Assert.assertEquals("c", filaDinamica.dequeue());
    }

    @Test(expected = FilaDinamicaException.class)
    public void testRemoverValorComFilaVazia() throws FilaDinamicaException {
        filaDinamica.dequeue();
    }

    @Test
    public void testTamanhoDaFila() throws FilaDinamicaException {
        Assert.assertEquals(0, filaDinamica.size());

        filaDinamica.enqueue("a");
        filaDinamica.enqueue("b");

        Assert.assertEquals(2, filaDinamica.size());

        filaDinamica.dequeue();

        Assert.assertEquals(1, filaDinamica.size());

    }

    @Test
    public void testUltimoDaFila() throws FilaDinamicaException {
        Assert.assertNull(filaDinamica.last());

        filaDinamica.enqueue("a");
        filaDinamica.enqueue("b");
        filaDinamica.enqueue("c");

        Assert.assertEquals("c", filaDinamica.last());

        filaDinamica.dequeue();

        Assert.assertEquals("c", filaDinamica.last());

        filaDinamica.enqueue("d");

        Assert.assertEquals("d", filaDinamica.last());

    }

}
