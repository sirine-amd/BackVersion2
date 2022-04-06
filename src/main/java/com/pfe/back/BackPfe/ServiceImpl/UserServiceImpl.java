package  com.pfe.back.BackPfe.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pfe.back.BackPfe.entities.FileDB;
import  com.pfe.back.BackPfe.entities.User;
import  com.pfe.back.BackPfe.repository.UserDetailsRepository;
import com.pfe.back.BackPfe.responses.UserInfo;
import  com.pfe.back.BackPfe.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDetailsRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public User findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}	

	public User findByEmail(String destinataire)
    {
		return userRepo.findByEmail(destinataire);
				  

    }
	
	
	@Override
	public User add(User user) {
		String pwd = user.getPassword();
		user.setPassword(passwordEncoder.encode(pwd));
		
		return userRepo.save(user);
	}

	@Override
	public List<User> getUsers() {

		return userRepo.findAll();
	}
	@Override
	public User update(Long id,User user)
	{		  
	Optional<User> user1=userRepo.findById(id);
	if(user1.isPresent())
	{
		User user2=user1.get();
		user2.setAdresse(user.getAdresse());
		user2.setAuthority(user.getAuthority());
		user2.setNom(user.getNom());
		user2.setPrenom(user.getPrenom());
		user2.setEmail(user.getEmail());
		user2.setGenre(user.getGenre());
		user2.setEtat_civil(user.getEtat_civil());
		user2.setUserName(user.getUsername());
		user2.setNumero_de_telephone(user.getNumero_de_telephone());
		user2.setCreatedAt(user.getCreatedAt());
		user2.setUpdatedAt(user.getUpdatedAt());
		user2.setImage(user.getImage());
		user2.setLastLogin(user.getLastLogin());
		user2.setDate_de_naissance(user.getDate_de_naissance());
		return userRepo.save(user2);
	}
	return null;
	
	}



	@Override
	public User update_motdepasse(long id, String password) {
		Optional<User> user1=userRepo.findById(id);
		if(user1.isPresent())
		{
			User user2=user1.get();
			user2.setPassword(passwordEncoder.encode(password));
			return userRepo.save(user2);		
			}
		return null;
	}

	@Override
	public List<User> getUsersSaufAdmin() {
		List<User> Users = userRepo.findAll();
		
		List<User> UsersSansAdmin = new ArrayList<User>();
		for(int i=0;i<Users.size();i++) {
			
			if(Users.get(i).getAuthority().getRoleName().equals("User_Professer") || Users.get(i).getAuthority().getRoleName().equals("User_Candidat")) 
			{
				UsersSansAdmin.add(Users.get(i));
			}
		}
		return UsersSansAdmin;
	}

	@Override
	public List<User> getlisteFormateurs() {
		
	List<User> Users = userRepo.findAll();
		
		List<User> formateurs = new ArrayList<User>();
		for(int i=0;i<Users.size();i++) {
			
			if(Users.get(i).getAuthority().getRoleName().equals("User_Professer")) 
			{
				formateurs.add(Users.get(i));
			}
		}
		return formateurs;	
		}

	@Override
	public List<User> getlisteCandidats() {
		List<User> Users = userRepo.findAll();
		
		List<User> candidats = new ArrayList<User>();
		for(int i=0;i<Users.size();i++) {
			
			if(Users.get(i).getAuthority().getRoleName().equals("User_Candidat")) 
			{
				candidats.add(Users.get(i));
			}
		}
		return candidats;	
	}

	@Override
	public String remove(Long id) {
		userRepo.deleteById(id);
		return "utilisateur supprimé avec succes";
	}
	
	@Override
	public boolean verifPassword(Long id, String password) {
		Optional<User> user1=userRepo.findById(id);
		User user2=user1.get();
		if(passwordEncoder.matches(password,user2.getPassword()))
		{return true;}
		else return false;
	}

	public boolean updateUserNaeme(Long id, String userName) {
		User user1=userRepo.findByUserName(userName);
				if(user1!=null)
				{
					return false;

				}
				else
				{
					Optional<User> user2=userRepo.findById(id);
					if(user2.isPresent())
					{
						User user3=user2.get();
						user3.setUserName(userName);
						 userRepo.save(user3);
						 return true;

				}
					else return false;
		
	}}

	@Override
	public boolean updateEmail(Long id, String email) {
		User user1=userRepo.findByEmail(email);
		if(user1!=null)
		{
			return false;

		}
		else
		{
			Optional<User> user2=userRepo.findById(id);
			if(user2.isPresent())
			{
				User user3=user2.get();
				user3.setEmail(email);
				 userRepo.save(user3);
				 return true;

		}
			else return false;

}}

	@Override
	public boolean updateimage(Long id,FileDB fileDB) {
		
		Optional<User> user=userRepo.findById(id);
		if(user.isPresent())
		{
			
			User user1=user.get();
			user1.setImage(fileDB);
			 userRepo.save(user1);
			 return true;

	}
		else return false;	}
}
