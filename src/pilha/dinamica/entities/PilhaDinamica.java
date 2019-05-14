package pilha.dinamica.entities;

import pilha.dinamica.exceptions.PilhaDinamicaException;
import pilha.dinamica.interfaces.IPilhaDinamica;

public class PilhaDinamica implements IPilhaDinamica {

    private No Topo;
    private int Tamanho;
    
    @Override
    public void push(Object dado) {
        No novoNo = new No(dado);
        
        if (isEmpty()) {
            Topo = novoNo;
        } else {
            novoNo.setProximoNo(Topo);
            Topo = novoNo;
        }
        Tamanho++;
    }

    @Override
    public Object pop() throws PilhaDinamicaException {

        if (isEmpty()) {
            throw new PilhaDinamicaException("Pilha vazia!");
        }

        Object objetoDeRetorno = Topo.getDado();
        Topo = Topo.getProximoNo();
        Tamanho--;
        return objetoDeRetorno;
    }

    @Override
    public boolean isEmpty() {
        return Topo == null;
    }

    @Override
    public int size() {
        return Tamanho;
    }

    @Override
    public Object peek() {
        
        if(Topo==null){
            return null;
        }
        return Topo.getDado();
    }

}
