package br.com.fellipe.tinnova.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fellipe.tinnova.entities.Veiculo;
import br.com.fellipe.tinnova.entities.enums.Fornecedor;
import br.com.fellipe.tinnova.entities.enums.StatusVenda;
import br.com.fellipe.tinnova.repository.VeiculoRepository;

@Service
public class DBService {
	
	@Autowired
	VeiculoRepository veiculoRepository;

	public void instanciaDB() {
		
		/*
		Veiculo v1 = new Veiculo(null,"Celta", Marca.CHEVROLET,2000,"Preço a vista: R$: 25.999",StatusVenda.VENDIDO);
		Veiculo v2 = new Veiculo(null,"Toro", Marca.FIAT,2016,"Preço a vista: R$: 70.999",StatusVenda.DISPONIVEL);
		Veiculo v3 = new Veiculo(null,"Siena", Marca.FIAT,2012,"Preço a vista: R$: 26.000",StatusVenda.VENDIDO);
		Veiculo v4 = new Veiculo(null,"Escort", Marca.FORD,1995,"Preço a vista: R$: 5.000",StatusVenda.DISPONIVEL);
		Veiculo v5 = new Veiculo(null,"Ecosport", Marca.FORD,2022,"Preço a vista: R$: 78.000",StatusVenda.VENDIDO);
		Veiculo v6 = new Veiculo(null,"Ranger", Marca.FORD,2022,"Preço a vista: R$: 100.000",StatusVenda.VENDIDO);
		Veiculo v7 = new Veiculo(null,"maverick", Marca.FORD,2022,"Preço a vista: R$: 120.000",StatusVenda.DISPONIVEL);
		Veiculo v8 = new Veiculo(null,"Mustang", Marca.FORD,2022,"Preço a vista: R$: 300.000",StatusVenda.DISPONIVEL);
		Veiculo v9 = new Veiculo(null,"Bronco Sport", Marca.FORD,2022,"Preço a vista: R$: 200.000",StatusVenda.DISPONIVEL);
		Veiculo v10 = new Veiculo(null,"Territory", Marca.FORD,2022,"Preço a vista: R$: 150.000",StatusVenda.DISPONIVEL);
		Veiculo v11= new Veiculo(null,"Onix", Marca.CHEVROLET,2022,"Preço a vista: R$: 70.999",StatusVenda.VENDIDO);
		Veiculo v12 = new Veiculo(null,"Tracker", Marca.CHEVROLET,2000,"Preço a vista: R$: 55.700",StatusVenda.DISPONIVEL);
		veiculoRepository.saveAll(Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12));
		*/
		
		
		
	}
}