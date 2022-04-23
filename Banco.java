import java.util.Scanner;

public class Banco {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //OBSERVAÇÃO!!!
    //O número da conta mostrado para o cliente, e o index
    //Para organização no backend, são diferentes
    //Se na tela do usuário estiver escrito ("Seja bem vindo conta número 1")
    //Logo a sua posição no vetor conta, é 0
    //Ou seja, o index do vetor conta, sempre vai ser menos 1, no
    //número que está sendo mostrado na tela
    //O número mostrado na tela tem o valor da variável j
    //E o index da variável conta tem o valor da variável i

    //Sandbox de variáveis
    boolean ContaCriada = false; // Verifica se a conta foi devidamente criada
    int[] conta = new int[10]; // Cria um vetor de 10 posições com o número das contas ,começando a partir do zero
    int i = 0; // Contador para o vetor, assume o lugar de conta
    int j = 1; // Contador para o vetor, assume o luga de conta, a posição mostrada para o usuário
    int essaConta = 0; //Define uma variável para a conta que está sendo acessada
    float esseSaldo = 0; // Define uma variável para o saldo da conta que está sendo acessada
    int trocarConta = 0; // Contador para o vetor
    float saque, deposito, transferencia;
    float[] saldo = new float[10]; //Vetor com os dados de saldo de cada cliente, o indice define qual cliente é o dono da conta
    int menu = 0; // Contador para verificar qual ação a ser realizada
    int contaTransferida = 0; // Conta que será transferida
    //Final da sandbox de variáveis

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
          conta[0] = 1;
          essaConta = conta[0]; // Define uma variável para a conta que será criada
          esseSaldo = saldo[0]; // Define uma variável para o saldo da conta que será criada

          System.out
              .println("Seja bem vindo, seu número da conta é: " + essaConta + "! Seu saldo é de R$" + esseSaldo + "\n");
          ContaCriada = true;
          break;
      }
    }

    if (ContaCriada == true) {

      System.out.println("\n-----> Obrigado por realizar seu cadastro! :)");

      // Inicia o menu
      while (menu != 6) { // 6 é o número que coloquei para ser o fim do programa
        System.out.println("\n---------- Banco Trilegal ----------");
        System.out.println("Seja bem vindo, conta número " + essaConta + ",  ao Banco Trilegal! \n");

        System.out.println("Para realizar uma ação, digite uma das opções abaixo:");
        System.out.println("1 - Sacar");
        System.out.println("2 - Saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferência");
        System.out.println("5 - Cadastrar um novo usuário");
        System.out.println("6 - Sair");
        System.out.println("7 - Acessar outra conta");

        System.out.print("Digite o número da opção desejada: ");
        menu = sc.nextInt();

        System.out.println(" ");

        switch (menu) {
          case 1: // Sacar

            // Verificar se tem saldo para sacar
            System.out.print("Digite o valor do saque: R$");
            saque = sc.nextFloat();

            if (saque > esseSaldo) {
              System.out.println("\n-----> Saldo insuficiente!\n"); // Aviso de saldo insuficiente

            } else {
              esseSaldo -= saque; // Retira o valor do saldo
              System.out.println("\n-----> Saque realizado com sucesso! Seu saldo atual é de R$" + esseSaldo); // Aviso
                                                                                                               // de
                                                                                                               // saque
                                                                                                               // realizado
                                                                                                               // com
                                                                                                               // sucesso
            }
            break;

          case 2: // Mostra o saldo
            System.out.println("\n-----> Seu saldo é de: R$" + esseSaldo);
            break;

          case 3:// Depositar
            // Do depósito
            System.out.print("Digite o valor do depósito: R$");
            deposito = sc.nextFloat();

            esseSaldo += deposito; // Adiciona o valor ao saldo
            saldo[i] = esseSaldo; // Atualiza o saldo da conta
      
            System.out.println("\n-----> Depósito realizado com sucesso! Seu saldo atual é de R$" + esseSaldo); // Aviso
                                                                                                                // de
                                                                                                                // depósito
                                                                                                                // realizado
            break;

          case 4:// Transferência
            // E da transferencia
            System.out.print("Digite o valor da transferência: R$");
            transferencia = sc.nextFloat();

            if (transferencia > esseSaldo) {
              System.out.println("\n-----> Saldo insuficiente!\n"); // Aviso de saldo insuficiente

            } else {
              System.out.print("Transferir para qual conta? ");
              contaTransferida = sc.nextInt();

              if (contaTransferida == essaConta) {
                System.out.println("\n-----> Você não pode transferir para a mesma conta!"); // Aviso de transferência para a mesma conta

              } else {
                if (contains(conta, contaTransferida)) {
                  esseSaldo -= transferencia; // Retira o valor do saldo da conta que vai transferir o dinheiro
                  saldo[i] = esseSaldo; // Atualiza o saldo da conta

                  contaTransferida --; // Decrementa o contador do vetor para acessar a posição correta do vetor
                  saldo[contaTransferida] += transferencia; //Atribui o valor para a conta que receberá a transferência
                  
                  System.out.println("\n-----> Transferência realizada com sucesso! Seu saldo atual é de R$" + esseSaldo); // Aviso  de  transferência realizada

                } else {
                  System.out.println("\n-----> Conta não encontrada!"); // Aviso de conta não encontrada
                }
              }
            }
            break;

          case 5: // Cadastrar um novo usuário
            if (j < 10) {
              i++;
              j++;

              conta[i] = j;
              essaConta = conta[i]; // Define uma variável para a conta que será criada

              System.out.println("---- Seja bem vindo, o número de sua conta é: " + essaConta + ", e seu saldo é de R$ 0,00 ----");
              saldo[i] = 0;
              esseSaldo = saldo[i]; // Define uma variável para o saldo da conta que será criada
              ContaCriada = true;

            } else {
              System.out.println("\n-----> Você atingiu o limite de contas!"); // Aviso de limite de contas atingido

            }
            break;

          case 7: // Acessar outra conta
            if (i > 0) { // Verifica se há mais de uma conta criada
              System.out.println("\nQual conta quer acessar? ");

              for (int k = 0; k <= i; k++) { // Mostra as contas criadas
                System.out.println("Conta número " + conta[k]);
              }

              System.out.print("Digite o número da conta: ");
              trocarConta = sc.nextInt();
              trocarConta --; // Decrementa o contador do vetor para acessar a posição correta do vetor conta

              if (contains(conta, trocarConta)) { // Verifica se a conta existe
                essaConta = conta[trocarConta]; //Define a variavel essaConta com a conta que será acessada
                saldo[trocarConta] = esseSaldo; // Define uma variável esseSaldo para o saldo da conta que será acessada
                System.out.println("\n-----> Conta número " + essaConta + " selecionada com sucesso!"); // Aviso de conta selecionada com sucesso

              } else {
                System.out.println("\n-----> Conta não encontrada!");

              }
            } else {
              System.out.println("\n-----> Só tem a sua conta cadastrada!");
            }
            System.out.println();
            break;
        }

        System.out.println(" ");
      }

      System.out.println("-----> Obrigado por utilizar o Banco Trilegal!"); // Aviso de saída do programa

    } else {
      System.out.println("\n-----> Obrigado por utilizar nosso banco!"); // Aviso de erro ao criar conta
    }

    sc.close();
  }

  public static boolean contains(final int[] arr, final int key) {
    boolean found = false;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key) {
        found = true;
      }
    }
    return found;
  }
}

// Possuir um menu e submenus utilizando switch case; 🆗
// O programa só poderá encerrar após o usuário informar; 🆗
// Utilizar vetores ou matrizes para registrar as informações. Não pode usar
// ArrayList ou outras classes de objetos Java; 🆗
// Utilizar estruturas de controle e repetição para realizar operações do banco;
// 🆗
// O usuário cliente deverá poder: sacar, depositar, transferir de uma conta
// para outra conta de outro cliente já cadastrado. 🆗
// O sistema deve visualizar o saldo de cada cliente cadastrado. 🆗