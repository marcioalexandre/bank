/*
 * created by github.com/marcioAlexandre
 * 15 Mar 2020
 *
 */

package com.capgemini.desafio.movimentacao.deposito;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositoRepository extends CrudRepository<DepositoModel, Long> 
{

	List<DepositoModel> findAllByCpf(String cpf);

}
