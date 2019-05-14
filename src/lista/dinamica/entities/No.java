package lista.dinamica.entities;

public class No {

    private Object Dado;
    private No proximoNo;

    public No(Object Dado) {
        this.Dado = Dado;
    }

    public Object getDado() {
        return Dado;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

}
