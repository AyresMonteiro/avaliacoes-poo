package atividade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainActivity {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);

    try {
      System.out.println("Digite o nome do proprietario da conta:");
      String nome = leitor.next();
      System.out.println("Digite o seu limite de crédito:");
      double limite = leitor.nextDouble();
      System.out.println("Digite o seu saldo atual:");
      double saldo = leitor.nextDouble();

      ContaBancaria usuario = new ContaBancaria(limite, nome, saldo);

      int opcao = 5;

      while (opcao > 0){
        System.out.println("\n" + "-=".repeat(20) + "-\n");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Sacar");
        System.out.println("2 - Depositar");
        System.out.println("3 - Ver saldo\n");
        System.out.println("0 - Sair");

        opcao = leitor.nextInt();

        switch(opcao) {
          case 0:
            break;
          case 1:
            System.out.println("Insira o valor que deseja sacar:");
            double valorSaque = leitor.nextDouble();
            usuario.sacar(valorSaque);
            break;
          case 2:
            System.out.println("Insira o valor que deseja depositar:");
            double valorDeposito = leitor.nextDouble();
            usuario.depositar(valorDeposito);
            break;
          case 3:
            System.out.println(
              "Seu saldo é: R$" + Real.formatar(usuario.saldoAtual())
            );
            break;
          default:
            System.out.println("Selecione uma opção válida!");
        }

        
      }
    } catch(InputMismatchException e) {
      System.out.println("\n" + "-=".repeat(20) + "-\n");
      System.out.println("Você digitou alguma coisa que não é um número!");
      System.out.println("Finalizando programa...");
    } catch (ValorNegativoException e) {
      System.out.println("\n" + "-=".repeat(20) + "-\n");
      System.out.println(e.getMessage());
      System.out.println("Finalizando programa...");
    } catch (EstouroDeLimiteException e) {
      System.out.println("\n" + "-=".repeat(20) + "-\n");
      System.out.println(e.getMessage());
      System.out.println("Finalizando programa...");
    } finally {
      leitor.close();
    }
  }
}

