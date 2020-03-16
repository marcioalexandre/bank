/*
 * created by github.com/marcioAlexandre
 * 16 Mar 2020
 *
 */

package com.capgemini.desafio.cliente;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClienteBusiness.class)
public class ClienteBusinessTest {
	
	@Autowired
	ClienteBusiness clienteBusiness;
			
	//campo CPF
	
	@After
	public void setDown() {
		clienteBusiness = null;
	}

	@Test
	public void testGetClienteModelComCpf() 
	{
		String clientenovo = "{\"cpf\":\"536254061-25\",\"nome\":\"Marcio Alexandre\",\"numerocelular\":\"55 99 999999999\","
				+ "\"login\":{\"email\":\"marcio.alexandre83@gmail.com\",\"senha\":\"123456\"}}";
				
		try 
		{
			
			assertEquals("536254061-25", clienteBusiness.getClienteModel(clientenovo).getCpf());
			
		} catch (Exception e) 
		{
		
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void testGetClienteModelSemCpf() throws Exception 
	{
		String clientenovo = "{\"nome\":\"Marcio Alexandre\",\"numerocelular\":\"55 99 999999999\","
				+ "\"login\":{\"email\":\"marcio.alexandre83@gmail.com\",\"senha\":\"123456\"}}";
				
		try 
		{
			assertEquals("536254061-25", clienteBusiness.getClienteModel(clientenovo).getCpf());

			fail("Lançar exceção: Não há cpf do cliente nos dados enviados!");
			
		} catch (Exception e) 
		{
			assertEquals("Não há cpf do cliente nos dados enviados!",  e.getMessage().trim());
			
		}
	}
	
	//campo Nome
	
	@Test
	public void testGetClienteModelComNome() 
	{
		String clientenovo = "{\"cpf\":\"536254061-25\",\"nome\":\"Marcio Alexandre\",\"numerocelular\":\"55 99 999999999\","
				+ "\"login\":{\"email\":\"marcio.alexandre83@gmail.com\",\"senha\":\"123456\"}}";
				
		try 
		{
			assertEquals("Marcio Alexandre", clienteBusiness.getClienteModel(clientenovo).getNome());
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void testGetClienteModelSemNome() throws Exception 
	{
		String clientenovo = "{\"cpf\":\"536254061-25\",\"numerocelular\":\"55 99 999999999\","
				+ "\"login\":{\"email\":\"marcio.alexandre83@gmail.com\",\"senha\":\"123456\"}}";
				
		try 
		{
			assertEquals("Marcio Alexandre", clienteBusiness.getClienteModel(clientenovo).getNome());

			fail("Lançar exceção: Não há nome do cliente nos dados enviados!");
			
		} catch (Exception e) 
		{
			assertEquals("Não há nome do cliente nos dados enviados!",  e.getMessage().trim());
			
		}
	}
	
	//campo Numero Celular
	
	@Test
	public void testGetClienteModelComNumeroCelular() 
	{
		String clientenovo = "{\"cpf\":\"536254061-25\",\"nome\":\"Marcio Alexandre\",\"numerocelular\":\"55 99 999999999\","
				+ "\"login\":{\"email\":\"marcio.alexandre83@gmail.com\",\"senha\":\"123456\"}}";
				
		try 
		{
			assertEquals("55 99 999999999", clienteBusiness.getClienteModel(clientenovo).getNumerocelular());
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void testGetClienteModelSemNumeroCelular() 
	{
		String clientenovo = "{\"cpf\":\"536254061-25\",\"nome\":\"Marcio Alexandre\","
				+ "\"login\":{\"email\":\"marcio.alexandre83@gmail.com\",\"senha\":\"123456\"}}";
				
		try 
		{
			assertEquals("55 99 999999999", clienteBusiness.getClienteModel(clientenovo).getNumerocelular());
			
			fail("Lançar exceção: Não há número do celular do cliente nos dados enviados!");
			
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
			assertEquals("Não há número do celular do cliente nos dados enviados!",  e.getMessage().trim());
			
		}
		
	}
	
}
