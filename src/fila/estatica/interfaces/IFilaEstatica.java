package fila.estatica.interfaces;

public interface IFilaEstatica {

    public void enqueue(Object dado) throws Exception;

    public Object dequeue() throws Exception;

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public Object last();

}
