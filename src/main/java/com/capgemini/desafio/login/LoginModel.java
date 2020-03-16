/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.login;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_login")
public class LoginModel 
{
	
	private Integer email;
	private Integer senha;
	@Id
	private String cpf;
	
	public LoginModel(){}

	public Integer getEmail() {
		return email;
	}

	public void setEmail(String email) {
		// criptografia
		this.email = email.hashCode();
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		// criptografia
		this.senha = senha.hashCode();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toString() {
		return this.cpf+", "+this.email+", "+this.senha;
	}

}
