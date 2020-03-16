/*
 * created by github.com/marcioAlexandre
 * 16 Mar 2020
 *
 */

package com.capgemini.desafio.login;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.desafio.cliente.ClienteBusiness;
import com.capgemini.desafio.cliente.ClienteModel;

public class LoginBusinessTest {
	
	LoginBusiness loginBusiness = null;
	
	ClienteBusiness clienteBusiness = null;
	
	@Before
	public void setUp() {
		loginBusiness = new LoginBusiness();
		clienteBusiness = new ClienteBusiness();
	}
	
	@After
	public void setDown() {
		loginBusiness = null;
		clienteBusiness = null;
	}

	//campo Email (com HashCode)
	
	@Test
	public void testGetLoginModelComEmailHashCode() {
		String clientenovo = "{\"cpf\":\"536254061-25\",\"nome\":\"Marcio Alexandre\",\"numerocelular\":\"55 99 999999999\","
				+ "\"login\":{\"email\":\"marcio.alexandre83@gmail.com\",\"senha\":\"123456\"}}";
				
		try 
		{
			ClienteModel clienteModel = clienteBusiness.getClienteModel(clientenovo);
			String email = "marcio.alexandre83@gmail.com";
			
			assertEquals(""+email.hashCode(), 
					""+loginBusiness.getLoginModel(clientenovo, clienteModel).getEmail());
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void testGetLoginModelSemEmailHashCode() 
	{
		String clientenovo = "{\"cpf\":\"536254061-25\",\"nome\":\"Marcio Alexandre\",\"numerocelular\":\"55 99 999999999\","
				+ "\"login\":{\"\":\"\",\"senha\":\"123456\"}}";
				
		try 
		{
			ClienteModel clienteModel = clienteBusiness.getClienteModel(clientenovo);
			String email = "marcio.alexandre83@gmail.com";
			
			assertEquals(""+email.hashCode(), 
						""+loginBusiness.getLoginModel(clientenovo, clienteModel).getEmail());

			fail("Lançar exceção: Não há email do cliente nos dados enviados!");
			
		} catch (Exception e) 
		{
			assertEquals("Não há email do cliente nos dados enviados!",  e.getMessage().trim());
			
		}
	}
	
	//campo Senha (com HashCode)
	
	@Test
	public void testGetLoginModelComSenhaHashCode() {
		String clientenovo = "{\"cpf\":\"536254061-25\",\"nome\":\"Marcio Alexandre\",\"numerocelular\":\"55 99 999999999\","
				+ "\"login\":{\"email\":\"marcio.alexandre83@gmail.com\",\"senha\":\"123456\"}}";
				
		try 
		{
			ClienteModel clienteModel = clienteBusiness.getClienteModel(clientenovo);
			String senha = "123456";
			
			assertEquals(""+senha.hashCode(), 
					""+loginBusiness.getLoginModel(clientenovo, clienteModel).getSenha());
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void testGetLoginModelSemSenhaHashCode() 
	{
		String clientenovo = "{\"cpf\":\"536254061-25\",\"nome\":\"Marcio Alexandre\",\"numerocelular\":\"55 99 999999999\","
				+ "\"login\":{\"email\":\"marcio.alexandre83@gmail.com\",\"\":\"\"}}";
				
		try 
		{
			ClienteModel clienteModel = clienteBusiness.getClienteModel(clientenovo);
			String senha = "123456";
			
			assertEquals(""+senha.hashCode(), 
						""+loginBusiness.getLoginModel(clientenovo, clienteModel).getSenha());

			fail("Lançar exceção: Não há senha do cliente nos dados enviados!");
			
		} catch (Exception e) 
		{
			assertEquals("Não há senha do cliente nos dados enviados!",  e.getMessage().trim());
			
		}
	}	
	
	

}
