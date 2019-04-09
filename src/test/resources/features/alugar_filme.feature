#language: pt

Funcionalidade: Alugar filme

  Como um usuario
  Eu quero cadastrar alugueis de filmes
  Para controlar preços e datas de entrega

  @AlugarFilme
  Cenario: Deve alugar um filme com sucesso
    Dado um filme com estoque de 2 unidades
    E que o preco do aluguel seja R$ 3
    Quando alugar
    Entao o preco do aluguel sera R$ 3
    E a data de entrega sera no dia seguinte
    E o estoque do filme sera 1 unidade