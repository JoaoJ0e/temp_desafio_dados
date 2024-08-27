package desafio_dados.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import desafio_dados.dto.DadoDto;
import desafio_dados.service.DadoService;

@Service
public class DadoServiceImpl implements DadoService{

	private static List<Integer> resultados = new ArrayList<>();
	
	
	@Override
	public void lancarDados(DadoDto dados) {
		
		if (!isQtdValida(dados.getQtd())) {
			//excessao
		}
		
		if (!isApostaValida(dados.getAposta())) {
			//excessao
		}
		
		resultados.clear();
		for (int i = 0; i < dados.getQtd(); i++) {
			resultados.add(new Random().nextInt(6));
		}
		
		Integer somaResultados = resultados.stream().mapToInt(n -> n).sum();
		BigDecimal percAcerto = BigDecimal.valueOf((somaResultados * 100) / dados.getAposta());
		
		
		
	}

	private boolean isQtdValida(Integer qtd) {
		if (qtd >= 1 && qtd <= 4) {
			return true;
		}
		return false;
	}
	
	private boolean isApostaValida(Integer aposta) {
		if (aposta >= 1 && aposta <= 12) {
			return true;
		}
		return false;
	}
	
}
