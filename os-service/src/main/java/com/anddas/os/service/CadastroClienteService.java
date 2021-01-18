package com.anddas.os.service;


import org.springframework.stereotype.Service;
import com.anddas.os.model.Cliente;
import com.anddas.os.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	private ClienteRepository clienteRepository;
	
	public CadastroClienteService (ClienteRepository clienteRepository){
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente salvar(Cliente cliente) {
		
			return clienteRepository.save(cliente);
		
		
	}

}
