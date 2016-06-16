package net.virux.podcazity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.virux.podcazity.dao.ProfileDao;
import net.virux.podcazity.model.Profile;
import net.virux.podcazity.service.ProfileService;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileDao profileDao;

	@Override
	public void addProfile(Profile profile) {
		profileDao.addProfile(profile);
		
	}

	@Override
	public List<Profile> getAllProfiles() {
		return profileDao.getAllProfiles();
	}

	@Override
	public Profile getProfile(int id) {
		return profileDao.getProfile(id);
	}

	@Override
	public Profile getProfile(String profile) {
		return profileDao.getProfile(profile);
	}

	@Override
	public void setProfile(Profile profile) {
		profileDao.setProfile(profile);
		
	}

	@Override
	public void deleteProfile(Profile profile) {
		profileDao.deleteProfile(profile);
	}

}
