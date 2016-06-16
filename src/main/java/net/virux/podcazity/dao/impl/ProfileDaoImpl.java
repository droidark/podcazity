package net.virux.podcazity.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.virux.podcazity.dao.ProfileDao;
import net.virux.podcazity.model.Profile;

@Repository("profileDao")
public class ProfileDaoImpl implements ProfileDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addProfile(Profile profile) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(profile);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Profile> getAllProfiles() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Profile.class);
		List<Profile> profiles = cr.list();
		tx.commit();
		session.close();
		return profiles;
	}

	@Override
	public Profile getProfile(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Profile profile = session.get(Profile.class, id);
		tx.commit();
		session.close();
		return profile;
	}

	@Override
	public Profile getProfile(String profile) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Profile.class);
		cr.add(Restrictions.eq("profile", profile));
		tx.commit();
		session.close();
		return (Profile) cr.uniqueResult();
	}

	@Override
	public void setProfile(Profile profile) {
		
	}

	@Override
	public void deleteProfile(Profile profile) {
		
	}

}
