package exec001;

//  Essa classe é a representação de uma série de televisão.
public class SerieLimitada {
  // Variáveis privadas de instância.
  private String nome;
  private int ano;

  // Variáveis públicas estáticas da classe.
  public static final int MAXIMO_INSTANCIAS = 2;
  public static int total_instancias = 0;

  // Construtor de instância
  public SerieLimitada(String nome, int ano) {
    this.nome = nome;
    this.ano = ano;

    total_instancias++;
  }

  public String getNome() {
    return this.nome;
  }

  public int getAno() {
    return this.ano;
  }
}
