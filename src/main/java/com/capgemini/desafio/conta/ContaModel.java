/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.conta;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ContaModel {
	
	@Id
	private String cpf;
	private String agencia;
	private String numero;
	private int idConta; //1- cc , 2 - cp
	private String observacao;
	private boolean status;
	
	
	public String getAgencia() 
	{
		return agencia;
	}
	
	public void setAgencia(String agencia) 
	{
		this.agencia = agencia;
	}
	
	public String getNumero() 
	{
		return numero;
	}
	
	public void setNumero(String numero) 
	{
		this.numero = numero;
	}

	public boolean isStatus() 
	{
		return status;
	}

	public void setStatus(boolean status) 
	{
		this.status = status;
	}

	public int getIdConta() 
	{
		return idConta;
	}

	public void setIdConta(int idConta) 
	{
		this.idConta = idConta;
	}

	public String getCpf() 
	{
		return cpf;
	}

	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) 
	{
		this.observacao = observacao;
	}
	
	public String toString() {
		return this.getCpf()+", "+this.getIdConta()+", "+this.getAgencia()+", "+this.getNumero()+", "+this.getObservacao();
	}
	
}