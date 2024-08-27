package desafio_dados.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultadoDto {

	private List<Integer> dados;
	private Integer aposta;
	private BigDecimal percAcerto;
	
}
