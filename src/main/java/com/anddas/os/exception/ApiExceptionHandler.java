package com.anddas.os.exception;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.anddas.os.model.Cliente;
import com.anddas.os.service.CadastroClienteService;
@ControllerAdvice
public class ApiExceptionHandler{
	
	@Autowired
	private CadastroClienteService cadastroCliente;
	
	public ResponseEntity<Object> validar(Cliente cliente){
		 var problema = new Problema();
		    problema.setStatus(400);
	        problema.setTitulo("Preencher todos os campos");
	        problema.setDataHora(LocalDateTime.now());
		if(cliente.getNome() == null || cliente.getNome().isEmpty() || cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
			return ResponseEntity.badRequest().body(problema);
		}
		
		return ResponseEntity.ok(cadastroCliente.salvar(cliente));
		
		
		
		
	}
	

}
