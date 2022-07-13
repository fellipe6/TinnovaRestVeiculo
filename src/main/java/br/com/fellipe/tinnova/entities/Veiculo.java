package br.com.fellipe.tinnova.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fellipe.tinnova.entities.dtos.VeiculoDTO;
import br.com.fellipe.tinnova.entities.enums.Fornecedor;
import br.com.fellipe.tinnova.entities.enums.StatusVenda;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Veículo", description = "Representa o modelo veículo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "ID do veículo", example = "1")
	private Integer id;
	@ApiModelProperty(value = "Descrição do modelo do veículo", example = "Fiesta")
	private String veiculo;

	@ApiModelProperty(value = "Fabricante chamado por enum", example = "ex.FORD")

	private String fornecedor;

	@ApiModelProperty(value = "Ano de fabricação", example = "2022")
	private Integer ano;

	@ApiModelProperty(value = "Descriçao do veículo", example = "R$25.000")
	@Column(columnDefinition = "text", length = 2000)
	private String descricao;

	@ApiModelProperty(value = "Status de venda do veículo", example = "true", required = false)
	private Boolean venda;

	@ApiModelProperty(value = "Captura data na hora da criação", example = "30/06/2022")
	@JsonFormat(pattern = "dd/MM/yyyy")

	private LocalDate created = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty(value = "Captura data na hora da edição", example = "30/06/2022")
	private LocalDate updated;

	public Veiculo() {
		super();
	}

	public Veiculo(VeiculoDTO obj) {

		this.id = obj.getId();
		this.fornecedor = obj.getFornecedor().getNome();
		this.veiculo = obj.getVeiculo();
		this.ano = obj.getAno();
		this.venda = obj.getVenda().getStatus();
		this.descricao = obj.getDescricao();

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
			this.fornecedor = fornecedor.getNome();
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

	public StatusVenda getVenda() {

		return StatusVenda.valueof(venda);

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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}

}
