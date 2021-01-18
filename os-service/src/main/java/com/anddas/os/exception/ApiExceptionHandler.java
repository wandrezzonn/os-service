package com.anddas.os.exception;

import java.time.LocalDateTime;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = { DataIntegrityViolationException.class, ConstraintViolationException.class })
	public ResponseEntity<Object> handlerDataIntegrityViolationException() {
		Problema problema = new ProblemaBuilder().comTitulo("Uma ou mais campos estão vazios, favor verificar")
				.comStatus(HttpStatus.BAD_REQUEST.value())
				.comdataHora(LocalDateTime.now())
				.buid();
		
		return new ResponseEntity<>(problema, HttpStatus.BAD_REQUEST);

	}

}
