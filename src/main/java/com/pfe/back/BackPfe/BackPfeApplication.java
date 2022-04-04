package com.pfe.back.BackPfe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.pfe.back.BackPfe.EmailSender.SendEmailService;
import com.pfe.back.BackPfe.EmailSender.emailinfo;
import com.pfe.back.BackPfe.entities.Authority;
import com.pfe.back.BackPfe.entities.FileDB;
import com.pfe.back.BackPfe.entities.User;
import com.pfe.back.BackPfe.repository.UserDetailsRepository;
import com.pfe.back.BackPfe.services.AuthorityService;

@SpringBootApplication
public class BackPfeApplication {

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private com.pfe.back.BackPfe.services.FileStorageService FileStorageService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private SendEmailService SES;
	public static void main(String[] args) {
		SpringApplication.run(BackPfeApplication.class, args);
		
	}
	
	@PostConstruct
	protected void init() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Authority a = new Authority(null, "Admin");
		Authority b = new Authority(null, "User_Candidat");
		Authority c = new Authority(null, "User_Professer");

		authorityService.add(a);
		authorityService.add(b);
		authorityService.add(c);
		

		
		User user=new User();
		user.setUserName("sirine");
		user.setNom("sirine");
	    user.setPrenom("amdouni");
	    user.setPassword(passwordEncoder.encode("sirine123"));
		user.setAdresse("mornaguia");
		user.setEmail("amdounisirine80@gmail.com");
		user.setNumero_de_telephone("+216 22929388");
		try {
			user.setDate_de_naissance(formatter.parse("2000-04-02"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setGenre("Femme");
		user.setEtat_civil("Celibataire");
		user.setAuthority(a);
		user.setCreatedAt(new Date(2021-9-25));
		user.setLastLogin(new Date(2022-1-20));
	
		
User user3=new User();
		
		user3.setUserName("rania");
		user3.setNom("sazr");
	    user3.setPrenom("erer");
	    user3.setPassword(passwordEncoder.encode("rania123"));
		user3.setAdresse("mornaguia");
		user3.setEmail("amdounisirine80@gmail.com");
		user3.setNumero_de_telephone("+216 22929388");
		user3.setDate_de_naissance(new Date(2000-05-25));
		user3.setGenre("Femme");
		user3.setEtat_civil("Celibataire");
		user3.setAuthority(b);
		user3.setCreatedAt(new Date(2022-01-25));
		user3.setLastLogin(new Date(2022-02-20));
	
User user2=new User();
		
		user2.setUserName("sarra");
		user2.setNom("mannai");
	    user2.setPrenom("sarra");
	    user2.setPassword(passwordEncoder.encode("sarra123"));
		user2.setAdresse("mornaguia");
		user2.setEmail("sarramnaai80@gmail.com");
		user2.setNumero_de_telephone("+216 22929388");
		user2.setDate_de_naissance(new Date(2000-05-25));
		user2.setGenre("Femme");
		user2.setEtat_civil("Celibataire");
		user2.setAuthority(c);
		user2.setCreatedAt(new Date(2021-01-25));
		user2.setLastLogin(new Date(2021-01-01));
	
		userDetailsRepository.save(user);
		userDetailsRepository.save(user2);
		userDetailsRepository.save(user3);

        emailinfo M= new emailinfo();
        M.setBody("hello");
        M.setDestinataire("amdounisirine80@gmail.com");
		SES.ajouterMail(M);
		
	}
	
	
}
