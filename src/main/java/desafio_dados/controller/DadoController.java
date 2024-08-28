package desafio_dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import desafio_dados.dto.ErrorResponseDto;
import desafio_dados.service.DadoService;

@RestController
@RequestMapping("/dado")
public class DadoController {

	@Autowired
	private DadoService dadoService;
	
	@GetMapping
	public ResponseEntity<?> lancarDados(@RequestParam Integer qtd, @RequestParam Integer aposta) {
		try {
			return dadoService.lancarDados(qtd, aposta);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorResponseDto(e.getMessage()));
		}
	}
	
}