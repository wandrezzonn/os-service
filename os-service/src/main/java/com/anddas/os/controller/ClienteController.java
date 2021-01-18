package com.anddas.os.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anddas.os.model.Cliente;
import com.anddas.os.repository.ClienteRepository;
import com.anddas.os.representation.model.ClienteRepresentation;
import com.anddas.os.service.CadastroClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	CadastroClienteService cadastroCliente;


	@GetMapping
	public List<ClienteRepresentation> clientes() {
		//return clienteRepository.findAll();
		return toCollectionRepresentation(clienteRepository.findAll());

	}

	@PostMapping

	public Cliente salvar(@Valid @RequestBody Cliente cliente) {
		 return cadastroCliente.salvar(cliente);
		

	}

	@GetMapping("{idCliente}")
	public Cliente buscarClienteId(@Valid @PathVariable(name = "idCliente") Integer idCliente) {

		return clienteRepository.findById(idCliente).orElse(null);
		

	}

	@DeleteMapping("/{idCliente}")
	public ResponseEntity<Void> deletar(@PathVariable("idCliente") Integer id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{idCliente}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable("idCliente") Integer idCliente,
			@RequestBody Cliente cliente) {

		if (!clienteRepository.existsById(idCliente)) {
			return ResponseEntity.notFound().build();
		}

		cliente.setId(idCliente);
		return ResponseEntity.ok(clienteRepository.save(cliente));
	}

	private ClienteRepresentation toModel(Cliente cliente) {
		return mapper.map(cliente, ClienteRepresentation.class);
	}
	
	private List<ClienteRepresentation> toCollectionRepresentation(List<Cliente> clientes){
		
		return clientes.stream().map(cliente -> toModel(cliente)).collect(Collectors.toList());
		
	}

}
