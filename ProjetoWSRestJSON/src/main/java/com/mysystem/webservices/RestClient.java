package com.mysystem.webservices;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysystem.entities.Client;
import com.mysystem.services.ClientService;

@Path("/client")
public class RestClient {
	
	   //Instalar o Chrome Advanced REST Client
	   //Para abrir: chrome://apps/  -> Escolha o ARC
       //Referencia: http://o7planning.org/en/11207/simple-crud-example-with-java-restful-web-service

       
	   //Exemplo: http://localhost:8080/ProjetoWSRestJSON/rest/client/findById?id=9999
	   @GET
	   @Path("/findById")
	   @Produces(MediaType.APPLICATION_JSON)
       public Client findById(@QueryParam("id") int id){
             ClientService service = new ClientService();
             return service.getUserById(id);
       }
	   

	   //Exemplo: http://localhost:8080/ProjetoWSRestJSON/rest/client/save
	   @POST
	   @Path("/save")
	   @Produces(MediaType.APPLICATION_JSON)
       public Client save(Client client){
             ClientService service = new ClientService();
             return service.save(client);
       }
	   
	   
	  //Exemplo: http://localhost:8080/ProjetoWSRestJSON/rest/client/delete?id=99999
	   @DELETE
	   @Path("/delete")
	   @Produces(MediaType.APPLICATION_JSON)
       public void delete(@QueryParam("id") int id){
             ClientService service = new ClientService();
             service.delete(id);
       }
	   
	   //http://localhost:8080/ProjetoWSRestJSON/rest/user/client/all
	   @GET
	   @Path("/all")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Client> getAllClients(){
		   List<Client> clients;
		   ClientService service = new ClientService();
		   clients = service.getAllClients();
	       return clients;
	   }
	   

	   //http://localhost:8080/ProjetoWSRestJSON/rest/user/update
	   @PUT
	   @Path("/update")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Client update(Client user){
		   ClientService service = new ClientService();
		   user = service.update(user);
	       return user;
	   }
	   
	   
 
}
