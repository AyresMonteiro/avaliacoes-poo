package atividade;

public class Contato {
  private int idPessoa;
  private String nome;
  private String telefone;

  public Contato(int id, String nome, String telefone) {
    this.idPessoa = id;
    this.setNome(nome);
    this.setTelefone(telefone);
  }

  public int getIdPessoa() {
    return this.idPessoa;
  }

  public String getNome() {
    return this.nome;
  }

  public String getTelefoneLimpo() {
    return this.telefone;
  }

  public String getTelefone() {
    try {
      String retorno = "(";
      retorno += this.telefone.substring(0, 2) + ") ";
      retorno += this.telefone.substring(2, 3) + " ";
      retorno += this.telefone.substring(3, 7) + "-";
      retorno += this.telefone.substring(7);

      return retorno;
    } catch (Exception e) {
      return "Erro! " + e.getMessage();
    }
  }

  public static String parseTelefone(String telefone) {
    return telefone.replaceAll("[() -]", "");
  }

  public void setIdPessoa(int id) {
    this.idPessoa = id;
  }

  public void setNome(String nome) {
    if (nome.length() > 0) {
      this.nome = nome;
    } else {
      this.nome = null;
    }
  }

  public void setTelefone(String telefone) {
    telefone = parseTelefone(telefone);
    
    if (telefone.length() == 11) {
      this.telefone = telefone;
    } else {
      this.telefone = null;
    }
  }
}
