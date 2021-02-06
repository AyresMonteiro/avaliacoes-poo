package atividade;

public class EstouroDeLimiteException extends Exception {
  /**
   * serialVersionUID gerado por uma extensão do VSCode. Ignore.
   */
  private static final long serialVersionUID = 5625061451505547877L;

  public EstouroDeLimiteException(String proprietario, double valor, double limite) {
    super(
      proprietario +
      ": Valor de saque (R$" +
      Real.formatar(valor) +
      ") excedeu o limite de crédito (R$" +
      Real.formatar(limite) +
      ") disponível!"
    );
  }
}
