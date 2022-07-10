package br.com.fellipe.tinnova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fellipe.tinnova.entities.Veiculo;
import br.com.fellipe.tinnova.entities.dtos.VeiculoDTO;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	@Query("SELECT obj "
			+ "FROM Veiculo obj "
			+ "WHERE obj.venda = false "
			)
	List<VeiculoDTO> naoVendido();
	
	@Query("SELECT obj "
			+ "FROM Veiculo obj "
			+ "WHERE obj.venda = true "
			)
	List<VeiculoDTO> vendido();
	
	
	@Query("SELECT obj "
			+ "FROM Veiculo obj "
		    + "WHERE obj.ano BETWEEN :ano AND :ano + 9 "
			)
	List<VeiculoDTO> buscaPorDecada(Integer ano);

	@Query("SELECT obj "
			+ "FROM Veiculo obj "
		    + "WHERE obj.fornecedor LIKE %:fornecedor% "
		)	
	List<VeiculoDTO> buscaFabricante(@Param("fornecedor")String fornecedor);

}
