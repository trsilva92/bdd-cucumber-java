package br.com.udemy.steps;

import br.com.udemy.converters.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import java.util.Calendar;
import java.util.Date;

public class AprenderCucumberSteps {

    @Dado("^que criei o arquivo corretamente$")
    public void queCrieiOArquivoCorretamente() throws Throwable {

    }

    @Quando("^executa-lo$")
    public void executaLo() throws Throwable {

    }

    @Entao("^a especificacao deve finalizar com sucesso$")
    public void aEspecificacaoDeveFinalizarComSucesso() throws Throwable {

    }

    private int contador = 0;

    @Dado("^que o valor do contador e (\\d+)$")
    public void queOValorDoContadorE(int arg1) throws Throwable {
        contador = arg1;

    }

    @Quando("^eu incrementar em (\\d+)$")
    public void euIncrementarEm(int arg1) throws Throwable {
        contador = contador + arg1;

    }

    @Entao("^o valor do contador sera (\\d+)$")
    public void oValorDoContadorSera(int arg1) throws Throwable {
        System.out.println(arg1);
        System.out.println(contador);

        Assert.assertTrue(arg1 == contador);
        Assert.assertEquals(arg1, contador);
    }

    Date entrega = new Date();

    @Dado("^que a entrega é dia (.*)$")
    public void queAEntregaEDia(@Transform(DateConverter.class) Date data) throws Throwable {
        entrega = data;
    }

    @Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
    public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);

        if (tempo.equals("dias")) {
            cal.add(Calendar.DAY_OF_MONTH, arg1);
        } else if (tempo.equals("meses")) {
            cal.add(Calendar.MONTH, arg1);
        }
        entrega = cal.getTime();

    }


    @Entao("^a entrega sera efetuada em (.*)$")
    public void aEntregaSeraEfetuadaEm(@Transform(DateConverter.class) Date data) throws Throwable {
        entrega = data;
    }

    @Dado("^que o ticket( especial)? é (A.\\d{3})$")
    public void queOTicketÉAF(String tipo, String arg1) throws Throwable {
    }

    @Dado("^que o valor da passagem é R\\$ (.*)$")
    public void queOValorDaPassagemÉR$(Double numero) throws Throwable {
        System.out.println(numero);
    }

    @Dado("^que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroÉ(String arg1) throws Throwable {
    }

    @Dado("^que o telefone do passageiro é (9\\d{4}-\\d{4})$")
    public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable {
    }

    @Quando("^criar os steps$")
    public void criarOsSteps() throws Throwable {
    }

    @Entao("^o teste vai funcionar$")
    public void oTesteVaiFuncionar() throws Throwable {
    }
}
