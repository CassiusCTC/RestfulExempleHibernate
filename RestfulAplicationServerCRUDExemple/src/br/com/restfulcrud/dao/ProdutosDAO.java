package br.com.restfulcrud.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.restfulcrud.model.Produtos;
public class ProdutosDAO implements InterfaceDAO<Produtos> {

	private static ProdutosDAO instance;
	protected EntityManager entityManager; 
	
	public static ProdutosDAO getInstance(){ 
		if (instance == null){
			instance = new ProdutosDAO(); 
		} return instance; 
	} 
	private ProdutosDAO() {
		entityManager = getEntityManager();
	} 
	private EntityManager getEntityManager() { 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("restfulproduto"); 
		if (entityManager == null) { 
			entityManager = factory.createEntityManager(); 
		} return entityManager; 
	}

	public Produtos getById(Integer id) {
		 return entityManager.find(Produtos.class, id);
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Produtos> findAll() {
		 return (ArrayList<Produtos>) entityManager.createQuery("FROM " + Produtos.class.getName()).getResultList();
         
	}

	@Override
	public void persist(Produtos t) {
		try { 
			entityManager.getTransaction().begin();
			entityManager.persist(t); 
			entityManager.getTransaction().commit(); 
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			entityManager.getTransaction().rollback(); 
		}

	}

	@Override
	public void remove(Produtos t) {
		try{ 
			entityManager.getTransaction().begin(); 
			t = entityManager.find(Produtos.class, t.getId()); 
			entityManager.remove(t);
			entityManager.getTransaction().commit(); 
		}catch (Exception ex){ 
			ex.printStackTrace(); 
			entityManager.getTransaction().rollback(); 
	    }		
	}

	@Override
	public void removeById(Integer id) {
		try{ 
			Produtos t = getById(id); remove(t); 
		}catch (Exception ex){
			ex.printStackTrace(); 
		}
	}
	
	@Override
	public void merge(Produtos t) {
		try { 
			  entityManager.getTransaction().begin(); 
		      entityManager.merge(t); 
		      entityManager.getTransaction().commit(); 
		}catch (Exception ex) { 
		      ex.printStackTrace(); 
		      entityManager.getTransaction().rollback(); 
		}		
	}

}
