package com.proxibanque.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.proxibanque.model.Client;

@Component
@Transactional
public class DaoClient extends DaoImpl<Client> implements IDaoClient{

}
