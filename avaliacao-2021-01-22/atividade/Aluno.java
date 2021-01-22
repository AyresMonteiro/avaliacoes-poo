package atividade;

public class Aluno extends Pessoa {
	private int matricula;
	private String curso;

	public Aluno (String nome,
			String cpf,
			int idade,
			String telefone,
			int matricula,
			String curso) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setTelefone(telefone);
		setMatricula(matricula);
		setCurso(curso);
	}

	public int getMatricula() {
		return this.matricula;
	}

	public int setMatricula(int matricula) {
		if (matricula < 0) {
			return -1;
		}

		this.matricula = matricula;

		return 1;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String toString() {
		String dados = "Nome do Aluno: " + this.getNome() + "\n";
		dados += "CPF do Aluno: " + this.getCpf() + "\n";
		dados += "Idade do Aluno: " + this.getIdade() + "\n";
		dados += "Telefone do Aluno: " + this.getTelefone() + "\n";
		dados += "Matricula do Aluno: " + this.getMatricula() + "\n";
		dados += "Curso do Aluno: " + this.getCurso() + "\n";
		return dados;
	}
}

