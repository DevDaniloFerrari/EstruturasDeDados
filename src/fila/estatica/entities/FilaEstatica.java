package fila.estatica.entities;

import fila.estatica.exceptions.FilaEstaticaException;
import fila.estatica.interfaces.IFilaEstatica;

public class FilaEstatica implements IFilaEstatica {

    private Object[] Dados;
    private int Inicio, Fim, Tamanho;

    public FilaEstatica(int tamanhoDaFila) {
        this.Dados = new Object[tamanhoDaFila];
        this.Inicio = -1;
        this.Fim = 0;
    }

    @Override
    public void enqueue(Object dado) throws FilaEstaticaException {

        if (isFull()) {
            throw new FilaEstaticaException("Fila cheia!");
        }

        if (isEmpty()) {
            Inicio++;
            Dados[Inicio] = dado;
        } else {
            Fim++;
            Dados[Fim] = dado;
        }

        Tamanho++;

    }

    @Override
    public Object dequeue() throws FilaEstaticaException {

        if (isEmpty()) {
            throw new FilaEstaticaException("Fila vazia!");
        }

        Tamanho--;

        Object objetoDeRetorno = Dados[Inicio];

        if (Inicio == Fim) {
            Inicio--;
        } else {
            Fim--;
        }

        for (int i = 0; i <= Tamanho; i++) {
            Dados[i] = Dados[i + 1];
        }

        return objetoDeRetorno;
    }

    @Override
    public boolean isEmpty() {
        return Inicio == -1;
    }

    @Override
    public boolean isFull() {
        return Tamanho == Dados.length;
    }

    @Override
    public int size() {
        return Tamanho;
    }

    @Override
    public Object last() {
        return Dados[Fim];
    }

}
