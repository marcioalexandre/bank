/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.movimentacao.saque;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.capgemini.desafio.movimentacao.Movimentacao;

@Entity
@Table(name="tb_saque")
public class SaqueModel extends Movimentacao  
{

	SaqueModel() 
	{
		super();
	}
	

}
