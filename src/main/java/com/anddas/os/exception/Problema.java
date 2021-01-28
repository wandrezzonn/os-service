package com.anddas.os.exception;

import java.time.LocalDateTime;

public class Problema {

	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;

	protected Problema(Integer status, LocalDateTime dataHora, String titulo) {
		super();
		this.status = status;
		this.dataHora = dataHora;
		this.titulo = titulo;
	}

	public Problema() {

	}

	public Integer getStatus() {
		return status;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public String getTitulo() {
		return titulo;
	}

}
