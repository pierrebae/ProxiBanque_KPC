package com.proxibanque.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.proxibanque.model.Client;

/**
 * 
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see cette implementation de la DAO étend l'implementation générique de la
 *      DAO et implemente l'interface dao du client
 *
 */
@Component
@Transactional
public class DaoClient extends DaoImpl<Client> implements IDaoClient {

}
