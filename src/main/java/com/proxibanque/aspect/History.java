//package com.proxibanque.aspect;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class History {
//	
//	@Autowired
//	DaoHistory daoHist;
//	HistoryCreateClient historyCreateClient=new HistoryCreateClient();
//	
//	@Pointcut("execution(* com.proxibanque.dao.IDao.persist(..))")
//	public void myPointCut() {
//		
//	}

//	@Before("myPointCut()") 

//	@AfterReturning("myPointCut()") 

//	public void makeHistory(){
//		historyCreateClient.setOperation_name("createclient");
//		daoHist.persist(historyCreateClient);
//	}
////	public void applause() {
////	System.out.println("BRAVO...CLAPCLAP...BRAVO");
////	}
//	
////	private String simpleDate;
////	
////	public String date(){
////		Date creationDate = new Date();
////		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
////		simpleDate = dateFormat.format(creationDate);
////		return simpleDate;
////	}
//
//	
//	
//}
