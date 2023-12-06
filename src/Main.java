import java.util.Scanner;

public class Main {
    private int numero;
    private String nomeTitular;
    private double saldo;

    public Main(int numero, String nomeTitular, double depositoInicial) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.saldo = depositoInicial;
        System.out.println("Conta cadastrada com sucesso!");
        exibirDadosConta();
    }

    public void deposito(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        exibirDadosConta();
    }

    public void retirar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
            System.out.println("Pedido de saque maior do que o saldo em conta.");
        }
        exibirDadosConta();
    }

    public void exibirDadosConta() {
        System.out.println("Número da Conta: " + numero);
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o nome do titular da conta: ");
        String nomeTitular = scanner.nextLine();

        System.out.print("Deseja realizar um depósito inicial? (S/N): ");
        char resposta = scanner.next().charAt(0);

        double depositoInicial = 0.0;
        if (resposta == 'S' || resposta == 's') {
            System.out.print("Informe o valor do depósito inicial: R$ ");
            depositoInicial = scanner.nextDouble();
        }

        Main conta = new Main(numeroConta, nomeTitular, depositoInicial);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Depósito");
            System.out.println("2. Saque");
            System.out.println("3. Encerrar programa");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor do depósito: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    conta.deposito(valorDeposito);
                    break;
                case 2:
                    System.out.print("Informe o valor do saque: R$ ");
                    double valorSaque = scanner.nextDouble();
                    conta.retirar(valorSaque);
                    break;
                case 3:
                    System.out.println("Programa encerrado. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
        scanner.close();
    }
}
