package com.example.Tp_JarX.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Tp_JarX.dao.CompteRepository;
import com.example.Tp_JarX.entities.Compte;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
	
	@Autowired
	private CompteRepository compteRepository;
	
	@GET
	@Path("/comptes")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Compte> getComptes(){
		return compteRepository.findAll();
	}
	
	@GET
	@Path("/compte/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Compte getCompte(@PathParam("id") Long id){
		return compteRepository.findById(id).orElse(null);
	}

	@POST
	@Path("/comptes")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Compte addCompte(Compte compte) {
	    return compteRepository.save(compte);
	}

	@PUT
	@Path("/comptes/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
	    Compte existingCompte = compteRepository.findById(id).orElse(null);
	    if (existingCompte != null) {
	        existingCompte.setSolde(compte.getSolde());
	        existingCompte.setDateCreation(compte.getDateCreation());
	        existingCompte.setType(compte.getType());
	        return compteRepository.save(existingCompte);
	    }
	    return null;
	}

	@Path("/comptes/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deleteCompte(@PathParam("id") Long id) {
	    compteRepository.deleteById(id);
	}

}
