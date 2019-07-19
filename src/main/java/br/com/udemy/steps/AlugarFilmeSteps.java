package br.com.udemy.steps;

import br.com.udemy.entity.Filme;
import br.com.udemy.entity.NotaAluguel;
import br.com.udemy.entity.TipoAluguel;
import br.com.udemy.services.AluguelService;
import br.com.udemy.utils.DateUtils;
import cucumber.api.java.pt.*;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel notaAluguel;
    private String erro;
    private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

    @Dado("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
        filme = new Filme();
        filme.setEstoque(arg1);
    }

    @E("^que o preco do aluguel seja R\\$ (\\d+)$")
    public void queOPrecoDoAluguelSejaR$(int arg1) throws Throwable {
        filme.setAluguel(arg1);
    }

    @E("^que o tipo do aluguel seja (.*)$")
    public void que_o_tipo_do_aluguel_seja(String tipo) throws Throwable {
        tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL:
                      tipo.equals("extendido") ? TipoAluguel.EXTENDIDO:
                      TipoAluguel.COMUM;
    }

    @Quando("^alugar$")
    public void alugar() throws Throwable {
        try {
            notaAluguel = aluguel.alugar(filme, tipoAluguel);
        } catch (Exception e) {
            erro = e.getMessage();
        }
    }

    @Entao("^o preco do aluguel sera R\\$ (\\d+)$")
    public void oPrecoDoAluguelSeraR$(int arg1) throws Throwable {
        Assert.assertEquals(arg1, notaAluguel.getPreco());
    }

    @E("^a data de entrega sera no dia seguinte$")
    public void aDataDeEntregaSeraNoDiaSeguinte() throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        Date retorno = notaAluguel.getDataEntrega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(retorno);

        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
        Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
    }

    @E("^a pontuacao sera de (\\d+) pontos$")
    public void aPontuacaoSeraDePontos(int arg1) throws Throwable {
        notaAluguel.setPontuacao(arg1);
    }


    @Então("^nao sera possivel por falta de estoque$")
    public void naoSeraPossivelPorFaltaDeEstoque() throws Throwable {
        Assert.assertEquals("O filme não tem Estoque", erro);
    }

    @Então("^o estoque do filme sera (\\d+) unidade$")
    public void oEstoqueDoFilmeSeraUnidade(int arg1) throws Throwable {
        Assert.assertEquals(arg1, filme.getEstoque());
    }

    @Entao("^a data de entrega sera em (\\d+) dias$")
    public void aDataDeEntregaSeraEmDias(int arg1) throws Throwable {
        Date dataEsperada = DateUtils.obterDataDiferencadias(arg1);
        Date dataReal = notaAluguel.getDataEntrega();
        DateFormat format = new SimpleDateFormat("dd/MM/yyy");
        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }
}
