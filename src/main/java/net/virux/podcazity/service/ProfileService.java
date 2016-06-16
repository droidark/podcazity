package net.virux.podcazity.service;

import java.util.List;

import net.virux.podcazity.model.Profile;

public interface ProfileService {
	
	void addProfile(Profile profile);
	
	List<Profile> getAllProfiles();
	
	Profile getProfile(int id);
	
	Profile getProfile(String profile);
	
	void setProfile(Profile profile);
	
	void deleteProfile(Profile profile);

}
