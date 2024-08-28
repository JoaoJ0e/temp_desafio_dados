package desafio_dados.service;

import org.springframework.http.ResponseEntity;

public interface DadoService {

	ResponseEntity<?> lancarDados(Integer qtd, Integer aposta);
	
}
