package atividade;

import java.util.ArrayList;

/**
 * FolhaSalarial
 */
public class FolhaSalarial {
  private ArrayList<Funcionario> funcs;
  private int numfuncs;

  //  O exercício tava pedindo pro valor máximo de funcionários ser 10 né
  public static final int NUMFUNCS_MAX = 10;

  public FolhaSalarial() {
    this.funcs = new ArrayList<Funcionario>();
    this.numfuncs = 0;
  }

  public int getNumfuncs() {
    return this.numfuncs;
  }

  public void setNumfuncs(int numfuncs) {
    try {
      if (numfuncs < 0) {
        throw new Exception("Número de funcionarios inválido!");
      }

      if (numfuncs > NUMFUNCS_MAX) {
        throw new Exception("Número de funcionários excedeu o limite!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      numfuncs = this.getNumfuncs();
    } finally {
      this.numfuncs = numfuncs;
    }
  }

  public Funcionario retornaFuncionario(int indice) {
    try {
      if (indice < 0 || indice >= this.getNumfuncs() || indice > NUMFUNCS_MAX) {
        throw new Exception("Índice de funcionário inválido!");
      }

      return this.funcs.get(indice);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  public Funcionario retornaFuncionario(String nome) {
    for (Funcionario funcionario : funcs) {
      if (funcionario.getNome().equals(nome)) {
        return funcionario;
      }
    }

    return null;
  }

  public void addFuncionario(Funcionario func, double salario) {
    try {
      int numFuncs = this.getNumfuncs() + 1;

      if (numfuncs > NUMFUNCS_MAX) {
        throw new Exception("Funcionário não adicionado. Limite (" + NUMFUNCS_MAX + ") excedido");
      }

      func.setSalario(salario);

      this.funcs.add(func);

      this.setNumfuncs(numfuncs);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void imprimeFuncionarios() {
    for (Funcionario funcionario : funcs) {
      System.out.println(funcionario.toString());
    }
  }

  public void imprimeFuncionarios(String departamento) {
    for (Funcionario funcionario : funcs) {
      if (funcionario.getDepartamento().equals(departamento)) {
        System.out.println(funcionario.toString());
      }
    }
  }

  public void imprimeFuncionarios(char inicial) {
    for (Funcionario funcionario : funcs) {
      if (funcionario.getNome().charAt(0) == inicial) {
        System.out.println(funcionario.toString());
      }
    }
  }
}