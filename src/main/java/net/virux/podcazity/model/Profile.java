package net.virux.podcazity.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Profile implements Serializable{

	private int idProfile;
	private String profile;
	private Set<User> users = new HashSet<User>();
	
	public Profile(){}
	
	public Profile(int idProfile, String profile) {
		this.idProfile = idProfile;
		this.profile = profile;
	}
	
	public Profile(int idProfile, String profile, Set<User> users) {
		this.idProfile = idProfile;
		this.profile = profile;
		this.users = users;
	}
	
	public int getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
//	@Override
//	public String toString() {
//		return "Profile [idProfile=" + idProfile + ", profile=" + profile + ", users=" 
//				+ users + "]";
//	}
	
}
