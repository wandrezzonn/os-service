package com.anddas.os.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anddas.os.model.Cliente;
import com.anddas.os.model.OrdemServico;
import com.anddas.os.model.StatusOrdemServico;
import com.anddas.os.repository.ClienteRepository;
import com.anddas.os.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	@Autowired 
	private OrdemServicoRepository ordem;
	@Autowired
	private ClienteRepository service;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		
	     Cliente cliente = service.findById(ordemServico.getCliente().getId()).get();
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		return ordem.save(ordemServico);
	}

	public List<OrdemServico> buscar() {
		
		return ordem.findAll();
	}
	
	
	public OrdemServico buscarPorId(Integer id) {
		return ordem.findById(id).orElse(null);
	}
	
	
	public void finalizar(Integer id) {
		OrdemServico os=  buscarPorId(id);
		os.finalizar();
		ordem.save(os);
		
	}
	


	

}
