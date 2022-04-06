package com.pfe.back.BackPfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.back.BackPfe.entities.Formation;
import com.pfe.back.BackPfe.entities.User;
import com.pfe.back.BackPfe.entities.demande_inscription;
import com.pfe.back.BackPfe.responses.UserInfo;
import com.pfe.back.BackPfe.services.AuthorityService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController

@RequestMapping("/api/demandes_inscription") 
public class demande_inscriptionController {
	  @Autowired private com.pfe.back.BackPfe.services.demande_inscriptionService demande_inscriptionService;

		@GetMapping("/all")
	    public List<demande_inscription> getAllDemandes_inscriptions(){
		   return demande_inscriptionService.getDemandes_inscriptions();}
	    @GetMapping("/formations")
	    public List<demande_inscription> getAllDemandes_inscriptionsFormations(){
		   return demande_inscriptionService.getDemandes_inscriptionsFormation();}
	    @GetMapping("/historiques")
	    public List<demande_inscription> gethistorique(){
		   return demande_inscriptionService.gethistorique();}
	  
	    @GetMapping("/examens")
	    public List<demande_inscription> getAllDemandes_inscriptionsExamens(){
		   return demande_inscriptionService.getDemandes_inscriptionsExamen();}
		
	    @DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
	    	demande_inscriptionService.deleteFormation(id);
	    }
	    
	    @PostMapping("/addDemande")
		public demande_inscription add(@RequestBody demande_inscription demande_inscription) {
	    	return demande_inscriptionService.adddemande_inscription(demande_inscription);
	    }
	    @PutMapping("/accepterdemande/{id}")
	    public boolean accepterdemande(@PathVariable(value="id") Long id) {
	    	return demande_inscriptionService.accepterdemande(id)	 ;   }
	    
	    @PutMapping("/refuserdemande/{id}")
	    public boolean refuserdemande(@PathVariable(value="id") Long id) {
			System.out.println("ok");
			System.out.println(id);

	    	return demande_inscriptionService.refuserdemande(id)	 ;   }
}
