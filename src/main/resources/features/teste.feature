#language: pt
Funcionalidade: Cadastro de Contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de forma mais organizada

  Cenário: Deve inserir uma conta com sucesso
    Dado que estou acessando a aplicacao
    Quando informo o usuario "<trsilva93>"
    E a senha "<opsopsops1>"
    E seleciono entrar
    Entao visualizo a pagina inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E informo a conta "Conta de Teste"
    E seleciono salvar
    Entao a conta e inserida com sucesso

  Cenario: Nao deve inserir uma conta sem nome
    Dado que estou acessando a aplicacao
    Quando informo o usuario "<trsilva93>"
    E a senha "<opsopsops1>"
    E seleciono entrar
    Entao visualizo a pagina inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E seleciono Salvar
    Então sou notificar que o nome da conta e obrigatorio

  Cenario: Nao deve inserir uma conta do nome ja existente
    Dado que estou acessando a aplicacao
    Quando informo o usuario "<trsilva93>"
    E a senha "<opsopsops1>"
    E seleciono entrar
    Entao visualizo a pagina inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E informo a conta "Conta de Teste"
    E seleciono Salvar
    Entao sou notificado que ja existe uma conta com esse nome
