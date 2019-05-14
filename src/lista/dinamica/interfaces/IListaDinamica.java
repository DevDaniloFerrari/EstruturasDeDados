package lista.dinamica.interfaces;

public interface IListaDinamica {

    public void InserirNoInicio(Object dado);

    public Object RemoverNoInicio() throws Exception;

    public Object RemoverNoMeio(Object referencia) throws Exception;

    public void InserirNoFinal(Object dado);

    public Object RemoverNoFinal() throws Exception;

    public boolean isEmpty();

    public int size();

    public Object first();

    public Object last();

    public String imprimir();
}
