/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.movimentacao.saque;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaqueController {
	
	private static final Logger LOGGER = Logger.getLogger(SaqueController.class.getName());
	
	@Autowired
	SaqueRepository saqueRepository;
	
	@RequestMapping (method = RequestMethod.POST ,value="/saque")
	public String gravar(@RequestBody String dados)
	{
		LOGGER.info(LOGGER.getName());
		
		String mensagem = null;
		
		try
		{
			System.out.println(dados);
			
			SaqueBusiness saqueBusiness = new SaqueBusiness();
			SaqueModel saqueModel = saqueBusiness.getSaqueModel(dados);
			this.saqueRepository.save(saqueModel);
			
			mensagem = "{\"msg\" : \"Saque efetuado com sucesso\"}";
			
		}catch (Exception e) 
		{
			e.getStackTrace();
			mensagem = "{\"msg\" : \"Saque não efetuado\"}";
		}
		
		return mensagem;
	}
	
	@RequestMapping (value="/saques/{cpf}")
	@ResponseBody
	public List<SaqueModel> pegarSaques(@PathVariable("cpf") String cpf)
	{
		LOGGER.info(LOGGER.getName());
		
		return this.saqueRepository.findAllByCpf(cpf);
	}
	
	
	@RequestMapping (value="/valor-saques/{id}")
	@ResponseBody
	public double pegarValorSaquesByCpf(@PathVariable("id") String cpf)
	{
		LOGGER.info(LOGGER.getName());
		
		List<SaqueModel> saqueModelList = this.saqueRepository.findAllByCpf(cpf);
		
		double sum = 0;
		for (SaqueModel saqueModel : saqueModelList)
		{
			sum += saqueModel.getValor();
		}
		
		return sum;
	}

}
