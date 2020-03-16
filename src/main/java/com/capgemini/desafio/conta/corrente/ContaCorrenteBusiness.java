/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.conta.corrente;

import java.util.logging.Logger;

import org.json.JSONObject;

public class ContaCorrenteBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(ContaCorrenteBusiness.class.getName());
	
	protected ContaCorrenteModel getContaCorrenteModel(String dados) 
	{
		LOGGER.info(LOGGER.getName());
		
		try 
		{
			
			JSONObject conta = new JSONObject(dados);
			
			ContaCorrenteModel contaCorrenteModel = new ContaCorrenteModel();
			
			if (dados.contains("cpf"))
			{
				contaCorrenteModel.setCpf(conta.getString("cpf"));
			}else
			{
				throw new Exception("Não há cpf do cliente nos dados enviados!");
			}
			
			
			if (dados.contains("agencia"))
			{
				contaCorrenteModel.setAgencia(conta.getString("agencia"));
			}else
			{
				throw new Exception("Não há agencia do cliente nos dados enviados!");
			}
			
			
			if (dados.contains("numeroconta"))
			{
				contaCorrenteModel.setNumero(conta.getString("numeroconta"));
			}else
			{
				throw new Exception("Não há numero de conta nos dados enviados!");
			}
			
			if (dados.contains("observacao"))
			{
				if (conta.getString("observacao") != null) 
				{
					contaCorrenteModel.setObservacao(conta.getString("observacao"));	
				}else 
				{
					contaCorrenteModel.setObservacao(null);
				}
			
			}else
			{
				throw new Exception("Não há observaçao da conta nos dados enviados!");
			}
			
			contaCorrenteModel.setStatus(true);
			
			return contaCorrenteModel;
			
		}catch(Exception e) 
		{
			e.getStackTrace();
			return null;
		}
	}

}
