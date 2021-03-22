package atividade;

import java.text.NumberFormat;

/**
 * Vendedor
 */
public class Vendedor extends Funcionario {
  private double taxaComissao;
  private double valorVendido;

  public Vendedor(double taxaComissao, double valorVendido, String cpf, String nome, String departamento) {
    super(cpf, nome, departamento);
    this.setTaxaComissao(taxaComissao);
    this.setValorVendido(valorVendido);
  }

  public double getTaxaComissao() {
    return this.taxaComissao;
  }

  public double getValorVendido() {
    return this.valorVendido;
  }

  @Override
  public String toString() {
    String info = "";

    info += "Tipo: Vendedor\n";
    info += super.toString();
    info += "Taxa de comissão: " + NumberFormat.getPercentInstance().format(this.getTaxaComissao()) + "\n";
    info += "Valor vendido: " + NumberFormat.getCurrencyInstance().format(this.getValorVendido()) + "\n";

    return info;
  }

  @Override
  public void setSalario(double salario) {
    salario += this.valorVendido * this.taxaComissao;

    super.setSalario(salario);
  }

  public void setTaxaComissao(double taxaComissao) {
    try {
      if (taxaComissao < 0.0) {
        throw new Exception("Taxa de comissão inválida!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      taxaComissao = 0.0;
    } finally {
      this.taxaComissao = taxaComissao;
    }
  }

  public void setValorVendido(double valorVendido) {
    try {
      if (valorVendido < 0.0) {
        throw new Exception("Valor vendido inválido!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      valorVendido = 0.0;
    } finally {
      this.valorVendido = valorVendido;
    }
  }
}
