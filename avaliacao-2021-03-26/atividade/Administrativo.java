package atividade;

/**
 * Administrativo
 */
public class Administrativo extends Funcionario {
  private int anosServico;

  public Administrativo(int anosServico, String cpf, String nome, String departamento) {
    super(cpf, nome, departamento);
    this.setAnosServico(anosServico);
  }

  public int getAnosServico() {
    return this.anosServico;
  }

  @Override
  public String toString() {
    String info = "";

    info += "Tipo: Admnistrativo\n";
    info += super.toString();
    info += "Anos de serviço: " + this.getAnosServico() + "\n";

    return info;
  }

  public void setAnosServico(int anosServico) {
    try {
      if(anosServico < 0) {
        throw new Exception("Anos de trabalho inválidos!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      anosServico = 0;
    } finally {
      this.anosServico = anosServico;
    }
  }

  @Override
  public void setSalario(double salario) {
    //  Fala Thiagão, bão demais?
    //  É o seguinte, esses 2% do enunciao não ficaram tão claros se era só
    //  0.02 vezes os anos de serviço ou 2% do salário vezes os Anos de Serviço.
    //  Como a primeira opção dava um valor mixuruca, resolvi fazer 2% do
    //  salário vezes os anos de serviço mesmo.
    //  No mais, é isso.
    //
    //  Att,
    //  Ayres.

    salario += 0.02 * salario * (double) this.anosServico;

    super.setSalario(salario);
  }
}
