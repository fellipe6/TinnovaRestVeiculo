package br.com.fellipe.tinnova.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fellipe.tinnova.entities.Veiculo;
import br.com.fellipe.tinnova.entities.dtos.VeiculoDTO;
import br.com.fellipe.tinnova.services.VeiculosService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoResource {

	@Autowired
	VeiculosService veiculosService;

	@GetMapping
	@ApiOperation(value = "Retorna todos os veículos")
	public ResponseEntity<List<Veiculo>> findAll() {
		List<Veiculo> listDTO = veiculosService.findAll();
		return ResponseEntity.ok().body(listDTO);
	}

	@ApiOperation(value = "Retorna produtos por ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> findById(@PathVariable Integer id) {
		Veiculo obj = veiculosService.findById(id);
		return ResponseEntity.ok().body(new VeiculoDTO(obj));
	}

	@ApiOperation(value = "Lista veículos disponiveis para venda")
	@GetMapping(value = "/naoVendido")
	public ResponseEntity<List<VeiculoDTO>> naovendido() {
		List<VeiculoDTO> obj = veiculosService.naoVendido();
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Lista veículos não disponiveis para venda")
	@GetMapping(value = "/vendido")
	public ResponseEntity<List<VeiculoDTO>> findByVendido() {
		List<VeiculoDTO> obj = veiculosService.vendido();
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Lista veículos por década de fabricação")
	@GetMapping(value = "/buscaDecada/{ano}")
	public ResponseEntity<List<VeiculoDTO>> buscaPorDecada(@PathVariable Integer ano) {
		List<VeiculoDTO> obj = veiculosService.buscaPorDecada(ano);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Lista veículos por fabricante")
	@GetMapping(value = "/buscaFabricante/{fornecedor}")
	public ResponseEntity<List<VeiculoDTO>> buscaFabricante(@PathVariable String fornecedor) {
		List<VeiculoDTO> obj = veiculosService.buscaFabricante(fornecedor);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@ApiOperation(value = "Salva um novo veículo")
	public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO objDTO) {
		Veiculo newObj = veiculosService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Edita um veículo buscando o ID")
	@PutMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> update(@PathVariable Integer id, @Valid @RequestBody VeiculoDTO objDTO)
			throws NotFoundException {
		Veiculo obj = veiculosService.update(id, objDTO);
		return ResponseEntity.ok().body(new VeiculoDTO(obj));
	}

	@PatchMapping(value = "/{id}")
	@ApiOperation(value = "Edita parcialmente um veículo")
	public ResponseEntity<VeiculoDTO> updateParcial(@PathVariable Integer id, @Valid @RequestBody VeiculoDTO objDTO)
			throws NotFoundException {
		Veiculo obj = veiculosService.updateParcial(id, objDTO);
		return ResponseEntity.ok().body(new VeiculoDTO(obj));

	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Deleta um veículo")
	public ResponseEntity<VeiculoDTO> delete(@PathVariable Integer id) {
		veiculosService.delete(id);
		return ResponseEntity.noContent().build();

	}

}
