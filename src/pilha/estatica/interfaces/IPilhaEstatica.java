package pilha.estatica.interfaces;

public interface IPilhaEstatica {

    public void push(Object dado) throws Exception;

    public Object pop() throws Exception;

    public boolean isEmpty();

    public boolean isFull();

    public Object peek();
    
    public int size();
}
