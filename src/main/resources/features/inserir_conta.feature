#language: pt

@TestaConta
Funcionalidade: Cadastro de contas

  Contexto:
    Dado que estou acessando a aplicacao
    Quando informo o usuario "a@a"
    E a senha "a"
    E seleciono entrar
    Entao visualizo a pagina inicial
    Quando seleciono Contas
    E seleciono Adicionar

  Esquema do Cenario: Deve validar regras cadatro contas
    Quando informo a conta "<conta>"
    E seleciono Salvar
    Entao recebo a mensagem "<mensagem>"

    Exemplos:
      | conta            | mensagem                           |
      | Tiago Nassif     | Conta adicionada com sucesso!      |
      |                  | Informe o nome da conta            |
      | Conta mesmo nome | Já existe uma conta com esse nome! |