/*
 * created by github.com/marcioAlexandre
 * 15 Mar 2020
 *
 */

package com.capgemini.desafio.cliente;

import java.util.logging.Logger;

import org.json.JSONObject;

public class ClienteBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(ClienteBusiness.class.getName());
	
	public ClienteModel getClienteModel(String cliente) throws Exception 
	{
		LOGGER.info(LOGGER.getName());
		
		JSONObject cli = new JSONObject(cliente);
	
		ClienteModel clienteModel = new ClienteModel();
		
		
		if (cliente.contains("cpf")) 
		{
			clienteModel.setCpf(cli.getString("cpf"));
		}else 
		{
			throw new Exception("Não há cpf do cliente nos dados enviados!");
		}
		
		
		if (cliente.contains("nome")) 
		{
			clienteModel.setNome(cli.getString("nome"));
		}else 
		{
			throw new Exception("Não há nome do cliente nos dados enviados!");	
		}
		
		
		if (cliente.contains("numerocelular")) 
		{
			clienteModel.setNumerocelular(cli.getString("numerocelular"));
		}else 
		{
			throw new Exception("Não há número do celular do cliente nos dados enviados!");
		}
		
		
		return clienteModel;
	}

}
