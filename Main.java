package projeto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opc = 0;
        int agencia,numconta;
        double valor;
        Scanner scanner = new Scanner(System.in);

        while (opc != 6) {
            System.out.println("1- Criar conta");
            System.out.println("2- Verificar as Contas");
            System.out.println("3- Depositar");
            System.out.println("4- Sacar");
            System.out.println("5- Transferir");
            System.out.println("6- Sair");
            System.out.print("Escolha: ");
            opc = scanner.nextInt(); // Ler a entrada do usuário
            switch (opc) {
                case 1:
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.println("Informe o Nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Informe seu CPF: ");
                    int CPF = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    Cliente cliente = new Cliente();
                    cliente.setCPF(CPF);
                    cliente.setNome(nome);
                    String Tipo;
                    do {
                        System.out.println("Informe o tipo da Conta (CC (Conta Corrente) ou CP (Conta Poupanca)): ");
                        Tipo = scanner.nextLine();
                        Tipo = Tipo.toUpperCase();
                        if (Tipo.equals("CC")) {
                            Conta novaConta = new ContaCorrente();
                            novaConta.Tipo = Tipo;
                            novaConta.clientes.add(novaConta);
                            System.out.println(novaConta.toString());
                        } else if (Tipo.equals("CP")) {
                            Conta novaConta = new ContaPoupanca();
                            novaConta.Tipo = Tipo;
                            novaConta.clientes.add(novaConta);
                            System.out.println(novaConta.toString());
                        } else {
                            System.out.println("Informe um tipo de conta válida");
                        }
                    } while (!Tipo.equals("CC") && !Tipo.equals("CP"));
                    System.out.println("Conta criada com sucesso");
                    break;
                case 2:
                    Conta.getListClinte();
                    break;

                case 3:
                    System.out.println("Informe a Agencia da conta: ");
                    agencia = scanner.nextInt();
                    System.out.println("informe o numero da conta: ");
                    numconta = scanner.nextInt();
                    System.out.println("Informe o valor a ser depositado: ");
                    valor = scanner.nextDouble();
                    Conta.depositar(valor,agencia, numconta);
                    break;
                case 4:
                    System.out.println("Informe a Agencia da conta: ");
                    agencia = scanner.nextInt();
                    System.out.println("informe o numero da conta: ");
                    numconta = scanner.nextInt();
                    System.out.println("Informe o valor a ser sacado: ");
                    valor = scanner.nextDouble();
                    Conta.sacar(valor,agencia,numconta);
                    break;
                case 5:
                    System.out.println("Informe a Agencia da conta: ");
                    agencia = scanner.nextInt();
                    System.out.println("informe o numero da conta: ");
                    numconta = scanner.nextInt();
                    Conta contaAtual = Conta.buscarConta(agencia, numconta);
                    System.out.println("Informe o valor a ser transferido: ");
                    valor = scanner.nextDouble();

                    System.out.println("Informe a Agencia da conta Destino: ");
                    agencia = scanner.nextInt();
                    System.out.println("informe o numero da conta Destino: ");
                    numconta = scanner.nextInt();
                    Conta contaDestino = Conta.buscarConta(agencia, numconta);
                    Conta.transferir(valor,contaAtual,contaDestino);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}
