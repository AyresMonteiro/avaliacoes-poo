package atividade;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcionario {
  private String cpf;
  private String nome;
  private double salario;
  private String departamento;

  public Funcionario(String cpf, String nome, String departamento) {
    this.setCpf(cpf);
    this.setNome(nome);
    this.setDepartamento(departamento);
  };

  public double getSalario() {
    return this.salario;
  };

  public String getCpf() {
    if (this.cpf == null) {
      return "CPF inválido!";
    }

    String cpf = "";

    cpf += this.cpf.substring(0, 3) + ".";
    cpf += this.cpf.substring(3, 6) + ".";
    cpf += this.cpf.substring(6, 9) + "-";
    cpf += this.cpf.substring(9);

    return cpf;
  };

  public String getDepartamento() {
    if (this.departamento == null) {
      return "Departamento inválido!";
    }

    return this.departamento;
  };

  public String getNome() {
    if (this.nome == null) {
      return "Nome inválido!";
    }

    return this.nome;
  };

  @Override
  public String toString() {
    String info = "";

    info += "Nome: " + this.getNome() + "\n";
    info += "CPF: " + this.getCpf() + "\n";
    info += "Departamento: " + this.getDepartamento() + "\n";
    info += "Salário: " + NumberFormat.getCurrencyInstance().format(this.getSalario()) + "\n";

    return info;
  };

  public void setCpf(String cpf) {
    try {
      Pattern padraoDeCpf = Pattern.compile("(([0-9]){3}[.]?){2}([0-9]){3}-?([0-9]){2}");
      Matcher testadorDeCpf = padraoDeCpf.matcher(cpf);

      if (!testadorDeCpf.matches()) {
        throw new Exception("CPF inválido!");
      }

      cpf = cpf.replaceAll("([.]|-)", "");

      int digitoDez = 0;
      int digitoOnze = 0;

      for (int i = 0, j = 10; i < 9; i++, j--) {
        digitoDez += Integer.parseInt("" + cpf.charAt(i)) * j;
      }

      digitoDez %= 11;
      digitoDez = 11 - digitoDez;

      if (digitoDez >= 10) {
        digitoDez = 0;
      }

      if (cpf.charAt(9) != (char) (digitoDez + '0')) {
        throw new Exception("CPF inválido!");
      }

      for (int i = 0, j = 11; i < 10; i++, j--) {
        digitoOnze += Integer.parseInt("" + cpf.charAt(i)) * j;
      }

      digitoOnze %= 11;
      digitoOnze = 11 - digitoOnze;

      if (digitoOnze >= 10) {
        digitoOnze = 0;
      }

      if (cpf.charAt(10) != (char) (digitoOnze + '0')) {
        throw new Exception("CPF inválido!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      cpf = null;
    } finally {
      this.cpf = cpf;
    }
  };

  public void setDepartamento(String departamento) {
    try {
      Pattern padraoDeDepartamento = Pattern.compile("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,' ]+$");
      Matcher testadorDeDepartamento = padraoDeDepartamento.matcher(departamento);

      if (!testadorDeDepartamento.matches()) {
        throw new Exception("Departamento inválido!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      departamento = null;
    } finally {
      this.departamento = departamento;
    }
  };

  public void setNome(String nome) {
    try {
      Pattern padraoDeNome = Pattern.compile("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,' ]+$");
      Matcher testadorDeNome = padraoDeNome.matcher(nome);

      if (!testadorDeNome.matches()) {
        throw new Exception("Nome inválido!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      nome = null;
    } finally {
      this.nome = nome;
    }
  };

  public void setSalario(double salario) {
    try {
      if (salario < 0.0) {
        throw new Exception("Valor inválido!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      salario = 0.0;
    } finally {
      this.salario = salario;
    }
  };
}