package br.com.fellipe.tinnova.teste.crud;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fellipe.tinnova.entities.Veiculo;
import br.com.fellipe.tinnova.entities.enums.Fornecedor;
import br.com.fellipe.tinnova.repository.VeiculoRepository;

@SpringBootTest
public class VeiculoTest {

	@Autowired
	VeiculoRepository repository;

	@Test
	public void listaVeiculo() {
		List<Veiculo> List = repository.findAll();
		assertThat(List).size().isGreaterThan(0);
		
		
	}
	@Test
	public void idVeiculo() {
		Veiculo veiculo  = repository.findById(1).get();
		assertEquals("Territory10", veiculo.getVeiculo());
		System.out.println(veiculo.getVeiculo());
		System.out.println(veiculo.getFornecedor());
}
	@Test
	public void update() {
		Veiculo veiculo  = repository.findById(5).get();
		veiculo.setDescricao("Valor: R$ 20.000");
		veiculo.setAno(2020);
		veiculo.setFornecedores(Fornecedor.FORD);
		veiculo.setVenda(false);
		veiculo.setVeiculo("Territory10");
		assertEquals("Territory10", veiculo.getVeiculo());
		
	}
	@Test
	public void cadastraVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setDescricao("Valor: R$ 100.000");
		veiculo.setAno(2022);
		veiculo.setFornecedores(Fornecedor.FORD);
		veiculo.setVenda(true);
		veiculo.setVeiculo("ESCORT");
		repository.save(veiculo);
	}
	@Test
	public void deleteVeiculo() {
		repository.deleteById(56);
		assertThat(repository.existsById(56));
	}
	

}