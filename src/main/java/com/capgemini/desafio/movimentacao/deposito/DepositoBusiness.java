/*
 * created by github.com/marcioAlexandre
 * 15 Mar 2020
 *
 */

package com.capgemini.desafio.movimentacao.deposito;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

public class DepositoBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(DepositoBusiness.class.getName());
	
	protected DepositoModel getDepositoModel(String dados) throws JSONException
	{
		LOGGER.info(LOGGER.getName());
		
		JSONObject deposito = new JSONObject(dados);
		
		DepositoModel depositoModel = new DepositoModel();
		depositoModel.setCpf(deposito.getString("cpf"));
		depositoModel.setDatetime(LocalDateTime.now());
		depositoModel.setObservacao(deposito.getString("observacao"));
		depositoModel.setValor(deposito.getDouble("valor"));
		
		return depositoModel;
	}

}
