import java.util.Scanner;

public class Banco {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    boolean ContaCriada = false; // Verifica se a conta foi devidamente criada
    int [] conta = new int[10]; // Cria um vetor de 10 posições com o número das contas
    String [] nome = new String[10]; // Nome do cliente

    float saque, deposito, transferencia;
    float [] saldo = new float[10];
    int menu = 0; // Contador para verificar qual ação a ser realizada
    String contaTransferida = ""; // Conta que será transferida

    // Pede a criação de conta no banco Trilegal
    while (ContaCriada != true && menu != 2) {
      System.out.println("---------- Banco Trilegal ----------");
      System.out.println("Seja bem vindo ao Banco Trilegal! \n");

      System.out.println("Para realizar uma ação, digite uma das opções abaixo:");
      System.out.println("--> ATENÇÃO, PARA REALIZAR QUALQUER PROCEDIMENTO, POR FAVOR, CRIE UMA CONTA");
      System.out.println("1 - Cadastrar Conta");
      System.out.println("2 - Sair");

      System.out.print("Digite o número da opção desejada: ");
      menu = sc.nextInt();

      switch (menu) {
        case 1:
          System.out.print("Digite seu nome: ");
          nome = sc.next();
          // sc.next(); //Para debug, pois fica um "enter" no final da variável nome

          System.out.println("Seja bem vindo, " + nome + "! Seu saldo é de R$ 0,00 \n");
          saldo = 0;
          ContaCriada = true;
          break;
      }
    }

    if (ContaCriada == true) {

      System.out.println("\n Obrigado por realizar seu cadastro! :)");

      // Inicia o menu
      while (menu != 6) { // 6 é o número que coloquei para ser o fim do programa
        System.out.println("\n---------- Banco Trilegal ----------");
        System.out.println("Seja bem vindo, " + nome + ",  ao Banco Trilegal! \n");

        System.out.println("Para realizar uma ação, digite uma das opções abaixo:");
        System.out.println("1 - Sacar");
        System.out.println("2 - Saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferência");
        System.out.println("5 - Cadastrar um novo usuário");
        System.out.println("6 - Sair");

        System.out.print("Digite o número da opção desejada: ");
        menu = sc.nextInt();

        System.out.println(" ");

        switch (menu) {
          case 1: // Sacar

            //Verificar se tem saldo para sacar
            System.out.print("Digite o valor do saque: R$");
            saque = sc.nextFloat();
            saldo = -saque; // Retira o valor do saldo

            System.out.println("Saque realizado com sucesso! Seu saldo atual é de R$" + saldo);
            break;

          case 2: // Mostra o saldo
            System.out.println("Seu saldo é de: R$" + saldo);
            break;

          case 3:// Depositar
            // Do depósito
            System.out.print("Digite o valor do depósito: R$");
            deposito = sc.nextFloat();

            saldo = +deposito; // Adiciona o valor ao saldo
            System.out.println("Depósito realizado com sucesso! Seu saldo atual é de R$" + saldo);
            break;

          case 4:// Transferência
            // E da transferencia
            System.out.print("Digite o valor da transferência: R$");
            transferencia = sc.nextFloat();

            System.out.println("Transferir para qual conta?");
            contaTransferida = sc.next();

            sc.next(); // Para debug, pois fica um "enter" no final

            saldo = -transferencia; // Retira o valor do saldo
            System.out.println("Transferência realizada com sucesso! Seu saldo atual é de R$" + saldo);
            break;

          case 5: // Cadastra um novo usuário
            // ATENÇÃO: Temos um problema aqui, como que vamos identificar os clientes?
            // temos que usar vetores ou matrizes para organizar os clientes, então poderia
            // ser por números..
            // Então, tem que implementar isso, e deve ficar dividido: Olá cliente número:
            // NÚUMERO_CLIENTE, seja bem vindo NOME
            System.out.print("Digite seu nome: ");
            nome = sc.next();
            sc.next(); // Para debug, pois fica um "enter" no final da variável nome

            System.out.println("Seja bem vindo, " + nome + "! Seu saldo é de R$ 0,00");
            saldo = 0;
            ContaCriada = true;
            break;
        }

        System.out.println(" ");
      }

      
      System.out.println("Obrigado por utilizar o Banco Trilegal!");
      
    } else {
      System.out.println("Ocorreu um erro ao criar sua conta!");

    }

  sc.close();
  }
}

// Possuir um menu e submenus utilizando switch case;
// O programa só poderá encerrar após o usuário informar;
// Utilizar vetores ou matrizes para registrar as informações. Não pode usar
// ArrayList ou outras classes de objetos Java;
// Utilizar estruturas de controle e repetição para realizar operações do banco;
// O usuário cliente deverá poder: sacar, depositar, transferir de uma conta
// para outra conta de outro cliente já cadastrado.
// O sistema deve visualizar o saldo de cada cliente cadastrado.