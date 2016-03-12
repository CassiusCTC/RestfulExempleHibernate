package br.com.restfulcrud.teste;

import br.com.restfulcrud.model.Produtos;
import br.com.restfulcrud.dao.InterfaceDAO;
import br.com.restfulcrud.dao.ProdutosDAO;

import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Teste {
	


	public static void main(String[] args) throws Exception{
		
		    
		    //Session s=HibernateUtil.getSession();
		    //System.out.println(s);
			Produtos p = new Produtos("Fritadeira", "eletrodomestico", 400.50f, "frita alimentos sem uso de oleo");
			System.out.println(p.getNome()+"/"+p.getPreco());
			List<Produtos> l=(List<Produtos>)ProdutosDAO.getInstance().findAll();
			
			for (Produtos a:l){
				if(a.getNome().equals(p.getNome())){
					System.out.println("Produto Ja existe"+a.getNome());
					break;
				}else{
					ProdutosDAO.getInstance().persist(p);
					break;
				}
			}
			
			
			//Method m = GenericDao.class.getDeclaredMethod("save");
			//m.setAccessible(true);			
			//m.invoke(dao);
		    //dao.save((Produtos)p);
			
			for (Produtos a:l){
				System.out.println(a.getNome()+"/"+a.getPreco());
			}
			
			
		
		
	}

}
