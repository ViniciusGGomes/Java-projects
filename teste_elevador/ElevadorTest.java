package teste_elevador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class ElevadorTest {

	static Elevador elevador = null;
	
	@BeforeAll
	static void inicializaTestes() {
		System.out.println("Preparando classe de testes");
		elevador = new Elevador(5, 10);
	}
	
	@Test 
	void testUltimoAndar() {
		for (int andar = 0; andar < 50; andar++) {
			elevador.sobe();
		}
		assertEquals(elevador.getTotalAndares(), elevador.getAndarAtual());
	}
	
	@Test 
	void testTerreo() {
		for (int andar = 0; andar < 1000; andar++) {
			elevador.desce();
		}
		assertEquals(0, elevador.getAndarAtual());
	}
	
	@Test
	void testEntraPessoas() {
		elevador.entra();
		assertEquals(1, elevador.getNumPessoas());
	}
	
	@Test
	void testReference() {
		assertNotNull(elevador);
	}
	
	@AfterAll
	static void finalizaTestes() {
		System.out.println("Finalizando testes");
		elevador = null;
		assertNull(elevador);
	}
}
