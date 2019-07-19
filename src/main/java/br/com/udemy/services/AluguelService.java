package br.com.udemy.services;

import br.com.udemy.entity.Filme;
import br.com.udemy.entity.NotaAluguel;
import br.com.udemy.entity.TipoAluguel;
import br.com.udemy.utils.DateUtils;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {

        if (filme.getEstoque() == 0)
            throw new RuntimeException("O filme não tem Estoque");

        NotaAluguel nota = new NotaAluguel();
        switch (tipo) {
            case COMUM:
                nota.setPreco(filme.getAluguel());
                nota.setDataEntrega(DateUtils.obterDataDiferencadias(1));
                nota.setPontuacao(1);
                break;
            case EXTENDIDO:
                nota.setPreco(filme.getAluguel() * 2);
                nota.setDataEntrega(DateUtils.obterDataDiferencadias(3));
                nota.setPontuacao(2);
                break;
            case SEMANAL:
                nota.setPreco(filme.getAluguel() * 3);
                nota.setDataEntrega(DateUtils.obterDataDiferencadias(7));
                nota.setPontuacao(3);
        }

        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
