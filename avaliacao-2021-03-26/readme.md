Avaliação à ser entregue dia 26/03/2021.

---

# Instruções:

Marque como executáveis os arquivos

    downloadLib.sh
    compile.sh
    run.sh
    build.sh

e use o seguinte comando dentro da pasta "avaliacao-2021-03-26":
> `./build.sh`

A partir daí, é possível rodar o programa usando, ainda na mesma pasta o comando:
> `./run.sh` 

---

# Enunciado:

1. Considere uma empresa que necessite de um sistema para cálculo de folha salarial. Ela possui 2 tipos de empregados:

    - Administrativo geral em que é necessário guardar o cpf, nome, salário,
    departamento e tempo de serviço;

    - Vendedor em que é necessário guardar o cpf, nome, salário, departamento,
    taxa de comissão e valor vendido.

2. Tendo em vista este cenário, crie uma aplicação que permita o cadastro de funcionários (até 10) e a exibição de uma lista de funcionários. Você deve respeitar as seguintes regras:

    - (4 pontos) O salário tem um funcionamento diferente para cada tipo de
    funcionário. Sempre que o salário for setado (via setSalario) ele deve seguir
    a seguinte lógica:

        + Vendedores o salario = salário + (valor vendido x taxa de comissão).

        + Administrativo o salario = salário + (2% x tempo de serviço).
        
        + Obs: os salários não devem ser setados no construtor e sim com
        setSalario().
	
	Você deve sobrescrever setSalario() da super classe.
  
   	- (4 pontos) Já o método imprimeFuncionarios tem 3 comportamentos distintos:

		+ Ou ele exibe os dados de todos os funcionários;

		+ Ou ele exibe os dados dos funcionários de um setor especı́fico;
		
		+ ou ele exibe os dados dos funcionarios cujos nomes começam com
		determinada inicial.

	- (2 pontos) Na classe principal, crie um vetor ou array list com no mı́nimo
	5 empregados e imprima:

		+ Dados de todos os empregados;

		+ Dados dos funcionários de um setor a sua escolha;
		
		+ Dados dos funcionários que começam com uma letra a sua escolha.

---

# Dicas

1. Use a função suaString.chatAt(0) para avaliar a inicial de um nome;

2. Use a função suaString.equals(String entrada) para comparar se sua string e a string de entrada são iguais;

3. Não se esqueça do super para acessar variáveis e métodos da supe classe (ex: super.metodo() e super() para construtor).

4. É obrigatório o uso de polimorfismo de sobreposição e sobrecarga.

---

# Classes

## Funcionario

#### Atributos

```Java
- String cpf

- String nome

- double salario

- String departamento
```

#### Métodos

```Java
- Funcionario(String cpf, String nome, String departamento)

- double getSalario()

- String getCpf()

- String getDepartamento()

- String getNome()

- String toString()

- void setCpf(String cpf)

- void setDepartamento(String departamento)

- void setNome(String nome)

- void setSalario(double salario)
```

---

## Administrativo
**Estende Funcionario**

#### Atributos

```Java
- int anosServico
```

#### Metódos

```Java
- Administrativo(int anosServico, String cpf, String nome, String departamento)

- int getAnosServico()

- String toString()

- void setAnosServico(int anosServico)

- void setSalario(double salario)
```

---

## Vendedor
**Estende Funcionario**

#### Atributos

```Java
- double taxaComissao
- double valorVendido
```

#### Métodos

```Java
- Vendedor(double taxaComissao, double valorVendido, String cpf, String nome, String departamento)

- double getTaxaComissao()

- double getValorVendido()

- String toString()

- void setSalario(double salario)

- void setTaxaComissao(double taxaComissao)

- void setValorVendido(double valorVendido)
```

---

## FolhaSalarial

#### Atributos

```Java
- Funcionario[] funcs

- int numfuncs
```

#### Métodos

```Java
- FolhaSalarial()

- int getNumfuncs()

- void setNumfuncs(int numfuncs)

- Funcionario retornaFuncionario(int indice)

- Funcionario retornaFuncionario(String nome)

- void addFuncionario(Funcionario func, double salario)

- void imprimeFuncionarios()

- void imprimeFuncionarios(String departamento)

- void imprimeFuncionarios(char inicial)
```

---

## Principal

#### Métodos

```Java
- public static void main(String[] args)
```

---

# Exemplo de Método Main

```Java
public static void main(String[] args) {
    FolhaSalarial f = new FolhaSalarial();

    f.addFuncionario(new Vendedor(0.5, 100.0, "59021214008", "Thiago", "Vendas"), 2000.0);
    f.addFuncionario(new Administrativo(10, "88517036042", "Samuel", "Informática"), 3000.0);

    f.imprimeFuncionarios();
}
```