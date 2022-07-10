package br.com.fellipe.tinnova.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fellipe.tinnova.entities.Veiculo;
import br.com.fellipe.tinnova.entities.dtos.VeiculoDTO;
import br.com.fellipe.tinnova.entities.exception.VeiculoNotFoundException;
import br.com.fellipe.tinnova.repository.VeiculoRepository;

@Service
public class VeiculosService {

	@Autowired
	VeiculoRepository veiculoRepository;

	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	public Veiculo findById(Integer id) {
		Optional<Veiculo> obj = veiculoRepository.findById(id);
		return obj.orElseThrow(() -> new VeiculoNotFoundException("ID não encontrado:" + id));
	}


	public List<VeiculoDTO> naoVendido() {
		List<VeiculoDTO> obj = veiculoRepository.naoVendido();
		return obj;
	}

	public List<VeiculoDTO> vendido() {
		List<VeiculoDTO> obj = veiculoRepository.vendido();
		return obj;
	}

	@Transactional(readOnly = true)
	public List<VeiculoDTO> buscaPorDecada(Integer ano) {
		List<VeiculoDTO> obj = veiculoRepository.buscaPorDecada(ano);
		return obj;
	}

	@Transactional(readOnly = true)
	public List<VeiculoDTO> buscaFabricante(String fornecedor) {
		List<VeiculoDTO> obj = veiculoRepository.buscaFabricante(fornecedor);
		return obj;
	}

	public Veiculo create(VeiculoDTO obj) {
		obj.setId(null);
		Veiculo newObj = new Veiculo(obj);
		return veiculoRepository.save(newObj);
	}

	public Veiculo update(Integer id, @Valid VeiculoDTO objDTO)  {
		objDTO.setId(id);
		Optional<Veiculo> obj = veiculoRepository.findById(id);
		if (obj.isPresent()) {
			Veiculo veiculo = obj.get();
			veiculo.setFornecedores(objDTO.getFornecedor());
			veiculo.setAno(objDTO.getAno());
			veiculo.setDescricao(objDTO.getDescricao());
			veiculo.setVenda(false);	
			veiculo.setVeiculo(objDTO.getVeiculo());
			veiculo.setUpdated(LocalDate.now());
			return veiculoRepository.save(veiculo);
		} else {
			throw new VeiculoNotFoundException("ID não encontrado:" + id);
		}
	}


	public Veiculo updateParcial(Integer id, @Valid VeiculoDTO objDTO)  {
		objDTO.setId(id);
		Optional<Veiculo> obj = veiculoRepository.findById(id);
		
		if (obj.isPresent()) {
			
			Veiculo veiculo = obj.get();
			
			if (objDTO.getVeiculo() != null) {
				veiculo.setVeiculo(objDTO.getVeiculo());
				
			}
			
			if (objDTO.getFornecedor() == null) {
				veiculo.getFornecedor().getNome();
			}else {
				veiculo.setFornecedores(objDTO.getFornecedor());		
			}

			if (objDTO.getAno() != null) {
				veiculo.setAno(objDTO.getAno());
			}
			
			if (objDTO.getDescricao() != null) {
				veiculo.setDescricao(objDTO.getDescricao());
			}
			
			if (objDTO.getVenda() != null) {
				veiculo.getVenda().getStatus();				
			}else {
				veiculo.setVenda(false);		
			}
			
			if (objDTO.getUpdated() == null ) {
			
			
			}
			
			return veiculoRepository.save(veiculo);
		} else {
			throw new VeiculoNotFoundException("Não encontrado: ID "+id);
		}
		
	}


	public void delete(Integer id) {
		veiculoRepository.deleteById(id);
		

	}


	
}
