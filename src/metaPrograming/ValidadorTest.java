package metaPrograming;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class ValidadorTest {

	@Test
	void testValidar() {
		Candidato candidato = new Candidato();
		Validador validador = new Validador();
		List<String> erros = validador.validar(candidato);
		assertTrue(erros.contains("Nota"));
		assertTrue(erros.contains("Nome Completo"));
		assertTrue(erros.contains("CPF"));
	}

}
