package services;

import entity.Filme;
import entity.NotaAluguel;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme) {
        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAluguel());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        nota.setDataEntrega(cal.getTime());
        return nota;
    }
}
