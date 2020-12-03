//  Crie uma classe que contenha três métodos estáticos e sobrecarregados para
//  retornar o maior de dois, três e quatro números inteiros.

//  A. Os métodos devem ser ’chamados’ em cascata, por exemplo: para calcular o
//  maior de três valores a, b e c, pode-se calcular o maior valor de a e b, e
//  comparar este resultado com c.

//  B. Na classe principal, permita que o usuário escolha quantos valores ele
//  deseja comparar e digite os mesmos. Após isto, exiba o maior entre os
//  valores digitados, utilizando os métodos criados.

//  ----------------------------------------------------------------------------

//  A partir daqui as anotações tem a ver com a minha percepção sobre o
//  exercício.

package exec002;

import java.util.ArrayList;
import java.util.Scanner;

public class Exec002 {
  // Primeira sobrecarga de método: dois números.
  public static int maior(int n1, int n2) {
    return n1 > n2 ? n1 : n2;
  }

  // Segunda sobrecarga de método: três números.
  public static int maior(int n1, int n2, int n3) {
    int nr = maior(n1, n2);
    return nr > n3 ? nr : n3;
  }

  // Terceira sobrecarga de método: quatro números.
  public static int maior(int n1, int n2, int n3, int n4) {
    int nr = maior(n1, n2, n3);
    return nr > n4 ? nr : n4;
  }

  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);

    ArrayList<Integer> numeros = new ArrayList<Integer>();

    System.out.print("Insira a quantidade de números que deseja comparar: ");

    int n = leitor.nextInt();

    System.out.println("Insira os números:");
    for (int i = 0; i < n; i++) {
      numeros.add(leitor.nextInt());
    }

    int maiorNumero = numeros.get(0);

    for (int i = 0; i < n / 4; i++) {
      int maiorTemporario = maior(
        numeros.get(i * 4),
        numeros.get(i * 4 + 1),
        numeros.get(i * 4 + 2),
        numeros.get(i * 4 + 3)
      );

      maiorNumero = maior(maiorNumero, maiorTemporario);
    }

    switch (n % 4) {
      case 1:
        maiorNumero = maior(maiorNumero, numeros.get(n - 1));
        break;
      case 2:
        maiorNumero = maior(
          maiorNumero,
          numeros.get(n - 1),
          numeros.get(n - 2)
        );
        break;
      case 3:
        maiorNumero = maior(
          maiorNumero,
          numeros.get(n - 1),
          numeros.get(n - 2),
          numeros.get(n - 3)
        );
        break;
    }

    System.out.println("\nMaior número: " + maiorNumero);

    leitor.close();
  }
}
