package net.virux.podcazity.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{

	private int idUser;
	private String username;
	private String password;
	private String alias;
	private String avatarUrl;
	private String coverUrl;
	private String description;
	private String url;
	private Date signUpDate;
	private String state;
	private boolean premium;
	private Set<Profile> profiles = new HashSet<Profile>();
	
	
	public User(){}
	
	public User(int idUser, String username, String password, String alias, 
			String avatarUrl, String coverUrl, String description, String url, 
			Date signUpDate, String state, boolean premium, Set<Profile> profiles) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.alias = alias;
		this.avatarUrl = avatarUrl;
		this.coverUrl = coverUrl;
		this.description = description;
		this.url = url;
		this.signUpDate = signUpDate;
		this.state = state;
		this.premium = premium;
		this.profiles = profiles;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getSignUpDate() {
		return signUpDate;
	}
	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	public Set<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
	
}
