package com.pfe.back.BackPfe.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pfe.back.BackPfe.entities.User;
import com.pfe.back.BackPfe.responses.UserInfo;



public interface UserService {
	
	public User findByUserName(String userName);
	
	public User add(User user);

	public List<User> getUsers();
	
    public String remove(Long id);
	public User findByEmail(String destinataire);
	public User update(Long id,User user);

	public User update_motdepasse(long id, String password);
	
	public List<User> getUsersSaufAdmin();
	
	public List<User> getlisteFormateurs();
	
	public List<User> getlisteCandidats();

	public boolean verifPassword(Long id, String password);




	


}
