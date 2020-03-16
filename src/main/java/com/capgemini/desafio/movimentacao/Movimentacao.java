/*
 * created by github.com/marcioAlexandre
 * 15 Mar 2020
 *
 */

package com.capgemini.desafio.movimentacao;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Movimentacao {
	
	@Id
	@GeneratedValue
	protected Long idMovimentacao;
	protected String cpf;
	protected int idConta; // 1 - Conta Corrente, 2 - Conta Poupança
	protected LocalDateTime datetime;
	protected String observacao;
	protected Double valor;
	
	protected Movimentacao(){ }
	
	public Long getIdMovimentacao() 
	{
		return idMovimentacao;
	}
	
	public void setIdMovimentacao(Long idMovimentacao) 
	{
		this.idMovimentacao = idMovimentacao;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public LocalDateTime getDatetime() 
	{
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) 
	{
		this.datetime = datetime;
	}
	
	public String getObservacao() 
	{
		return observacao;
	}
	
	public void setObservacao(String observacao) 
	{
		this.observacao = observacao;
	}
	
	public Double getValor() 
	{
		return valor;
	}
	
	public void setValor(Double valor) 
	{
		this.valor = valor;
	}

}
