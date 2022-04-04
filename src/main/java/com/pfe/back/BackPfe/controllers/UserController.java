
  package com.pfe.back.BackPfe.controllers;
  import com.pfe.back.BackPfe.entities.FileDB;

  import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import
  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import
  org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.pfe.back.BackPfe.entities.Authority;
import com.pfe.back.BackPfe.entities.FileDB;
import com.pfe.back.BackPfe.entities.User;
import com.pfe.back.BackPfe.responses.ResponsePassword;
import com.pfe.back.BackPfe.responses.UserInfo;
import com.pfe.back.BackPfe.services.AuthorityService;
import
  com.pfe.back.BackPfe.services.UserService;
  @CrossOrigin(origins = "http://localhost:3000")

  @RestController
  
  @RequestMapping("/api/users") 
  public class UserController {
	  @Autowired private AuthorityService authorityService;

  @Autowired private UserService userService;
  @Autowired
  private com.pfe.back.BackPfe.services.FileStorageService storageService;

  public UserController() { // TODO Auto-generated constructor stub 
	  }
  
  @DeleteMapping(value="/deleteuser/{id}")
  public String delete(@PathVariable(name="id") Long id ){


	  return userService.remove(id);
	  
  }
  
  @GetMapping("/profsEtCandidats")
  public List<User> getUsersSaufAdmin() { 
	  return userService.getUsersSaufAdmin();
  
  }
  
  @GetMapping("/formateurs")
  public List<User> getlisteFormateurs() { 
	  return userService.getlisteFormateurs();
  
  }
  @GetMapping("/candidats")
  public List<User> getlisteCandidats() { 
	  return userService.getlisteCandidats();
  
  }
  
  @PostMapping("/addResponsable") public ResponseEntity<?> AddResponsable(@RequestBody UserInfo
		  U) throws IOException { 
		  
		  Authority A= authorityService.findByRoleName((String) U.getRoles());
		  
		  SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
		  Calendar calendar = Calendar.getInstance();
		  
		  Date dateObj = calendar.getTime();
		  
		  User U1 =new User(); 
		  U1.setAdresse(U.getAdressse()); 
		  U1.setNom(U.getNom());
		  U1.setPrenom(U.getPrenom()); 
		  U1.setPassword(U.getPassword());
		  U1.setGenre(U.getGenre()); 
		  U1.setDate_de_naissance(U.getDate_de_naissance());
		  U1.setEmail(U.getEmail()); 
		  U1.setEtat_civil(U.getEtat_civil());
		  U1.setUserName(U.getUserName()); 
		  U1.setAuthority(A);
		  U1.setNumero_de_telephone(U.getNumero_de_telephone());
		  U1.setCreatedAt(dateObj); 
		  
		   if (userService.findByEmail(U1.getEmail())!=null && userService.findByUserName(U1.getUserName())!=null)
		  {
			  return new ResponseEntity<>("Email et Username sont déja utilisés ",HttpStatus.BAD_REQUEST);
		  }
		   else if(userService.findByUserName(U1.getUserName())!=null ) {
			  return new ResponseEntity<>("Username déja utilisé",HttpStatus.BAD_REQUEST);
		  }
		  else if(userService.findByEmail(U1.getEmail())!=null)
		  {
			  return new ResponseEntity<>("Email déja utilisé",HttpStatus.BAD_REQUEST);
		  }
		  
		
		  else {
				userService.add(U1);
			
		
		  return ResponseEntity.ok("Responsable ajouté avec succée");
		  }
		  }
  
  @PutMapping("/updateUser/{id}")
  public User updateUser(@PathVariable(value="id") Long id,@RequestBody UserInfo U) {
		System.out.println("ok");

	  FileDB FileDB ;
	  Long IDimage = U.getIdimage();
			  if(IDimage==0)
			  { FileDB=null;}
			  else
	   FileDB = storageService.getFile(U.getIdimage());
	  Authority A= authorityService.findByRoleName((String) U.getRoles());
	  
	  SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
	  Calendar calendar = Calendar.getInstance();
	  
	  Date dateObj = calendar.getTime();
	  
	  User U1 =new User(); 
	  U1.setAdresse(U.getAdressse()); 
	  U1.setNom(U.getNom());
	  U1.setPrenom(U.getPrenom()); 
	  U1.setPassword(U.getPassword());
	  U1.setGenre(U.getGenre()); 
	  U1.setDate_de_naissance(U.getDate_de_naissance());
	  U1.setEmail(U.getEmail()); 
	  U1.setEtat_civil(U.getEtat_civil());
	  U1.setUserName(U.getUserName()); 
	  U1.setAuthority(A);
	  U1.setNumero_de_telephone(U.getNumero_de_telephone());
	  U1.setCreatedAt(U.getCreatedAt()); 
	  U1.setImage(FileDB);
	  U1.setUpdatedAt(dateObj);
	
	return userService.update(id, U1);

}
  @PostMapping("/verifPassword")
  public boolean verifPassword(@RequestBody ResponsePassword RP) { 
	   return userService.verifPassword(RP.getId(),RP.getPassword());
  
  }
  }
 
