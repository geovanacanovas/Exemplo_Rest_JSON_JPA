package webservice;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import entidades.Usuario;
import service.UserService;

@Path("/user")
public class RestUser {
	
	   //Instalar o Chrome Advanced REST Client
	   //Para abrir: chrome://apps/  -> Escolha o ARC
       //Referencia: http://o7planning.org/en/11207/simple-crud-example-with-java-restful-web-service

       
	   //Exemplo: http://localhost:8080/ProjetoWSRestJSON/rest/findById?id=9999
	   @GET
	   @Path("/findById")
	   @Produces(MediaType.APPLICATION_JSON)
       public Usuario findById(@QueryParam("id") int id){
             UserService service = new UserService();
             return service.getUserById(id);
       }
	   

	   //Exemplo: http://localhost:8080/ProjetoWSRestJSON/rest/save
	   @POST
	   @Path("/save")
	   @Produces(MediaType.APPLICATION_JSON)
       public Usuario save(Usuario user){
             UserService service = new UserService();
             return service.save(user);
       }
	   
	   
	  //Exemplo: http://localhost:8080/ProjetoWSRestJSON/rest/delete?id=99999
	   @DELETE
	   @Path("/delete")
	   @Produces(MediaType.APPLICATION_JSON)
       public void delete(@QueryParam("id") int id){
             UserService service = new UserService();
             service.delete(id);
       }
	   
	   //http://localhost:8080/ProjetoWSRestJSON/rest/user/allUsuarios
	   @GET
	   @Path("/allUsuarios")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Usuario> getAllUsers(){
		   List<Usuario> users;
		   UserService service = new UserService();
		   users = service.getAllUsarios();
	       return users;
	   }
	   

	   //http://localhost:8080/ProjetoWSRestJSON/rest/user/update
	   @PUT
	   @Path("/update")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Usuario update(Usuario user){
		   UserService service = new UserService();
		   user = service.update(user);
	       return user;
	   }
	   
	   
 
}
