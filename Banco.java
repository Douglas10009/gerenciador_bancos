import java.util.Scanner;
public class Banco {
   public static void main(String[] args) {

    int [] clientes = new int []; //Tem que ter a quantidade para ser inicializada
    float [] contas = new float[]; //Aq tb
    float  saldo; // criar dentro do case
    float deposito; // criar dentro do case

    switch (menu){
        case 1:
          //Ainda tem que pedir para o usuário a quantidade do saque
          System.out.println("Saque" + (saldo - saque));
          float saque = sc.nextFloat();
          break;
      case 2:
        //Do depósito
        System.out.println("Deposito" + (saldo + deposito));
         break;
      case 3:
        //E da transferencia
        System.out.println("Transferencia");
        break;
        
    }
     
     }
}

//Possuir um menu e submenus utilizando switch case;
//O programa só poderá encerrar após o usuário informar;
//Utilizar vetores ou matrizes para registrar as informações. Não pode usar ArrayList ou outras classes de objetos Java;
//Utilizar estruturas de controle e repetição para realizar operações do banco;
// O usuário cliente deverá poder: sacar, depositar, transferir de uma conta para outra conta de outro cliente já cadastrado.
//O sistema deve visualizar o saldo de cada cliente cadastrado.