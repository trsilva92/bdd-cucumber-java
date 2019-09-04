#language: pt

@AprenderCucumber
Funcionalidade: Aprender Cucumber
  Como um aluno
  Eu quero aprender a utilizar Cucumber
  Para que eu possa automatizar critérios de aceitação

  Cenario: Deve executar especificacao
    Dado que criei o arquivo corretamente
    Quando executa-lo
    Entao a especificacao deve finalizar com sucesso

  @ID01
  Cenario: Deve incrementar contador
    Dado que o valor do contador e 15
    Quando eu incrementar em 5
    Entao o valor do contador sera 20

  @ID02
  Cenario: Deve incrementar contador
    Dado que o valor do contador e 123
    Quando eu incrementar em 35
    Entao o valor do contador sera 158

  @ID03
  Cenario: Deve calcular atraso na entrega
    Dado que a entrega é dia 05/04/2018
    Quando a entrega atrasar em 2 dias
    Entao a entrega sera efetuada em 07/04/2018

  @ID04
  Cenario: Deve calcular atraso no prazo de entrega da China
    Dado que a entrega é dia 05/04/2018
    Quando a entrega atrasar em 2 meses
    Entao a entrega sera efetuada em 05/06/2018

  @ID05
  Cenario: Deve criar steps genericos para estes passos
    Dado que o ticket é AF345
    Dado que o valor da passagem é R$ 230,45
    Dado que o nome do passageiro é "Tiago Ribeiro"
    Dado que o telefone do passageiro é 99842-6727
    Quando criar os steps
    Entao o teste vai funcionar

  @ID06
  Cenario: Deve reaproveitar os steps "Dado" do cenario anterior
    Dado que o ticket é AB167
    Dado que o ticket especial é AB167
    Dado que o valor da passagem é R$ 1120,23
    Dado que o nome do passageiro é "Danielle Pozzi"
    Dado que o telefone do passageiro é 99388-1818



