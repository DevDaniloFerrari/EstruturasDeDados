package tests;

import lista.dinamica.entities.ListaDinamica;
import lista.dinamica.exceptions.ListaDinamicaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListaDinamicaTest {

    ListaDinamica listaDinamica;

    @Before
    public void inicializarTest() {
        listaDinamica = new ListaDinamica();
    }

    @Test
    public void testInserirUmValorNoInicio() throws ListaDinamicaException {
        listaDinamica.InserirNoInicio("a");
        Assert.assertEquals("a", listaDinamica.RemoverNoInicio());
    }

    
    @Test
    public void testInserirDoisValoresNoInicio() throws ListaDinamicaException {
        listaDinamica.InserirNoInicio("a");
        listaDinamica.InserirNoInicio("b");
        Assert.assertEquals("b", listaDinamica.RemoverNoInicio());
        Assert.assertEquals("a", listaDinamica.RemoverNoInicio());
    }

    @Test
    public void testInserirTresValoresNoInicio() throws ListaDinamicaException {
        listaDinamica.InserirNoInicio("a");
        listaDinamica.InserirNoInicio("b");
        listaDinamica.InserirNoInicio("c");
        Assert.assertEquals("c", listaDinamica.RemoverNoInicio());
        Assert.assertEquals("b", listaDinamica.RemoverNoInicio());
        Assert.assertEquals("a", listaDinamica.RemoverNoInicio());
    }

    @Test
    public void testInserirUmValorNoFinal() throws ListaDinamicaException {
        listaDinamica.InserirNoFinal("a");
        Assert.assertEquals("a", listaDinamica.RemoverNoFinal());
    }

    @Test
    public void testInserirDoisValoresNoFinal() throws ListaDinamicaException {
        listaDinamica.InserirNoFinal("a");
        listaDinamica.InserirNoFinal("b");
        Assert.assertEquals("b", listaDinamica.RemoverNoFinal());
        Assert.assertEquals("a", listaDinamica.RemoverNoFinal());
    }

    @Test
    public void testInserirTresValoresNoFinal() throws ListaDinamicaException {
        listaDinamica.InserirNoFinal("a");
        listaDinamica.InserirNoFinal("b");
        listaDinamica.InserirNoFinal("c");
        Assert.assertEquals("c", listaDinamica.RemoverNoFinal());
        Assert.assertEquals("b", listaDinamica.RemoverNoFinal());
        Assert.assertEquals("a", listaDinamica.RemoverNoFinal());
    }

    @Test
    public void testRemoverUmValorNoMeio() throws ListaDinamicaException {
        listaDinamica.InserirNoInicio("a");
        listaDinamica.InserirNoInicio("b");
        listaDinamica.InserirNoInicio("c");

        Assert.assertEquals("c;b;a;", listaDinamica.imprimir());

        Assert.assertEquals("b", listaDinamica.RemoverNoMeio("b"));

        Assert.assertEquals("c;a;", listaDinamica.imprimir());

    }

    @Test
    public void testRemoverDoisValoresNoMeio() throws ListaDinamicaException {
        listaDinamica.InserirNoInicio("a");
        listaDinamica.InserirNoInicio("b");
        listaDinamica.InserirNoInicio("c");
        listaDinamica.InserirNoInicio("d");
        listaDinamica.InserirNoInicio("e");

        Assert.assertEquals("e;d;c;b;a;", listaDinamica.imprimir());

        Assert.assertEquals("b", listaDinamica.RemoverNoMeio("b"));
        Assert.assertEquals("d", listaDinamica.RemoverNoMeio("d"));

        Assert.assertEquals("e;c;a;", listaDinamica.imprimir());

    }

    @Test
    public void testSequenciaCorreta() {
        listaDinamica.InserirNoInicio("b");
        listaDinamica.InserirNoInicio("a");
        listaDinamica.InserirNoFinal("c");
        listaDinamica.InserirNoFinal("d");

        Assert.assertEquals("a;b;c;d;", listaDinamica.imprimir());
    }

    @Test
    public void testTamanho() throws ListaDinamicaException {
        Assert.assertEquals(0, listaDinamica.size());

        listaDinamica.InserirNoInicio("a");
        listaDinamica.InserirNoFinal("b");

        Assert.assertEquals(2, listaDinamica.size());

        listaDinamica.RemoverNoInicio();

        Assert.assertEquals(1, listaDinamica.size());

        listaDinamica.RemoverNoFinal();

        Assert.assertEquals(0, listaDinamica.size());

    }

    @Test
    public void testObterPrimeiroDaLista() {
        listaDinamica.InserirNoInicio("a");
        listaDinamica.InserirNoInicio("b");
        listaDinamica.InserirNoFinal("c");

        Assert.assertEquals("b", listaDinamica.first());
    }

    @Test
    public void testObterUltimoDaLista() {
        listaDinamica.InserirNoInicio("a");
        listaDinamica.InserirNoInicio("b");
        listaDinamica.InserirNoFinal("c");
        listaDinamica.InserirNoFinal("d");

        Assert.assertEquals("d", listaDinamica.last());
    }

    @Test(expected = ListaDinamicaException.class)
    public void testRemoverNoInicioComListaVazia() throws ListaDinamicaException {
        listaDinamica.RemoverNoInicio();
    }

    @Test(expected = ListaDinamicaException.class)
    public void testRemoverNoFinalComListaVazia() throws ListaDinamicaException {
        listaDinamica.RemoverNoFinal();
    }

    @Test(expected = ListaDinamicaException.class)
    public void testRemoverDoMeioComListaVazia() throws ListaDinamicaException {
        listaDinamica.RemoverNoMeio("a");
    }
}
