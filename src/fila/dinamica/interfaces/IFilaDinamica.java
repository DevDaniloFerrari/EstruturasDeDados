package fila.dinamica.interfaces;

public interface IFilaDinamica {

    public void enqueue(Object dado);
    public Object dequeue() throws Exception;
    public boolean isEmpty();
    public int size();
    public Object last();
    
}