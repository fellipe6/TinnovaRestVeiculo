package br.com.fellipe.tinnova.resource;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import br.com.fellipe.tinnova.resources.VeiculoResource;
import br.com.fellipe.tinnova.services.VeiculosService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest
public class VeiculoTesteResource {

	@Autowired
	private VeiculoResource veiculoResource;
	
	@MockBean
	private VeiculosService veiculosService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.veiculoResource);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarFilme() {
/*
		when(this.veiculosService.findById(1)
			.thenReturn(new Veiculo(1L, "O Poderoso Chefão", "Sem descrição"));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/filmes/{codigo}", 1L)
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarFilme() {
		
		when(this.filmeService.obterFilme(5L))
			.thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/filmes/{codigo}", 5L)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void deveRetornarBadRequest_QuandoBuscarFilme() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/filmes/{codigo}", -1L)
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.filmeService, never()).obterFilme(-1L);
	}
	*/
}
}