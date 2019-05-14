package pilha.dinamica.entities;

public class No {

    private Object Dado;
    private No ProximoNo;

    public No(Object Dado) {
        this.Dado = Dado;
    }

    public Object getDado() {
        return Dado;
    }

    public No getProximoNo() {
        return ProximoNo;
    }

    public void setProximoNo(No ProximoNo) {
        this.ProximoNo = ProximoNo;
    }
    
    
    
}
