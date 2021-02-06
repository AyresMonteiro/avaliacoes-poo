package atividade;

public class ValorNegativoException extends Exception {
  /**
   *  serialVersionUID gerado por uma extensão do VSCode. Ignore.
   */
  private static final long serialVersionUID = -1850255823762762564L;

  public ValorNegativoException(String proprietario, double valor) {
    super(
      proprietario + ": O valor inserido (R$" + Real.formatar(valor) +
      ") não pode ser menor que zero!"
    );
  }
}
