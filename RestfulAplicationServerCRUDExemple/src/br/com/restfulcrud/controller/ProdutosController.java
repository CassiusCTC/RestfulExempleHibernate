package br.com.restfulcrud.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.restfulcrud.dao.ProdutosDAO;
import br.com.restfulcrud.model.Produtos;

public class ProdutosController {
	public ArrayList<Produtos> listarTodos(){
		System.out.println("Enviando para o GIT");
		return (ArrayList<Produtos>) ProdutosDAO.getInstance().findAll();
	}
	
	public Produtos findById(Integer id){
		System.out.println("Enviando para o GIT");
		return ProdutosDAO.getInstance().getById(id);
	}
	
	public String add(Produtos p){
		ArrayList<Produtos>list =(ArrayList<Produtos>) ProdutosDAO.getInstance().findAll();
		String resp = null;
		
		if(list.size()==0){
			ProdutosDAO.getInstance().persist(p);
			resp = "Produto adicionado com sucesso.;0";
		}else{			
			for(Produtos x:list){
				if(x.getNome().equals(p.getNome())){
					resp = "Erro: produto já existe na base de dados.;1";
					
				}else{
					ProdutosDAO.getInstance().persist(p);
					resp = "Produto adicionado com sucesso.;0";
				}
			}
		}
	    return resp;		
	}
	public String delete(Integer id){
		ArrayList<Produtos>list =(ArrayList<Produtos>) ProdutosDAO.getInstance().findAll();
		String resp = null;
		
		if(list.size()==0){
			resp = "Não há produtos a serem removidos.;0";
		}else{			
			for(Produtos x:list){
				if(x.getId()==id){
					ProdutosDAO.getInstance().removeById(id);
					resp = "Produto adicionado com sucesso.;0";
				}else{
					resp = "Erro: produto não existe na base de dados.;1";
				}
			}
		}
	    return resp;		
	}
	public String atualizar(Produtos p){
		
		String resp = null;
		Produtos modf=new Produtos();
		modf=ProdutosDAO.getInstance().getById(p.getId());
		if(modf==null){
			resp = "Produto nao encontrado.;1";
		}else{
			ProdutosDAO.getInstance().merge(modf);
			resp = "Produto adicionado com sucesso.;0";
		}
				
	    return resp;		
	}
	

}
