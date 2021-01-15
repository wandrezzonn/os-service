package com.anddas.os.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anddas.os.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByNome(String nome);
	List<Cliente> findByNomeContaining(String nome);
}
