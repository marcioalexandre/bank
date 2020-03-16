/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.login;

import java.util.logging.Logger;

import org.json.JSONObject;

import com.capgemini.desafio.cliente.ClienteModel;

public class LoginBusiness 
{
	private static final Logger LOGGER = Logger.getLogger(LoginBusiness.class.getName());
	
	public LoginModel getLoginModel(String cliente, ClienteModel clienteModel) throws Exception 
	{
		LOGGER.info(LOGGER.getName());
		
		JSONObject cli = new JSONObject(cliente);
		
		JSONObject loginJson = null;
		
		if (cliente.contains("login"))
		{
			 loginJson = cli.getJSONObject("login");
		}else 
		{
			throw new Exception("Não há login do cliente nos dados enviados!");
		}
		
		LoginModel loginModel = new LoginModel();
		
		
		if (cliente.contains("email"))
		{
			loginModel.setEmail(loginJson.getString("email"));
		}else 
		{
			throw new Exception("Não há email do cliente nos dados enviados!");
		}
		
		
		if (cliente.contains("senha"))
		{
			loginModel.setSenha(loginJson.getString("senha"));
		}else 
		{
			throw new Exception("Não há senha do cliente nos dados enviados!");
		}
		
		
		loginJson = null;
		loginModel.setCpf(clienteModel.getCpf());
		
		
		return loginModel;

	}

}
