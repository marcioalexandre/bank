/*
 * created by github.com/marcioAlexandre
 * 15 Mar 2020
 *
 */

package com.capgemini.desafio.movimentacao.deposito;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.capgemini.desafio.movimentacao.Movimentacao;

@Entity
@Table(name="tb_deposito")
public class DepositoModel extends Movimentacao 
{

	DepositoModel() 
	{
		super();
	}
	

}
