/*
 * created by github.com/marcioAlexandre
 * 15 Mar 2020
 *
 */

package com.capgemini.desafio.movimentacao.saque;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaqueRepository extends CrudRepository<SaqueModel, Long> 
{

	List<SaqueModel> findAllByCpf(String cpf);

}
