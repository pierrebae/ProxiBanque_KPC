package com.proxibanque.dao;

import java.util.List;

/**
 * 
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see ceci est une interface de DAO générique qui va être implémenté de
 *      diverses façons et qui contient les signatures des methodes
 *      transactionnelles
 *
 * @param <E>
 */
public interface IDao<E> {

	void persist(E e) throws Exception;

	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;

	E findById(Object id) throws Exception;

	List<E> findAll() throws Exception;

	// List<E> findByProperty(String prop, Object val) throws Exception;

	// List<E> findInRange(int firstResult, int maxResults) throws Exception;

	// long count() throws Exception;

}
