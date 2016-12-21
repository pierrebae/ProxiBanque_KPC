package com.proxibanque.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.proxibanque.model.Counsellor;

/**
 * 
 * @author Pierre Baele, Cl�ment Lacorte, Katherine Merkulova
 * @see cette implementation de la DAO �tend l'implementation g�n�rique de la
 *      DAO et implemente l'interface dao du conseiller
 *
 */
@Component
@Transactional
public class DaoCounsellor extends DaoImpl<Counsellor> implements IDaoCounsellor {

}
