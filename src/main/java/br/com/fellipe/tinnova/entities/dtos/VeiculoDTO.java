package br.com.fellipe.tinnova.entities.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fellipe.tinnova.entities.Veiculo;
import br.com.fellipe.tinnova.entities.enums.Fornecedor;
import br.com.fellipe.tinnova.entities.enums.StatusVenda;
import io.swagger.annotations.ApiModelProperty;

public class VeiculoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@ApiModelProperty(value = "Descrição do modelo do veículo", example = "Fiesta")
	private String veiculo;

	
	@ApiModelProperty(value = "Fabricante chamado por enum", example = "ex.FORD")
	private String fornecedor;

	@ApiModelProperty(value = "Ano de fabricação", example = "2022")
	private Integer ano;
	
	@ApiModelProperty(value = "Descriçao do veículo", example = "R$25.000")
	private String descricao;

	@ApiModelProperty(value = "Status de venda do veículo", example = "true", required = false)

	private boolean venda;

	@ApiModelProperty(value = "Captura data na hora da criação", example = "30/06/2022")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate created = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty(value = "Captura data na hora da edição", example = "30/06/2022")
	private LocalDate updated;

	public VeiculoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VeiculoDTO(Veiculo obj) {

		this.id = obj.getId();
		this.veiculo = obj.getVeiculo();
		this.fornecedor = obj.getFornecedor().getNome();
		this.ano = obj.getAno();
		this.descricao = obj.getDescricao();
		this.venda = obj.getVenda().getStatus();
		this.created = obj.getCreated();
		this.updated = obj.getUpdated();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {

		return Fornecedor.valueOf(fornecedor);

	}

	public void setFornecedores(Fornecedor fornecedor) {
		if (fornecedor != null) {
			this.fornecedor = fornecedor.getNome().toUpperCase();
		}
	}
	

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}


	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public void setVenda(boolean venda) {
		this.venda = venda;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusVenda getVenda() {

		return StatusVenda.valueof(venda);

	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDate updated) {
		this.updated = updated;
	}

}
