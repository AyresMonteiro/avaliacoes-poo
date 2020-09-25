// Crie uma classe Aluno que possui como atributos:
// - Nome
// - 4 notas entre 0 e 100
// Esta classe possui também os métodos:
// - Média: calcula a média das 4 notas do aluno e retorna o valor
// - Maior: acha a maior nota do aluno e retorna o valor
// - Menor: acha a menor nota do aluno e retorna o valor
// - EstaAprovado: retorna true se o aluno for aprovado e false se reprovado (media
// >= 60)


// Após criar essa classe, instancie 3 alunos no método main e atribua suas
// respectivas notas e nomes. Em seguida, para cada aluno, imprima a media, a
// maior e menor nota e se ele está aprovado, juntamente com seu nome.

import java.util.Scanner;

class Aluno {
  String nome;
  float[] notas;

  public Aluno(){
    Scanner leitor = new Scanner(System.in);

    System.out.println("Insira o nome do aluno:");
    this.nome = leitor.next();

    this.notas = new float[4];

    for(int i = 0; i < 4; i++) {
      do {
      System.out.println("Insira a " + (i+1) + "a nota:");
      this.notas[i] = leitor.nextFloat();
      } while(this.notas[i] < 0 || this.notas[i] > 100);
    }
  }

  public float media() {
    return (this.notas[0] + this.notas[1] + this.notas[2] + this.notas[3])/4;
  }

  public float maior() {
    float maiorNota = this.notas[0];
    for(int i = 1; i < 4; i++)
      if(this.notas[i] > maiorNota) maiorNota = this.notas[i];
    return maiorNota;
  }

  public float menor() {
    float menorNota = this.notas[0];
    for(int i = 1; i < 4; i++)
      if(this.notas[i] < menorNota) menorNota = this.notas[i];
    return menorNota;
  }

  public boolean estaAprovado(){
    return this.media() >= 60;
  }
}
