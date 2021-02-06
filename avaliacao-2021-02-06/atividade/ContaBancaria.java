package atividade;

public class ContaBancaria {
  private double limite;
  private String proprietario;
  private double saldo;

  public ContaBancaria(double limite, String proprietario, double saldo) {
    this.limite = limite;
    this.proprietario = proprietario;
    this.saldo = saldo;
  }

  public void depositar(double valor) throws ValorNegativoException {
    if(valor < 0) {
      throw new ValorNegativoException(this.proprietario, valor);
    }

    this.saldo += valor;
  }

  public void sacar(double valor) throws ValorNegativoException, EstouroDeLimiteException {
    if(valor < 0) {
      throw new ValorNegativoException(this.proprietario, valor);
    }

    if(valor > this.limite) {
      throw new EstouroDeLimiteException(this.proprietario, valor, this.limite);
    }

    this.saldo -= valor;
  }

  public double saldoAtual() {
    return this.saldo;
  }
}
