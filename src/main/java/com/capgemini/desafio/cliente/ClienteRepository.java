/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.cliente;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository 
	extends CrudRepository<ClienteModel, String> 
{
	Optional<ClienteModel> findByCpf(String cpf);
}
