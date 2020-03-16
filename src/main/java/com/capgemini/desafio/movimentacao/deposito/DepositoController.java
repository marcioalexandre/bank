/*
 * created by github.com/marcioAlexandre
 * 15 Mar 2020
 *
 */

package com.capgemini.desafio.movimentacao.deposito;

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
public class DepositoController 
{
	private static final Logger LOGGER = Logger.getLogger(DepositoController.class.getName());
	
	@Autowired
	DepositoRepository depositoRepository;
	
	@RequestMapping (method = RequestMethod.POST ,value="/deposito")
	public String gravar(@RequestBody String deposito)
	{
		LOGGER.info(LOGGER.getName());
		
		System.out.println(deposito);
		
		String mensagem = null;
		
		try
		{
			DepositoBusiness depositoBusiness = new DepositoBusiness();
			DepositoModel depositoModel = depositoBusiness.getDepositoModel(deposito);
			this.depositoRepository.save(depositoModel);
			
			mensagem = "{\"msg\" : \"Depósito efetuado com sucesso\"}";
			
		}catch(Exception e)
		{
			e.getStackTrace();
			mensagem = "{\"msg\" : \"Depósito não efetuado\"}";
		}
		
		return mensagem;
	}
	
	
	@RequestMapping (value="/depositos-por-data/{cpf}")
	@ResponseBody
	public List<DepositoModel> pegarDepositosPorData(@PathVariable("cpf") String cpf)
	{
	
		return this.depositoRepository.findAllByCpf("cpf");
		
		/*
		try 
		{
			LOGGER.info(LOGGER.getName());
			
			
			
			List<DepositoModel> depositosSelecionados = new ArrayList<DepositoModel>();
			
			System.out.println("Entrou!"+transacao);
			
			JSONObject dados = new JSONObject(transacao);
			
			LocalDateTime datetimeinicial = this.getLocalDateTime(dados.getString("datainicial"), dados.getString("horainicial"));
			
			LocalDateTime datetimefinal = this.getLocalDateTime(dados.getString("datafinal"), dados.getString("horafinal"));
			
			List<DepositoModel> depositoModelList = this.depositoRepository.findAllByCpf(dados.getString("cpf"));
			
			
			for (DepositoModel deposito: depositoModelList)
			{
				if (deposito.getDatetime().isAfter(datetimeinicial) && deposito.getDatetime().isBefore(datetimefinal)) {
					System.out.println("Achou!");
					depositosSelecionados.add(deposito);
				}
			}
			
			
			//return depositosSelecionados;
			
			
			
		}catch(Exception e) 
		{
			e.getStackTrace();
			return null;
		}
		*/
		
	}
	
	/*
	private LocalDateTime getLocalDateTime(String data, String hora)
	{
		String[] adata = data.split("-");
		String[] ahora = hora.split(":");
		LocalDateTime datetime = LocalDateTime.of(Integer.parseInt(adata[2]), 
				Integer.parseInt(adata[1]), Integer.parseInt(adata[0]), Integer.parseInt(ahora[0]), Integer.parseInt(ahora[1]));
		return datetime;
	}
	*/
	
	@RequestMapping (value="/depositos/{cpf}")
	@ResponseBody
	public List<DepositoModel> pegarDepositos(@PathVariable("cpf") String cpf)
	{
		LOGGER.info(LOGGER.getName());
		
		return this.depositoRepository.findAllByCpf(cpf);
	}
	
	
	@RequestMapping (value="/valor-depositos/{id}")
	@ResponseBody
	public double pegarValorDepositosByCpf(@PathVariable("id") String cpf)
	{
		LOGGER.info(LOGGER.getName());
		
		List<DepositoModel> depositoModelList = this.depositoRepository.findAllByCpf(cpf);
		
		double sum = 0;
		for (DepositoModel depositoModel : depositoModelList)
		{
			sum += depositoModel.getValor();
		}
		
		return sum;
	}

}
