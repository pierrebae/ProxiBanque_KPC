package com.proxibanque.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.proxibanque.model.Counsellor;

/**
 * 
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see cette implementation de la DAO étend l'implementation générique de la
 *      DAO et implemente l'interface dao du conseiller
 *
 */
@Component
@Transactional
public class DaoCounsellor extends DaoImpl<Counsellor> implements IDaoCounsellor {

}
