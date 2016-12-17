package com.proxibanque.dao;



import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.proxibanque.model.Counsellor;

@Component
@Transactional
public class DaoCounsellor extends DaoImpl<Counsellor> implements IDaoCounsellor {

}
