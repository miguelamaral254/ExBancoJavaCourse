import java.util.Scanner;

import entities.Conta;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Req Account data
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

        // Create account
        Conta conta = new Conta(numeroConta, nomeTitular, depositoInicial);

        int opcao;
        do {
            // Show menu
            System.out.println("Menu:");
            System.out.println("1. Depósito");
            System.out.println("2. Saque");
            System.out.println("3. Encerrar programa");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            // Switch 
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
        } while (opcao != 3); // Kill Program

        scanner.close();
    }
}
