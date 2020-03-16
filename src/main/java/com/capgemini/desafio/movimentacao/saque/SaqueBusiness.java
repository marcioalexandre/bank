/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.movimentacao.saque;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

public class SaqueBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(SaqueBusiness.class.getName());
	
	protected SaqueModel getSaqueModel(String dados) throws JSONException
	{
		LOGGER.info(LOGGER.getName());
		
		JSONObject saque = new JSONObject(dados);
		
		SaqueModel saqueModel = new SaqueModel();
		saqueModel.setCpf(saque.getString("cpf"));
		saqueModel.setDatetime(LocalDateTime.now());
		saqueModel.setObservacao(saque.getString("observacao"));
		saqueModel.setValor(saque.getDouble("valor"));
		
		return saqueModel;
	}

}
