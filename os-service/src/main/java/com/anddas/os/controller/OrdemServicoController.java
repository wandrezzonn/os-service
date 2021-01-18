package com.anddas.os.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.anddas.os.model.OrdemServico;
import com.anddas.os.representation.model.OrdemServicoRepresentation;
import com.anddas.os.service.OrdemServicoService;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService service;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrdemServico criar(@Valid @RequestBody OrdemServico ordem) {
		return service.criar(ordem);

	}

	@GetMapping
	public List<OrdemServicoRepresentation> buscarTodas() {
		return toCollectionsRepresentation(service.buscar());
	}

	@GetMapping("{idOrdem}")
	public ResponseEntity<OrdemServicoRepresentation> buscarPorId(@PathVariable("idOrdem") Integer id) {
		OrdemServico ordemS = service.buscarPorId(id);
		if (ordemS != null) {

			return ResponseEntity.ok(toModel(ordemS));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("{idOrdem}/finalizar")
	public void encerrar(@PathVariable("idOrdem") Integer id) {
		service.finalizar(id);

	}

	private OrdemServicoRepresentation toModel(OrdemServico ordemServico) {
		return mapper.map(ordemServico, OrdemServicoRepresentation.class);
	}

	private List<OrdemServicoRepresentation> toCollectionsRepresentation(List<OrdemServico> ordemServico) {

		return ordemServico.stream().map(ordem -> toModel(ordem)).collect(Collectors.toList());
	}

}
