package atividade;

import java.util.ArrayList;

public class Colecao implements Interface1, Interface2 {
	private ArrayList<Pessoa> pessoas;
	
	public Colecao() {
		this.pessoas = new ArrayList<Pessoa>();
	}

	public void adicionar(Pessoa pessoa){
		this.pessoas.add(pessoa);
	}

	public void remover() {
		this.pessoas.remove(pessoas.size() - 1);
	}

	public void remover(int indice) {
		this.pessoas.remove(indice);
	}

	public void listar() {
		for (Pessoa pessoa : this.pessoas) {
			System.out.println(pessoa.toString());
		}
	}

	public int somaIdade() {
		int soma = 0;
		for (Pessoa pessoa : this.pessoas) {
			soma += pessoa.getIdade();
		}
		return soma;
	}

	public double mediaIdade() {
		return this.somaIdade() / this.pessoas.size();
	}
}

