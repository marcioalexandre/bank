/*
 * created by github.com/marcioAlexandre
 * 14 Mar 2020
 *
 */

package com.capgemini.desafio.login;

import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginModel, Long> {

}
