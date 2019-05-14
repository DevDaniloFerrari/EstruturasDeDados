package pilha.dinamica.interfaces;

public interface IPilhaDinamica {
    
    public void push(Object dado);
    public Object pop() throws Exception;
    public boolean isEmpty();
    public int size();
    public Object peek();
}