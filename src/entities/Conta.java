package entities;

public class Conta {
    private int numero;
    private String nomeTitular;
    private double saldo;

    // Construtor
    public Conta(int numero, String nomeTitular, double depositoInicial) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.saldo = depositoInicial;
        System.out.println("Conta cadastrada com sucesso!");
        exibirDadosConta();
    }

    // Deposit method
    public void deposito(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        exibirDadosConta();
    }

    // Withdraw method
    public void retirar(double valor) {
        double valorSaque = valor + 5.0; // Taxa de saque(faz o L)
        if (saldo >= valorSaque) {
            saldo -= valorSaque;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            System.out.println("Taxa de saque: R$ 5.00");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
            System.out.println("Pedido de saque maior do que o saldo em conta.");
        }
        exibirDadosConta();
    }

    // Show data method
    public void exibirDadosConta() {
        System.out.println("Número da Conta: " + numero);
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("------------------------------");
    }
}
