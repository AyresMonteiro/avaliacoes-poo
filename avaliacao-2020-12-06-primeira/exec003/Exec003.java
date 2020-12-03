//  Crie uma classe chamada Aluno que contenha os atributos privados nome,
//  data_nascimento e um atributo estático chamado total_alunos.

//  A. Crie o tipo Data para a data de nascimento, com os campos dia, mês e ano.

//  B. Crie o construtor a seguir para o tipo Data:
//  public Data (int dia_nascimento, int mes_nascimento, int ano_nascimento)

//  C. Crie 2 construtores em Aluno: um que necessita apenas do nome do aluno e
//  outro do nome e nascimento. Independentemente do construtor usado, a cada
//  instância criada, deve-se incrementar o atributo total_alunos.

//  D. No programa principal, crie os alunos a seguir:

//  Nome: Juca
//  Nascimento: 01/03/2000

//  Nome: Ana

//  Nome: Maria
//  Nascimento: 10/05/2010

//  Imprima o total de alunos criados e os dados deles. Criar um método toString
//  em Alunos para imprimir todos os seus dados pode facilitar.

//  ----------------------------------------------------------------------------

package exec003;

public class Exec003 {
  public static void main(String[] args) {
    Aluno juca = new Aluno("Juca", new Data(1, 3, 2000));
    Aluno ana = new Aluno("Ana");
    Aluno maria = new Aluno("Maria", new Data(10, 5, 2010));

    System.out.println("\nTotal de alunos: " + Aluno.total_alunos + "\n");
    System.out.println(juca.toString());
    System.out.println(ana.toString());
    System.out.println(maria.toString());
  }
}
