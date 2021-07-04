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
        if (valor == 100 || valor == 50 || valor == 20 || valor == 10) {
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
            JOptionPane.showMessageDialog(null, "Valor de nota inválido, insira um dos seguintes valores:100,50,20 ou 10");
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
            JOptionPane.showMessageDialog(null, "O valor do saque é inválido, solicite outro valor");
        }

    }

    private int extrairCedulas(int valorSaque, Cedula cedula) {//atualiza os atributos da cedula e retorna o valor que ainda falta para completar o saque
        if (valorSaque >= cedula.getValor()) {
            int qtdecedulas = valorSaque / cedula.getValor(); // determina a quantidade de cedulas que serao utilizadas no saque
            if (qtdecedulas < cedula.getQtde()) {
                valorSaque = valorSaque - cedula.getValor() * qtdecedulas;
                cedula.setQtdeImpressa(qtdecedulas);
                cedula.setQtde(cedula.getQtde() - qtdecedulas);  
                System.out.println("voce ainda tem "+cedula.getQtde()+" cedulas de "+cedula.getValor());
                 System.out.println("foram impressas "+cedula.getQtdeImpressa()+" cedulas de "+cedula.getValor());

            } else {
                valorSaque = valorSaque - cedula.getQtde() * cedula.getValor();
                cedula.setQtdeImpressa(cedula.getQtde());
                cedula.setQtde(0);
                 System.out.println("voce ainda tem "+cedula.getQtde()+" cedulas de "+cedula.getValor());
                 System.out.println("foram impressas "+cedula.getQtdeImpressa()+" cedulas de "+cedula.getValor());
            }
        }
        return valorSaque;
    }

    private boolean isSaqueValido(int valorSaque) { // verifica a validade do saque antes de ser processado
        int total = cem.getQtde() * cem.getValor() + cinquenta.getQtde() * cinquenta.getValor() + vinte.getQtde() * vinte.getValor() + dez.getQtde() * dez.getValor();
        System.out.println("o Valor total disponivel no caixa eh: "+total);
        System.out.println("o valor solicitado para saque eh: "+ valorSaque);
        return (valorSaque % 10 == 0 && valorSaque <= total);

    }

    private void resetQtdeImpressa() { // define como 0 a quantidade de notas impressas antes de um novo saque
        this.cem.setQtdeImpressa(0);
        this.cinquenta.setQtdeImpressa(0);
        this.vinte.setQtdeImpressa(0);
        this.dez.setQtdeImpressa(0);
    }

    private void verificarSaque(int valorSobra) { // verifica se existem cedulas disponiveis para o valor do saque e informa o usuario
        if (valorSobra != 0) {
            reporCedulas();
            JOptionPane.showMessageDialog(null, "Não existem notas disponíveis o suficiente para o saque, tente outro valor");
        } else {
            JOptionPane.showMessageDialog(null, "Seu saque foi aprovado com " + cem.getQtdeImpressa() + " notas de cem, " + cinquenta.getQtdeImpressa() + " notas de cinquenta, " + vinte.getQtdeImpressa() + " notas de vinte, " + dez.getQtdeImpressa() + " notas de dez ");
        }
    }

    private void reporCedulas() { // se o valor para saque nao for aprovado, devolve as cedulas que foram retiradas
        this.cem.setQtde(this.cem.getQtdeImpressa() + this.cem.getQtde());
        this.cinquenta.setQtde(this.cinquenta.getQtdeImpressa() + this.cinquenta.getQtde());
        this.vinte.setQtde(this.vinte.getQtdeImpressa() + this.vinte.getQtde());
        this.dez.setQtde(this.dez.getQtdeImpressa() + this.dez.getQtde());
        System.out.println("foram devolvidas: "+ cem.getQtdeImpressa()+"notas de "+ cem.getValor());
        System.out.println("foram devolvidas: "+ cinquenta.getQtdeImpressa()+"notas de "+ cinquenta.getValor());
        System.out.println("foram devolvidas: "+ vinte.getQtdeImpressa()+"notas de "+ vinte.getValor());
        System.out.println("foram devolvidas: "+ dez.getQtdeImpressa()+"notas de "+ dez.getValor());
          
    }
}
