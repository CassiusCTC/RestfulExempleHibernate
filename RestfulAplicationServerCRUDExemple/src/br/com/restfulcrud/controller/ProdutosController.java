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

}
