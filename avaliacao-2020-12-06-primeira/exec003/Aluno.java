package exec003;

public class Aluno {
  private String nome;
  private Data data_nascimento;

  static int total_alunos = 0;

  // Primeira sobrecarga -> Apenas nome
  public Aluno(String nome) {
    this.nome = nome;

    total_alunos++;
  }

  // Segunda sobrecarga -> nome e data de nascimento
  public Aluno(String nome, Data nascimento) {
    this.nome = nome;
    this.data_nascimento = nascimento;

    total_alunos++;
  }

  @Override
  public String toString() {
    String printString = "Nome: " + this.nome + "\n";

    if (this.data_nascimento != null) {
      printString += "Nascimento: " + this.data_nascimento.toString() + "\n";
    }

    return printString;
  }

}