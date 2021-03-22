package atividade;

import java.util.ArrayList;

public class Principal {
  public static void main(String[] args) {
    FolhaSalarial f = new FolhaSalarial();
    String divisor = "-=-".repeat(10);
    ArrayList<Funcionario> funcs = new ArrayList<Funcionario>();

    //  Opa Thiagão, bão?
    //  É o seguinte, eu não sei se os CPFs do enunciado eram reais, mas eu
    //  espero que não sejam.
    //  Esses daqui eu gerei com o site https://www.4devs.com.br/gerador_de_cpf.
    //
    //  Eu percebi que no enunciado você mandou criar um ArrayList
    //  (ou um simples Vetor) na classe Principal, então cá está o ArrayList.
    //
    //  Ps: Fiquei com medo de perder ponto por não criar o Array na main.
    //
    //  Att,
    //  Ayres.

    funcs.add(new Vendedor(0.5, 100.0, "59021214008", "Thiago", "DevOps"));
    funcs.add(new Vendedor(0.9, 500.0, "741.813.590-42", "Arthur", "Software"));
    funcs.add(new Administrativo(10, "88517036042", "Samuel", "Software"));
    funcs.add(new Administrativo(5, "36532771082", "Samantha", "Hardware"));
    funcs.add(new Administrativo(30, "368.792.110-70", "Estevão Empregos", "DevOps"));

    f.addFuncionario(funcs.get(0), 2000.0);
    f.addFuncionario(funcs.get(1), 1500.0);
    f.addFuncionario(funcs.get(2), 3000.0);
    f.addFuncionario(funcs.get(3), 6000.0);
    f.addFuncionario(funcs.get(4), 15000.0);

    System.out.println(divisor);
    System.out.println("Todos os " + f.getNumfuncs() + " funcionários:\n");

    // Listando todos os funcionários:
    f.imprimeFuncionarios();

    System.out.println(divisor);
    System.out.println("Funcionários do departamento de Software:\n");

    // Listando todos os funcionários do departamento de Software
    f.imprimeFuncionarios("Software");

    System.out.println(divisor);
    System.out.println("Funcionários com inicial S:\n");

    // Listando todos os funcionários cuja inicial é a letra S
    f.imprimeFuncionarios('S');

    System.out.println(divisor);
  }
}
