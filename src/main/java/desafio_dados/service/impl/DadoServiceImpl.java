package desafio_dados.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import desafio_dados.dto.ResultadoDto;
import desafio_dados.service.DadoService;

@Service
public class DadoServiceImpl implements DadoService{

	private static List<Integer> resultados = new ArrayList<>();
	
	
	@Override
	public ResultadoDto lancarDados(Integer qtd, Integer aposta) {
		
		
		// Excessões não se tratam assim! Fiz assim porque joga um erro na tela.
		// Preciso ver certinho como jogar uma exceção formalizada.
		if (!isQtdValida(qtd)) {
			return (ResultadoDto) ResponseEntity.status(HttpStatus.FORBIDDEN);
		}
		
		if (!isApostaValida(aposta, qtd)) {
			return (ResultadoDto) ResponseEntity.status(HttpStatus.FORBIDDEN);

		}
		
		resultados.clear();
		for (int i = 0; i < qtd; i++) {
			resultados.add(new Random().nextInt(6));
		}
		
		Integer somaResultados = resultados.stream().mapToInt(n -> n).sum();
		
		// Caso a soma seja maior que a aposta, o resultado será maior que 100%
		BigDecimal percAcerto = BigDecimal.valueOf((somaResultados * 100) / aposta);
		
		return new ResultadoDto(resultados, aposta, percAcerto);
		
	}

	private boolean isQtdValida(Integer qtd) {
		return qtd >= 1 && qtd <= 4;
	}
	
	private boolean isApostaValida(Integer aposta, Integer qtd) {
		return aposta >= 1 * qtd && aposta <= 6 * qtd;
	} 
	
}
