package br.com.asf.service.rs;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@Stateless
//@Path("/client")
public class ClientRS {

	//@GET
	//@Path("/test")
	//@Produces(MediaType.APPLICATION_JSON)
	public String test() {
		return "Hello World!";
	}
	
	//@POST
	//@Path("/signUpClient")
	//@Consumes(MediaType.APPLICATION_JSON)
	public void signUpClient(String idCompany, String name, String cpf, String email, String password) {
	
		System.out.println(name);
	}
}
