package br.com.restfulcrud.resource;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.restfulcrud.controller.ProdutosController;
import br.com.restfulcrud.model.Produtos;

/**
 * 
 * Classe responsável por conter os metodos REST de acesso ao webservice
 *
 * 
 */
@Path("/produtos")
public class ProdutosResource {

	
	@GET
	@Path("/findall")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Produtos> listarTodos(){
		return new ProdutosController().listarTodos();
	}
	
	/*@GET 
	// utilizando apenas o verbo GET, ou seja, vou apenas ler o recurso 
	@Produces("text/plain") 
	// define qual tipo MIME é retornado para o cliente 
	public String exibir(){ return "Hello World"; }*/

}
