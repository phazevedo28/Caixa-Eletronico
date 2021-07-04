package controller;

import javax.swing.JOptionPane;

public class CaixaEletronico {

    private Cedula cem;
    private Cedula cinquenta;
    private Cedula vinte;
    private Cedula dez;

    public CaixaEletronico() {
        this.cem = new Cedula(100);
        this.cinquenta = new Cedula(50);
        this.vinte = new Cedula(20);
        this.dez = new Cedula(10);
    }

    public void abastecer(int valor, int qtde) {
        if (((valor == 100 || valor == 50) || valor == 20) || valor == 10) {
            switch (valor) {
                case 100:
                    this.cem.setQtde(this.cem.getQtde() + qtde);
                    break;
                case 50:
                    this.cinquenta.setQtde(this.cinquenta.getQtde() + qtde);
                    break;
                case 20:
                    this.vinte.setQtde(this.vinte.getQtde() + qtde);
                    break;
                case 10:
                    this.dez.setQtde(this.dez.getQtde() + qtde);
            }
            JOptionPane.showMessageDialog(null, "foram adicionadas " + qtde + " notas de " + valor + " reais ");
        } else {
            JOptionPane.showMessageDialog(null, "Valor de nota invalido, insira um dos seguintes valores:100,50,20 ou 10");
        }

    }

    public void sacar(int valorSaque) {
        resetQtdeImpressa();
        if (isSaqueValido(valorSaque)) {
            valorSaque = extrairCedulas(valorSaque, this.cem);
            valorSaque = extrairCedulas(valorSaque, this.cinquenta);
            valorSaque = extrairCedulas(valorSaque, this.vinte);
            valorSaque = extrairCedulas(valorSaque, this.dez);
            verificarSaque(valorSaque);

        } else {
            JOptionPane.showMessageDialog(null, "O valor do saque e invalido,solicite outro valor");
        }

    }

    private int extrairCedulas(int valorSaque, Cedula cedula) {
        if (valorSaque >= cedula.getValor()) {
            int qtnotas = valorSaque / cedula.getValor();
            if (qtnotas <= cedula.getQtde()) {
                valorSaque = valorSaque - cedula.getValor() * qtnotas;
                cedula.setQtde(cedula.getQtde() - qtnotas);
                System.out.println("ainda restam " + cedula.getQtde() + " notas de " + cedula.getValor());
                System.out.println("ainda faltam " + valorSaque);
                cedula.setQtdeImpressa(qtnotas);

            } else {
                valorSaque = valorSaque - cedula.getQtde() * cedula.getValor();
                cedula.setQtde(0);
                System.out.println("ainda restam " + cedula.getQtde() + " notas de " + cedula.getValor());
                System.out.println("ainda faltam " + valorSaque);
                cedula.setQtdeImpressa(cedula.getQtde());
            }
        }
        return valorSaque;
    }

    private boolean isSaqueValido(int valorSaque) { // verifica a validade do saque antes de ser processado
        int total = cem.getQtde() * cem.getValor() + cinquenta.getQtde() * cinquenta.getValor() + vinte.getQtde() * vinte.getValor() + dez.getQtde() * dez.getValor();
        System.out.println("valor total disponivel: " + total);
        System.out.println("valor a ser sacado: " + valorSaque);
        return !(valorSaque % 10 != 0 || valorSaque > total);

    }

    private void resetQtdeImpressa() {
        this.cem.setQtdeImpressa(0);
        this.cinquenta.setQtdeImpressa(0);
        this.vinte.setQtdeImpressa(0);
        this.dez.setQtdeImpressa(0);
    }

    private void verificarSaque(int valorSobra) { // verifica se existem cedulas disponiveis para o valor do saque e informa o usuario
        if (valorSobra != 0) {
            devolverCedulas();
            JOptionPane.showMessageDialog(null, "Nao ha notas disponiveis suficiente para o saque");
        } else {
            JOptionPane.showMessageDialog(null, "Seu saque foi aprovado com " + cem.getQtdeImpressa() + " notas de cem, " + cinquenta.getQtdeImpressa() + " notas de cinquenta, " + vinte.getQtdeImpressa() + " notas de vinte, " + dez.getQtdeImpressa() + " notas de dez ");
        }
    }

    private void devolverCedulas() { // se o valor para saque for aprovado
        this.cem.setQtde(this.cem.getQtdeImpressa() + this.cem.getQtde());
        this.cinquenta.setQtde(this.cinquenta.getQtdeImpressa() + this.cinquenta.getQtde());
        this.vinte.setQtde(this.vinte.getQtdeImpressa() + this.vinte.getQtde());
        this.dez.setQtde(this.dez.getQtdeImpressa() + this.dez.getQtde());
        System.out.println("sobraram: " + this.cem.getQtde() + " notas de cem");
        System.out.println("sobraram: " + this.cinquenta.getQtde() + " notas de cinquenta");
        System.out.println("sobraram: " + this.vinte.getQtde() + " notas de vinte");
        System.out.println("sobraram: " + this.dez.getQtde() + " notas de dez");
    }
}
