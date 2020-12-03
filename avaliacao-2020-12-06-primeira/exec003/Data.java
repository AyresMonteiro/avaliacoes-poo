package exec003;

public class Data {
  private int dia, mes, ano;

  public Data(int dia_nascimento, int mes_nascimento, int ano_nascimento) {
    this.dia = dia_nascimento;
    this.mes = mes_nascimento;
    this.ano = ano_nascimento;
  }

  @Override
  public String toString() {
    String dia = this.dia < 10 ? "0" + this.dia : "" + this.dia;
    String mes = this.mes < 10 ? "0" + this.mes : "" + this.mes;

    return dia + "/" + mes + "/" + this.ano;
  }
}
