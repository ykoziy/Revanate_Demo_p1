package com.demo.dao;

import java.util.List;

import com.demo.model.UserAccount;
import com.demo.util.RevanateUtil;
import com.revanate.session.Session;
import com.revature.dao.Transaction;
import com.revature.models.Crime;
import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

public class UserAccountDao {
	
	// this is where we store our crud methods
	public void insertWihtoutCasting(UserAccount userAccount) {
		
		// capture session
		Session ses = RevanateUtil.getSession();
		
		// we'll start a transaction, Transaction is uniquely from HIbernate
		Transaction tx = ses.beginTransaction();
		
		// to save a new entry into the database all we have to use is the .save method
		ses.save(userAccount); 
		tx.commit();
	}
	
	public int get(UserAccount userAccount) {

		// capture a session
		Session ses = RevanateUtil.getSession();

		// start a transaction... Transaction is uniquely from Hibernate
		Transaction tx = ses.beginTransaction();

		// Make sure that you have java 8 set in your properties in Maven
		int pk = (int) ses.save(userAccount); // the save() method returns the Primary Key

		tx.commit();

		return pk; // we return the generate Primary Key that DB provides for us
	}
	
//	public void get(UserAccount userAccount) {
//		
//	}

	public void delete(UserAccount userAccount) {
		
		Session ses = RevanateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();

		ses.delete(userAccount);

		tx.commit();
	}
	
	public void save(UserAccount userAccount) {
		
		Session ses = RevanateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();

		ses.save(userAccount);

		tx.commit();		
	}
	
	public void update(UserAccount userAccount) {
		
		Session ses = RevanateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();

		ses.update(userAccount);

		tx.commit();		
	}
	
	public List<UserAccount> getAll() {
		
		// first thing is to caputer a session
		Session ses = RevanateUtil.getSession();
		
		List<UserAccount> userAccount = ses.createQuery("from user_account", UserAccount.class).list();

		return userAccount;		
		
	}
}
