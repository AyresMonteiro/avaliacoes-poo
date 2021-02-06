package atividade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaBancaria {
  private double limite;
  private String proprietario;
  private double saldo;

  public ContaBancaria(double limite, String proprietario, double saldo) {
    this.limite = limite;
    this.proprietario = proprietario;
    this.saldo = saldo;
  }

  public void depositar(Scanner leitor) throws ValorNegativoException {
    double valor = 0.0;

    try {
      System.out.println("Insira o valor que deseja depositar:");
      valor = leitor.nextDouble();
    } catch (InputMismatchException e) {
      System.out.println("\n" + "-=".repeat(20) + "-\n");
      System.out.println("Você digitou alguma coisa que não é um número!");
      valor = 0;
    } finally {
      if (valor < 0) {
        throw new ValorNegativoException(this.proprietario, valor);
      }

      this.saldo += valor;
    }
  }

  public void sacar(Scanner leitor) throws ValorNegativoException, EstouroDeLimiteException {
    double valor = 0.0;

    try {
      System.out.println("Insira o valor que deseja sacar:");
      valor = leitor.nextDouble();
    } catch (InputMismatchException e) {
      System.out.println("\n" + "-=".repeat(20) + "-\n");
      System.out.println("Você digitou alguma coisa que não é um número!");
      valor = 0;
    } finally {
      if (valor < 0) {
        throw new ValorNegativoException(this.proprietario, valor);
      }

      if (valor > this.limite) {
        throw new EstouroDeLimiteException(this.proprietario, valor, this.limite);
      }

      this.saldo -= valor;
    }
  }

  public void saldoAtual() {
    System.out.println("Seu saldo é: R$" + Real.formatar(this.saldo));
  }
}
