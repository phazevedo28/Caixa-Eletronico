package controller;

public class Cedula {

    private final int valor;
    private int qtde;
    private int qtdeImpressa; // informa quantas notas de cada valor foram impressas no último saque


    public Cedula(int valor) {
        this.valor = valor;
        this.qtde = 0;
        this.qtdeImpressa = 0;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public int getValor() {
        return valor;
    }

    public int getQtdeImpressa() {
        return qtdeImpressa;
    }

    public void setQtdeImpressa(int qtdeImpressa) {
        this.qtdeImpressa = qtdeImpressa;
    }

}
