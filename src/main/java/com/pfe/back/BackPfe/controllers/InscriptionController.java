package  com.pfe.back.BackPfe.controllers;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.back.BackPfe.entities.Authority;
import com.pfe.back.BackPfe.entities.FileDB;
import com.pfe.back.BackPfe.entities.User;
import com.pfe.back.BackPfe.responses.MessageResponse;
import com.pfe.back.BackPfe.responses.UserInfo;
import com.pfe.back.BackPfe.services.AuthorityService;
import com.pfe.back.BackPfe.services.UserService;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class InscriptionController {
	
	@Autowired
	private UserService userService;
	
	
	  @Autowired private AuthorityService authorityService;
	  @Autowired
	  private com.pfe.back.BackPfe.services.FileStorageService storageService;
	 

	 
	 
	
	  @PostMapping("/signup") public ResponseEntity<?> SignUp(@RequestBody UserInfo
	  U) throws IOException { 

		  FileDB fileDB = storageService.getFile(U.getIdimage());
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
	  U1.setImage(fileDB);
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
		
	
	  return ResponseEntity.ok("user ajouté avec succée");
	  }
	  }

}
