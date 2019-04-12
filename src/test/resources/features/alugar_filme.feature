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

  @AlugarFilmeSemEstoque
  Cenario: Nao deve alugar um filme sem estoque
    Dado um filme com estoque de 0 unidades
    Quando alugar
    Entao nao sera possivel por falta de estoque
    E o estoque do filme sera 0 unidade

  @PontuacaoPorCategoria
  Cenario: Deve dar condicoes especiais para categoria extendida
    Dado um filme com estoque de 2 unidades
    E que o preco do aluguel seja R$ 4
    E que o tipo do aluguel seja extendido
    Quando alugar
    Entao o preco do aluguel sera R$ 8
    E a data de entrega sera em 3 dias
    E a pontuacao sera de 2 pontos
