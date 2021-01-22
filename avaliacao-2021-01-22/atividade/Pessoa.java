package atividade;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private int idade;
	private String telefone;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public int setCpf(String cpf) {
		int size = cpf.length();
		
		if (size != 11) {
			return -1;
		}

		int[] digits = new int[2];
		int[] numbers = new int[11];
		int sum = 0;

		for (int i = 0; i < 11; i++) {
			numbers[i] = cpf.charAt(i) - '0';
		}

		for (int i = 0; i < 9; i++) {
			sum += numbers[i] * (10 - i);
		}
		
		digits[0] = 11 - (sum % 11);
		digits[0] = digits[0] >= 10 ? 0 : digits[0];

		if(digits[0] != numbers[9]) {
			return -1;
		}
		
		sum = 0;

		for (int i = 0; i < 10; i++) {
			sum += numbers[i] * (11 - i);
		}

		digits[1] = 11 - (sum % 11);
		digits[1] = digits[1] >= 10 ? 0 : digits[1];
		
		if (digits[1] != numbers[10]) {
			return -1;
		}

		this.cpf = cpf;
		
		return 1;
	}

	public int getIdade() {
		return this.idade;
	}

	public int setIdade(int idade) {
		if (idade < 0) {
			return -1;
		}

		this.idade = idade;

		return 1;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

