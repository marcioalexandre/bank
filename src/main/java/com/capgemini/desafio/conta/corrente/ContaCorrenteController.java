/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.conta.corrente;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaCorrenteController {
	
	private static final Logger LOGGER = Logger.getLogger(ContaCorrenteController.class.getName());
	
	@Autowired
	ContaCorrenteRepository contaCorrenteRepository;
	
	@RequestMapping (method = RequestMethod.POST ,value="/conta-corrente")
	public String gravar(@RequestBody String conta)
	{
		LOGGER.info(LOGGER.getName());
		
		String mensagem = null;
		
		try 
		{
			
			ContaCorrenteBusiness contaCorrenteBusiness = new ContaCorrenteBusiness();
			ContaCorrenteModel contaCorrenteModel = contaCorrenteBusiness.getContaCorrenteModel(conta);
			
			if (contaCorrenteModel != null)
			{
				this.contaCorrenteRepository.save(contaCorrenteModel);
				mensagem = "{\"msg\" : \"Conta-Corrente cadastrada com sucesso\"}";
			}else {
				mensagem = "{\"msg\" : \"Conta-Corrente não cadastrada (null)\"}";
			}
			
			
			
		}catch(Exception e) 
		{
			e.getStackTrace();
			mensagem = "{\"msg\" : \"Conta-Corrente não cadastrada\"}";
		}
		
		return mensagem;
	}
	
	
	@RequestMapping (value="/conta-corrente/{id}")
	@ResponseBody
	public ContaCorrenteModel pegarContaByIdCliente(@PathVariable("id") String cpf)
	{
		
		LOGGER.info(LOGGER.getName());
		
		Optional<ContaCorrenteModel> optContaCorrenteModel = this.contaCorrenteRepository.findByCpf(cpf);
		ContaCorrenteModel ccModel = null;
		
		if (optContaCorrenteModel.isPresent()) 
		{
			ccModel = optContaCorrenteModel.get();
			return ccModel;
			
		}else 
		{
			return null;
		}
		
	}

}
