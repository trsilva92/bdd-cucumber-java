package services;

import entity.Filme;
import entity.NotaAluguel;
import utils.DateUtils;

import java.util.Date;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, String tipo) {

        if (filme.getEstoque() == 0)
            throw new RuntimeException("O filme não tem Estoque");

        NotaAluguel nota = new NotaAluguel();
        if ("extendido".equals(tipo)) {
            nota.setPreco(filme.getAluguel() * 2);
            nota.setDataEntrega(DateUtils.obterDataDiferencadias(3));
        } else {
            nota.setPreco(filme.getAluguel());
        }
        nota.setDataEntrega(DateUtils.obterDataDiferencadias(1));
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
