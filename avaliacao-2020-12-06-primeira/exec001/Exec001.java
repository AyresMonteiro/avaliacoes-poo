//  Exercício 001:
//  Crie uma classe chamada SerieLimitada que possui um atributo privado chamado
//  nome, que representa o nome da série de TV e um atributo privado ano, que
//  armazena o ano de seu lançamento.

//  A. O número total de instâncias permitido por essa classe é controlado pelo
//  campo MAXIMO_INSTANCIAS, declarado como public static final, e o número de
//  instâncias já criadas é controlado pelo campo público total_instancias.

//  B. Escreva uma aplicação em que o usuário possa criar instâncias dessa
//  classe até o limite permitido. Utilize um vetor para armazenamento das
//  instâncias criadas.

//  C. Ao final, exiba o nome e o ano de todas as séries que foram criadas.

//  ----------------------------------------------------------------------------

//  A partir daqui as anotações tem a ver com a minha percepção sobre o
//  exercício.

package exec001;

import java.util.ArrayList;
import java.util.Scanner;

public class Exec001 {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    Scanner leitor2 = new Scanner(System.in).useDelimiter("\n");

    ArrayList<SerieLimitada> series = new ArrayList<SerieLimitada>();
    int escolha = 0;
    do {
      System.out.println("\nMenu:");
      System.out.println("1 - Adicionar nova série.");
      System.out.println("2 - Imprimir séries e fechar o programa.\n");

      escolha = leitor.nextInt();

      if (escolha == 1) {
        if (SerieLimitada.total_instancias < SerieLimitada.MAXIMO_INSTANCIAS) {
          System.out.print("Insira o nome da série: ");
          String nome = leitor2.next();
          System.out.print("Insira o ano da série: ");
          int ano = leitor.nextInt();
          series.add(new SerieLimitada(nome, ano));
        } else {
          System.out.println("Erro: Número máximo de instâncias excedido.");
        }
      } else if (escolha == 2) {
        break;
      }
    } while (true);

    for (SerieLimitada serie : series) {
      System.out.println("Nome: " + serie.getNome());
      System.out.println("Ano: " + serie.getAno() + "\n");
    }

    leitor.close();
    leitor2.close();
  }
}
