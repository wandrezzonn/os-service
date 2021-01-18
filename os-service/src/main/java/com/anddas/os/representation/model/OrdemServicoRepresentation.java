package com.anddas.os.representation.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import com.anddas.os.model.StatusOrdemServico;
public class OrdemServicoRepresentation {
	
	private Integer id;
	private String nomeCliente;
	private String descricao;
	private BigDecimal preco;
	private StatusOrdemServico status;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataFinalizada;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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



}
