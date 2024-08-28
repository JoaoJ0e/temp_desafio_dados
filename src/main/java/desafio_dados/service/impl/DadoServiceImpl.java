package desafio_dados.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import desafio_dados.dto.ResultadoDto;
import desafio_dados.service.DadoService;

@Service
public class DadoServiceImpl implements DadoService{
	
	@Override
	public ResponseEntity<?> lancarDados(Integer qtd, Integer aposta) {
		
		List<Integer> resultados = new ArrayList<>();
		
		validaRequisicao(qtd, aposta); // TODO: consertar
				
		Random r = new Random();
		
		Integer somaResultados = 0;
		for (int i = 0; i < qtd; i++) {
			Integer lancamento = r.nextInt(1,7);
			resultados.add(lancamento);
			somaResultados += lancamento;
		}
		
		
		/*
		 * CALCULO DO PERCENTUAL DE ACERTO
		 * -> Inverte a lógica caso a soma > aposta para garantir um resultado preciso
		 */
		BigDecimal percAcerto = null;
		if (somaResultados <= aposta) {
			percAcerto = bof(somaResultados * 100).divide(bof(aposta));
		} else {
			if (somaResultados == 0) {
				somaResultados = 1;
			}
			percAcerto = BigDecimal.valueOf(aposta * 100).divide(BigDecimal.valueOf(somaResultados));
		}
		
		return ResponseEntity.ok(new ResultadoDto(resultados, somaResultados, aposta, percAcerto));
		
	}

	
	private BigDecimal bof(Integer i) {
		return BigDecimal.valueOf(i);
	}
	
	
	private void validaRequisicao(Integer qtdDados, Integer aposta) {
		validaQtdDados(qtdDados);
		validaAposta(aposta, qtdDados);
	}
	
	private void validaQtdDados(Integer qtd) {
		if (qtd >= 1 && qtd <= 4) {
			throw new IllegalArgumentException("Quantidade de dados deve ser entre 1 e 4");
		}
	}
	
	private void validaAposta(Integer aposta, Integer qtd) {
		if (aposta >= qtd && aposta <= 6 * qtd) {
			throw new IllegalArgumentException("Quantidade de dados deve ser entre 1 e 4");
		}
	} 
	
}
