package com.proxibanque.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.proxibanque.model.BankAccount;
import com.proxibanque.model.Client;


@Component
@Transactional
public class DaoAccount extends DaoImpl<BankAccount> implements IDaoAccount{


}
