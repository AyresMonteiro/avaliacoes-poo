//  Os funcionários de uma empresa querem saber quanto receberão de PL
//  (Participação nos Lucros) da Empresa que trabalham! Para obter esse valor, o
//  funcionário precisa preencher algumas informações: cpf e nível empresarial.
//  Se o funcionário não souber o nível empresarial, ele deverá preencher ano de
//  admissão e mês de admissão para obter o nível. O nível empresarial é obtido
//  da seguinte forma:

//  - Se o funcionário está há mais de 30 anos na empresa: nível “ABC”.
//  - Se o funcionário está há mais de 15 anos na empresa: nível “DEF”.
//  - Se o funcionário está há mais de 5 anos na empresa: nível “GHI”.

//  A PL é calculada da seguinte forma:
//  - Se o funcionário é nível “ABC”, ele recebe cinco vezes o salário bruto.
//  - Se o funcionário é nível “DEF”, ele recebe três vezes o salário bruto.
//  - Se o funcionário é nível “GHI”, ele recebe duas vezes o salário bruto.

//  Tarefas:
//  - Método para retornar o nível empresarial: observe os parâmetros de entrada
//    necessários.
//  - Método para calcular a PL: é necessário um método que receba o nível; E
//    outro que receba os dados para obter o nível e posteriormente calcular a
//    PL.
//  - Na classe do método main, instancie objetos do tipo funcionário para
//    testar todas as possibilidades de cálculo de PL e obtenção de nível
//    empresarial.

package atividade;

public class Atividade {
  public static void main(String[] args) {
    // Não vou fazer cálculo de CPF não, sorry
    Funcionario fun1 = new Funcionario("000.000.000-01", "ABC");
    Funcionario fun2 = new Funcionario("000.000.000-02", 2003, 2);
    Funcionario fun3 = new Funcionario("000.000.000-03", 1980, 12);
    Funcionario fun4 = new Funcionario("000.000.000-04", 2016, 12);
    Funcionario fun5 = new Funcionario("000.000.000-05", "");
    Funcionario fun6 = new Funcionario("000.000.000-06", 2015, 7);

    System.out.println(fun1.toString());
    System.out.println(fun2.toString());
    System.out.println(fun3.toString());
    System.out.println(fun4.toString());
    System.out.println(fun5.toString());
    System.out.println(fun6.toString());
  }

}
