package com.anddas.os.exception;

import java.time.LocalDateTime;

public class ProblemaBuilder {

	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	
	public Problema buid() {
		return new Problema(status,dataHora,titulo);
	}
	
	public ProblemaBuilder comStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public ProblemaBuilder comdataHora(LocalDateTime dataHora) {
		this.dataHora= dataHora;
		return this;
	}
	
	
	public ProblemaBuilder comTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
}
