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


@Component
@Transactional
public class DaoTransfer extends DaoImpl<Transfer>  implements IDaoTransfer{
	
	
	
}
