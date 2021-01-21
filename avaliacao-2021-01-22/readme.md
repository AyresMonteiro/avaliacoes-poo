Avaliação à ser entregue dia 22/01/2021.

# Enunciado:

Uma universidade deseja automatizar suas operações e você foi contratado para
desenvolver o sistema que possui os seguintes aspectos. Para o cadastro dos
membros dessa universidade, foi notado que todos estes são pessoas,
generalizados como uma classe **Pessoa** que por sua vez é uma classe
**abstrata**. Para esta generalização, os atributos {**nome**, **cpf**,
**idade**, **telefone**} foram considerados.

Como especializações desta classe Pessoa deve ser implementado duas novas
classes: **Aluno** e **Professor**. Foi notado características exclusivas tanto
para aluno quanto para professor, são elas: {**formação** e **área**} para
Professor e {**matrícula**, **curso**} para Aluno. As classes Professor, Aluno e
Pessoa possuem apenas métodos **construtores**, **getters** e **setters**, visto
que todos os atributos citados para todas as classes são **privados**. Uma nova
classe denominada **Colecao** deve ser criada, esta classe possui um
**ArrayList** do tipo **Pessoa (<Pessoa>)** que guarda todos os membros da
universidade e apresenta um **relacionamento de associação** junto à classe
Pessoa. Lembre-se que o ArrayList de Pessoas também pode armazenar Aluno e
Professor porque eles são Pessoas.

A classe Colecao implementa duas interfaces sendo elas: **Interface1** e
**Interface2.**

	* A Interface1 possui os seguintes métodos: {**adicionar**, **listar** e
	**remover**};
	* A Interface2 possui os seguintes métodos: {**somaIdade** e
	**mediaIdade**}.

As especificações dos métodos das interfaces são como segue:

	* adicionar: recebe uma Pessoa como parâmetro e a adiciona no ArrayList.
	* listar: não possui parâmetros e deve apresentar para todos os objetos
	do ArrayList suas informações, tanto as herdadas da classe pessoa como
	as suas específicas (use toString)
	* remover:
		* remove a última pessoa do array list ou
		* recebe um índice como parâmetro e remove a Pessoa daquele
		índice no ArrayList.
	* somaidade: não possui parâmetros e deve retornar um inteiro com a soma
	de todas as idades das pessoas do ArrayList.
	* mediaIdade: não possui parâmetros e deve retornar um double com a
	média de todas as idades das pessoas do ArrayList.

Na classe principal crie um objeto da classe Colecao e adicione dois alunos e
dois professores. Em seguida teste todas as funcionalidades da classe Coleção.

