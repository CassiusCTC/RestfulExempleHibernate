package br.com.restfulcrud.resource;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
@Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class ProdutosResource {

	
	@GET
	@Path("/findall")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarTodos(){
		ProdutosController pc=new ProdutosController();
		return Response.ok().entity(new GenericEntity<ArrayList<Produtos>>(pc.listarTodos()){			
		}).header("Access-Control-Allow-Origin","*")
		  .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
	/*@GET 
	// utilizando apenas o verbo GET, ou seja, vou apenas ler o recurso 
	@Produces("text/plain") 
	// define qual tipo MIME é retornado para o cliente 
	public String exibir(){ return "Hello World"; }*/
	
	@GET
	@Path("/find/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response find(@PathParam(value="id") String id){
		ProdutosController pc= new ProdutosController();
		Produtos p = pc.findById(Integer.valueOf(id));
		if(p==null){
			return null;
		}
		return Response.ok().entity(new GenericEntity<Produtos>(p){			
		}).header("Access-Control-Allow-Origin","*")
		  .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
	@POST
	@Path("/add")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response add(Produtos p){
		ProdutosController pc= new ProdutosController();
		String resp = pc.add(p);
		if(p==null){
			return null;
		}
		return Response.ok().entity(new GenericEntity<String>(resp){			
		}).header("Access-Control-Allow-Origin","*")
		  .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response delete(@PathParam(value="id") String id){
		ProdutosController pc= new ProdutosController();
		String resp = pc.delete(Integer.valueOf(id));
		
		return Response.ok().entity(new GenericEntity<String>(resp){			
		}).header("Access-Control-Allow-Origin","*")
		  .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	@PUT
	@Path("/editar")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response editar(Produtos p){
		ProdutosController pc= new ProdutosController();
		String resp = pc.atualizar(p);
		return Response.ok().entity(new GenericEntity<String>(resp){			
		}).header("Access-Control-Allow-Origin","*")
		  .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
	
	
	
	
	

}
