//package com.proxibanque.aspect;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.hibernate.HibernateException;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//@Component
//@Transactional
//public class DaoHistory {
//	@PersistenceContext(unitName = "persistenceUnit")
//	protected EntityManager entityManager;
//	
//	
//	public void persist(HistoryCreateClient hist) throws HibernateException {
//		getEntityManager().persist(hist);
//	}
//
//
//	public EntityManager getEntityManager() {
//		return entityManager;
//	}
//
//
//	public void setEntityManager(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
//	
//	
//	
//}
