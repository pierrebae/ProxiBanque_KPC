package com.proxibanque.controller;

import java.util.List;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxibanque.model.Counsellor;
import com.proxibanque.service.ServiceCounsellor;

@Component
@ViewScoped
public class CounsellorController {

	@Autowired
	private ServiceCounsellor counsellorService;
	
	@Autowired
	private Counsellor counsellor;
	private List<Counsellor> counsellors;
	private long idCounsellor;
	
	public void loadCounsellors() throws Exception {
		counsellors = counsellorService.findAll();
	}
	
	public String saveCounsellor() throws Exception {
		counsellorService.persist(this.counsellor);
		return "home";
	}
	
	public Counsellor getCounsellor() {
		return counsellor;
	}
	
	
	
}
