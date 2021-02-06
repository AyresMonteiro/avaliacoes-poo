package atividade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainActivity {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);

    int opcao = 5;

    try {
      System.out.println("Digite o nome do proprietario da conta:");
      String nome = leitor.next();
      System.out.println("Digite o seu limite de crédito:");
      double limite = leitor.nextDouble();
      System.out.println("Digite o seu saldo atual:");
      double saldo = leitor.nextDouble();

      ContaBancaria usuario = new ContaBancaria(limite, nome, saldo);

      while (opcao > 0) {
        Thread.sleep(1000);
        System.out.println("\n" + "-=".repeat(20) + "-\n");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Sacar");
        System.out.println("2 - Depositar");
        System.out.println("3 - Ver saldo\n");
        System.out.println("0 - Sair");

        if(leitor.hasNextInt()) {
          opcao = leitor.nextInt();
        } else {
          leitor.next();
          opcao = 5;
        }

        switch (opcao) {
          case 0:
            break;
          case 1:
            usuario.sacar(leitor);
            break;
          case 2:
            usuario.depositar(leitor);
            break;
          case 3:
            usuario.saldoAtual();
            break;
          default:
            System.out.println("Selecione uma opção válida!");
        }
      }
    } catch(InputMismatchException e) {
      System.out.println("\n" + "-=".repeat(20) + "-\n");
      System.out.println("Você digitou alguma coisa que não é um número!");
    } catch (ValorNegativoException e) {
      System.out.println("\n" + "-=".repeat(20) + "-\n");
      System.out.println(e.getMessage());
    } catch (EstouroDeLimiteException e) {
      System.out.println("\n" + "-=".repeat(20) + "-\n");
      System.out.println(e.getMessage());
    } catch (InterruptedException e) {
      System.out.println("Erro de Thread.");
    } finally {
      leitor.close();
      System.out.println("Finalizando programa...");
    }
  }
}
