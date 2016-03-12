package br.com.restfulcrud.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.restfulcrud.model.Produtos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public interface InterfaceDAO<T> {
    
	public T getById(Integer id); 
	public ArrayList<?> findAll();
	public void persist(T t); 
	public void remove(T t);
	public void removeById(Integer id);
	public void merge(T t);
	
}