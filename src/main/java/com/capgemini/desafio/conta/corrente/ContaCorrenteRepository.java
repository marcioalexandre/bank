/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.conta.corrente;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCorrenteRepository extends CrudRepository<ContaCorrenteModel, Long> 
{

	Optional<ContaCorrenteModel> findByCpf(String cpf);

}
