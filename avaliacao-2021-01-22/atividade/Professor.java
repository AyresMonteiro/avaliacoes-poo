package atividade;

public class Professor extends Pessoa {
	private String formacao;
	private String area;

	public Professor(String nome,
			String cpf,
			int idade,
			String telefone,
			String formacao,
			String area) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setTelefone(telefone);
		setFormacao(formacao);
		setArea(area);
	}

	public String getFormacao() {
		return this.formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String toString() {
		String dados = "Nome do Professor: " + this.getNome() + "\n";
		dados += "CPF do Professor: " + this.getCpf() + "\n";
		dados += "Idade do Professor: " + this.getIdade() + "\n";
		dados += "Telefone do Professor: " + this.getTelefone() + "\n";
		dados += "Formação do Professor: " + this.getFormacao() + "\n";
		dados += "Área do Professor: " + this.getArea() + "\n";
		return dados;
	}

}

