Avaliação à ser entregue dia 06/02/2021.

# Enunciado:

Implemente uma classe **ContaBancaria**. Esta classe deve ter como atributo
interno a informação sobre o **saldo** da ContaBancaria (considere um valor
double), o **nome do proprietário** da conta e um **limite de crédito**.
Implemente, além do método **construtor**, um método **Depositar**, um método
**Sacar** e um método para **informar o saldo atual**.

Garanta, utilizando o mecanismo de exceção, que não será depositado um valor
negativo na conta para depósito, criando e usando a exceção
**valorNegativoException**.

Já para o método sacar, garanta que não seja retirado um valor além do limite da
conta criando um **EstouroDeLimiteException** e, também, que não seja informado
um saque negativo, utilizando a **valorNegativoException**, criado
anteriormente. Você pode usar múltiplos catchs para isso, como visto em sala de
aula.

No método **main**, crie uma conta bancária e simule as operações que disparam
as exceções criadas. Os valores de saque e depósito **devem ser recebidos do
teclado**. Quando recebê-los, verifique se o que foi digitado é realmente um
número usando a exceção **InputMismatchException**. Se a exceção for disparada
então transforme o valor recebido para zero.
