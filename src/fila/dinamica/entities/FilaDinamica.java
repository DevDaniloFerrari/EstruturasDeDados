package fila.dinamica.entities;

import fila.dinamica.exceptions.FilaDinamicaException;
import fila.dinamica.interfaces.IFilaDinamica;

public class FilaDinamica implements IFilaDinamica {

    private No Inicio, Fim;
    private int Tamanho;

    @Override
    public void enqueue(Object dado) {
        No novoNo = new No(dado);

        if (isEmpty()) {
            Inicio = Fim = new No(dado);
        } else {
            Fim.setProximoNo(novoNo);
            Fim = novoNo;
        }

        Tamanho++;

    }

    @Override
    public Object dequeue() throws FilaDinamicaException {

        if (isEmpty()) {
            throw new FilaDinamicaException("Fila vazia!");
        }

        Object objetoDeRetorno = Inicio.getDado();

        Inicio = Inicio.getProximoNo();

        Tamanho--;

        return objetoDeRetorno;
    }

    @Override
    public boolean isEmpty() {
        return Inicio == null;
    }

    @Override
    public int size() {
        return Tamanho;
    }

    @Override
    public Object last() {
        if(Fim==null){
            return null;
        }
        return Fim.getDado();
    }

}
