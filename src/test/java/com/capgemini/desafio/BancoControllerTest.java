/*
 * created by github.com/marcioAlexandre
 * 16 Mar 2020
 *
 */

package com.capgemini.desafio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class BancoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	private BancoController bancoController;
	
	@Before
	public void setUp() throws Exception {
		bancoController = new BancoController();
		this.mockMvc = MockMvcBuilders.standaloneSetup(bancoController).build();
	}

	@After
	public void tearDown() throws Exception {
		bancoController = null;
		this.mockMvc = null;
	}

	@Test
	public void testPaginaInicial() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/")).
				andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testPaginaCliente() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/cliente")).
		andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testPaginaDeposito() throws Exception  {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/deposito")).
		andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testPaginaConta()  throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/conta")).
		andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testPaginaSaldo() throws Exception  {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/saldo")).
		andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testPaginaSaque() throws Exception  {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/saque")).
		andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testPaginaTransacao() throws Exception  {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/transacao")).
		andExpect(MockMvcResultMatchers.status().isOk());
	}

}
