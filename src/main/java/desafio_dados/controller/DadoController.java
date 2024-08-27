package desafio_dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import desafio_dados.dto.ResultadoDto;
import desafio_dados.service.DadoService;

@RestController
@RequestMapping("/dado")
public class DadoController {

	@Autowired
	private DadoService dadoService;
	
	@PostMapping
	public ResultadoDto lancarDados(@RequestParam Integer qtd, Integer aposta) {
		return dadoService.lancarDados(qtd, aposta);
	}
	
}