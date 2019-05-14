package pilha.estatica.entities;

import pilha.estatica.exceptions.PilhaEstaticaException;
import pilha.estatica.interfaces.IPilhaEstatica;

public class PilhaEstatica implements IPilhaEstatica {

    private Object[] Dados;
    private int Topo;

    public PilhaEstatica(int tamanho) {
        this.Dados = new Object[tamanho];
        this.Topo = 0;
    }

    @Override
    public void push(Object dado) throws PilhaEstaticaException {
        if (this.isFull()) {
            throw new PilhaEstaticaException("Pilha cheia!");
        }

        Dados[Topo] = dado;
        Topo++;
    }

    @Override
    public Object pop() throws PilhaEstaticaException {
        if (this.isEmpty()) {
            throw new PilhaEstaticaException("Pilha cheia");
        }

        Topo--;
        Object objetoDeRetorno = Dados[Topo];
        return objetoDeRetorno;
    }

    @Override
    public boolean isEmpty() {
        return Topo == 0;
    }

    @Override
    public boolean isFull() {
        return Topo == Dados.length;
    }

    @Override
    public int size() {
        return Topo;
    }

    @Override
    public Object peek() {

        if (Topo == 0) {
            return null;
        }
        return Dados[(Topo - 1)];
    }

}
