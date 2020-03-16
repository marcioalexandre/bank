/*
 * created by github.com/marcioAlexandre
 * 13 Mar 2020
 *
 */

package com.capgemini.desafio;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BancoController 
{
	
	private static final Logger LOGGER = Logger.getLogger(BancoController.class.getName());
	
	@RequestMapping("/")
	//@ResponseBody
	public String paginaInicial() 
	{
		LOGGER.info(LOGGER.getName());
		
		return "index";
	}
	
	@RequestMapping("/cliente")
	//@ResponseBody
	public String paginaCliente() 
	{
		LOGGER.info(LOGGER.getName());
		
		return "cliente";
	}
	
	@RequestMapping("/deposito")
	//@ResponseBody
	public String paginaDeposito() 
	{
		LOGGER.info(LOGGER.getName());
		
		return "deposito";
	}

	@RequestMapping("/conta")
	//@ResponseBody
	public String paginaConta() 
	{
		LOGGER.info(LOGGER.getName());
		
		return "conta";
	}
	
	@RequestMapping("/saldo")
	//@ResponseBody
	public String paginaSaldo() 
	{
		LOGGER.info(LOGGER.getName());
		
		return "saldo";
	}
	
	@RequestMapping("/saque")
	//@ResponseBody
	public String paginaSaque() 
	{
		LOGGER.info(LOGGER.getName());
		
		return "saque";
	}

	@RequestMapping("/transacao")
	//@ResponseBody
	public String paginaTransacao() 
	{
		LOGGER.info(LOGGER.getName());
		
		return "transacao";
	}
	
}
