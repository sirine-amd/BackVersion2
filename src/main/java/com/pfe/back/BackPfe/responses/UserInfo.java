package  com.pfe.back.BackPfe.responses;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserInfo {
	private long id;
	private String nom;
	private String prenom;
	private String userName;
	@DateTimeFormat (pattern = "Yyyy-mm-dd")
	private Date date_de_naissance;
	private String Genre;
	private String numero_de_telephone;
	//à corriger 
	private String adressse;
	private String etat_civil;
	private String email;
	private Object roles;
    private String password;
    @DateTimeFormat (pattern = "Yyyy-mm-dd")
    private Date createdAt;
	private Long  idimage;
    @DateTimeFormat (pattern = "Yyyy-mm-dd")
	private Date updatedAt;
    @DateTimeFormat (pattern = "Yyyy-mm-dd")
    private Date lastLogin;

	

	public UserInfo(long id, String nom, String prenom, String userName, Date date_de_naissance, String genre,
			String numero_de_telephone, String adressse, String etat_civil, String email, Object roles, String password,
			Date createdAt, Long idimage, Date updatedAt, Date lastLogin) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.userName = userName;
		this.date_de_naissance = date_de_naissance;
		Genre = genre;
		this.numero_de_telephone = numero_de_telephone;
		this.adressse = adressse;
		this.etat_civil = etat_civil;
		this.email = email;
		this.roles = roles;
		this.password = password;
		this.createdAt = createdAt;
		this.idimage = idimage;
		this.updatedAt = updatedAt;
		this.lastLogin = lastLogin;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")

	public Date getLastLogin() {
		return lastLogin;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Long getIdimage() {
		return idimage;
	}

	public void setIdimage(Long idimage) {
		this.idimage = idimage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")

	public Date getDate_de_naissance() {
		return date_de_naissance;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")

	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getNumero_de_telephone() {
		return numero_de_telephone;
	}

	public void setNumero_de_telephone(String numero_de_telephone) {
		this.numero_de_telephone = numero_de_telephone;
	}

	public String getAdressse() {
		return adressse;
	}

	public void setAdressse(String adressse) {
		this.adressse = adressse;
	}

	public String getEtat_civil() {
		return etat_civil;
	}

	public void setEtat_civil(String etat_civil) {
		this.etat_civil = etat_civil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Object getRoles() {
		return roles;
	}

	public void setRoles(Object roles) {
		this.roles = roles;
	}

	

	public UserInfo() {
		super();
	}
	


	
	
	
}
