package atividade;

public class Funcionario {
  private String cpf;
  private String nivel_empresarial;
  private int ano_admissao, mes_admissao;

  // Primeira sobrecarga -> cpf e nivel_empresarial
  public Funcionario(String cpf, String nivel_empresarial) {
    this.cpf = cpf;
    this.nivel_empresarial = nivel_empresarial;
  }

  // Segunda sobrecarga -> cpf, ano_admissao e mes_admissao
  public Funcionario(String cpf, int ano_admissao, int mes_admissao) {
    this.cpf = cpf;
    this.ano_admissao = ano_admissao;
    this.mes_admissao = mes_admissao;
    this.nivel_empresarial = this.calcularNivel();
  }

  public String calcularNivel() {
    // Eu poderia muito bem fazer um método que usa Date e etc. para comparar
    // as datas, porém não vou pelos seguintes motivos: o Date do Java tá
    // abandonado tem um tempo pela Oracle e envolve um certo número de linhas
    // de código para implementar (não tantas, mas o suficiente para eu ter
    // preguiça). Além disso, eu não teria o número exato de meses, mas apenas
    // uma aproximação, já que os meses podem possuir de 28 à 31 dias, mais o
    // cálculo de ano bissexto, nossa, que ódio só de pensar.

    // Então vou só usar uma subtraçãozinha simples com o ano e o mês atual e é
    // isso aí. #fé

    int mesAtual = 12;
    int anoAtual = 2020;

    // Se o funcionário entrou na empresa em 07/2005, então ele completa 15
    // anos de empresa em 07/2020, antes disso só 14

    int anos = anoAtual - this.ano_admissao;
    if (mesAtual < this.mes_admissao)
      anos--;

    if (anos >= 30)
      return "ABC";
    if (anos >= 15)
      return "DEF";
    if (anos >= 5)
      return "GHI";

    return "";
  }

  public String calcularPL() {
    String pl = "Esse funcionário não recebe PL!";
    String nivel = this.nivel_empresarial;

    if (nivel == "")
      return pl;

    if (nivel == "ABC")
      pl = "cinco vezes";
    if (nivel == "DEF")
      pl = "três vezes";
    if (nivel == "GHI")
      pl = "duas vezes";

    return "Sua PL terá o valor de " + pl + " o seu salário!";
  }

  @Override
  public String toString() {
    String funcionario = "CPF: " + this.cpf + "\n";
    funcionario += "PL: " + this.calcularPL() + "\n";

    return funcionario;
  }
}
