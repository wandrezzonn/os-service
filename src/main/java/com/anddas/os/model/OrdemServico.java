package com.anddas.os.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@ManyToOne
	private Cliente cliente;
	@NotBlank
	private String descricao;
	@NotBlank
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	@JsonProperty(access = Access.READ_ONLY)
	private StatusOrdemServico status;
	
	@Column(name = "data_abertura")
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataAbertura;
	
	
	@Column(name = "data_finalizacao")
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataFinalizada;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public StatusOrdemServico getStatus() {
		return status;
	}
	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}
	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public LocalDateTime getDataFinalizada() {
		return dataFinalizada;
	}
	public void setDataFinalizada(LocalDateTime dataFinalizada) {
		this.dataFinalizada = dataFinalizada;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public boolean podeSerFinalizada() {
		return StatusOrdemServico.ABERTA.equals(getStatus());
	}
	
	public void finalizar() {
		if(podeSerFinalizada()){
			setStatus(StatusOrdemServico.FINALIZADA);
			setDataFinalizada(LocalDateTime.now());
		}
		
	}
	
	
}
