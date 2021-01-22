package atividade;

public class Principal {
	public static void main(String[] args) {
		Colecao colecao = new Colecao();
		Aluno ayres = new Aluno("Ayres Monteiro",
				"55735184610",
				17,
				"imagina um telefone aqui",
				1,
				"Informática, lógico");
		Aluno will = new Aluno("William Raimundo",
				"67520084264",
				18,
				"Imagina outro telefone aqui",
				2,
				"Mecânica porque sim");
		Professor thiago = new Professor("Thiago Guarnieri",
				"33514484147",
				27, // Se você envelheceu ou ficou mais novo,
				// problema seu
				"mais um esqueminha de telefone",
				"nao sei sua formação, fala aí",
				"Ciências Exatas e da Terra");
		Professor gabi = new Professor("Gabi Nome Grande",
				"05865258583",
				30,
				"telefone imaginário irraaaa",
				"não lembro ;-;",
				"Ciências Exatas e da Terra");
		colecao.adicionar(ayres);
		colecao.adicionar(will);
		colecao.listar();
		System.out.println("---");
		colecao.remover(0);
		colecao.listar();
		System.out.println("---");
		colecao.adicionar(gabi);
		colecao.adicionar(thiago);
		colecao.listar();
		System.out.println("---");
		colecao.remover();
		colecao.listar();
		System.out.println("---");
		System.out.println("A soma das idades é: " + colecao.somaIdade());
		System.out.println("A média das idades é: " +
				colecao.mediaIdade());
	}
}

