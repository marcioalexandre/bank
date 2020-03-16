/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.conta.corrente;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.capgemini.desafio.conta.ContaModel;

@Entity
@Table(name="tb_contacorrente")
public class ContaCorrenteModel extends ContaModel {

	ContaCorrenteModel() {
		super();
	}

}
