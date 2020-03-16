/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.cliente;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.desafio.login.LoginBusiness;
import com.capgemini.desafio.login.LoginModel;
import com.capgemini.desafio.login.LoginRepository;

@RestController
public class ClienteController {
	
	private static final Logger LOGGER = Logger.getLogger(ClienteController.class.getName());
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@RequestMapping (method = RequestMethod.POST ,value="/cliente")
	public String inserirCliente(@RequestBody String cliente)
	{
		LOGGER.info(LOGGER.getName());
		
		String mensagem = null;
			
		try 
		{	
			ClienteBusiness clienteBusiness = new ClienteBusiness();
			ClienteModel clienteModel = clienteBusiness.getClienteModel(cliente);
			clienteModel = this.clienteRepository.save(clienteModel);
			
			this.inserirLogin(cliente, clienteModel);
			
			mensagem = "{\"msg\" : \"Cliente salvo/atualizado com sucesso\"}";
					
		}catch(Exception e)
		{
			e.getStackTrace();
			mensagem = "{\"msg\" : \"Cliente não salvo!\"}";
		}
		
		return mensagem;
	}
	
	private void inserirLogin(String cliente, ClienteModel clienteModel) throws Exception 
	{
		LOGGER.info(LOGGER.getName());
		
		LoginBusiness loginBusiness = new LoginBusiness();
		LoginModel loginModel = loginBusiness.getLoginModel(cliente, clienteModel);
		this.loginRepository.save(loginModel);
	}
	
	@RequestMapping (method = RequestMethod.GET ,value="/clientes")
	public List<ClienteModel> getClientes()
	{
		LOGGER.info(LOGGER.getName());
		
		return (List<ClienteModel>) this.clienteRepository.findAll();
	}
	
	@RequestMapping (method = RequestMethod.GET , value="/cliente/id")
	public ClienteModel pegarCliente(@RequestBody String id)
	{
		LOGGER.info(LOGGER.getName());
		
		System.out.println("Id enviado: "+id);
		Optional<ClienteModel> optClienteModel = this.clienteRepository.findByCpf(id);
		ClienteModel clienteModel = null;
		
		if (optClienteModel.isPresent()) 
		{
			clienteModel = optClienteModel.get();
		}
		
		return clienteModel;
	}

}
