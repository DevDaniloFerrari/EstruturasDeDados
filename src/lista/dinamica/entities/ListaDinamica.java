package lista.dinamica.entities;

import lista.dinamica.exceptions.ListaDinamicaException;
import lista.dinamica.interfaces.IListaDinamica;

public class ListaDinamica implements IListaDinamica {

    private No Inicio, Fim;
    private int Tamanho;

    @Override
    public void InserirNoInicio(Object dado) {

        No novoNo = new No(dado);

        if (isEmpty()) {
            Inicio = Fim = novoNo;
        } else {
            novoNo.setProximoNo(Inicio);
            Inicio = novoNo;
        }
        Tamanho++;
    }

    @Override
    public Object RemoverNoInicio() throws ListaDinamicaException {

        if (isEmpty()) {
            throw new ListaDinamicaException("Lista vazia!");
        }

        Object objetoDeRetorno = Inicio.getDado();

        Inicio = Inicio.getProximoNo();

        Tamanho--;

        return objetoDeRetorno;
    }

    @Override
    public Object RemoverNoMeio(Object referencia) throws ListaDinamicaException {

        if (isEmpty()) {
            throw new ListaDinamicaException("Lista vazia!");
        }

        No noAuxiliar = Inicio;
        No noAnterior = Inicio;

        while (noAuxiliar != null) {
            if (noAuxiliar.getDado().equals(referencia)) {
                if (noAuxiliar == Inicio) {
                    this.RemoverNoInicio();
                }
                if (noAuxiliar == Fim) {
                    this.RemoverNoFinal();
                }

                Object objetoDeRetorno = noAuxiliar.getDado();

                noAnterior.setProximoNo(noAuxiliar.getProximoNo());

                Tamanho--;

                return objetoDeRetorno;
            } else {
                noAnterior = noAuxiliar;
                noAuxiliar = noAuxiliar.getProximoNo();
            }
        }
        return null;
    }

    @Override
    public void InserirNoFinal(Object dado) {

        No novoNo = new No(dado);

        if (isEmpty()) {
            Inicio = Fim = novoNo;
        } else {
            Fim.setProximoNo(novoNo);
            Fim = novoNo;
        }
        Tamanho++;
    }

    @Override
    public Object RemoverNoFinal() throws ListaDinamicaException {

        if (isEmpty()) {
            throw new ListaDinamicaException("Lista vazia!");
        }

        Object objetoDeRetorno = Fim.getDado();

        if (Inicio == Fim) {
            Inicio = Fim = null;
        } else {
            No noAuxiliar = Inicio;

            while (noAuxiliar.getProximoNo() != Fim) {
                noAuxiliar = noAuxiliar.getProximoNo();
            }

            Fim = noAuxiliar;
            Fim.setProximoNo(null);
        }

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
    public Object first() {
        return Inicio.getDado();
    }

    @Override
    public Object last() {
        return Fim.getDado();
    }

    @Override
    public String imprimir() {

        String impressao = "";
        No noAuxiliar = Inicio;

        if (this.isEmpty()) {
            return impressao;
        } else {
            while (noAuxiliar != null) {
                impressao += noAuxiliar.getDado().toString() + ";";
                noAuxiliar = noAuxiliar.getProximoNo();
            }
        }

        return impressao;

    }

}
