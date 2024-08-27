package desafio_dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_dados.dto.DadoDto;
import desafio_dados.service.DadoService;

@RestController
@RequestMapping("/dado")
public class DadoController {

	@Autowired
	private DadoService dadoService;
	
	@PostMapping
	public void lancarDados(@RequestBody DadoDto dados) {
		dadoService.lancarDados(dados);
	}
	
}