package com.proxibanque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.proxibanque.model.BankAccount;
import com.proxibanque.model.Client;
import com.proxibanque.model.Transfer;
import com.proxibanque.service.ServiceAccount;

/**
 * 
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see cette implementation de la DAO étend l'implementation générique de la
 *      DAO et implemente l'interface dao du virement
 *
 */
@Component
@Transactional
public class DaoTransfer extends DaoImpl<Transfer>  implements IDaoTransfer{
	
	
	
}
