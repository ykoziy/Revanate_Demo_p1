package com.demo.dao;

import java.util.List;

import com.demo.model.UserAccount;
import com.demo.util.RevanateUtil;
import com.revanate.session.Session;
import com.revanate.transaction.Transaction;

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
	
	public UserAccount getById(int userId) {

		// capture a session
		Session ses = RevanateUtil.getSession();

		// start a transaction...
		Transaction tx = ses.beginTransaction();

		
		UserAccount userAccount = (UserAccount) ses.get(UserAccount.class, userId); 

		tx.commit();

		return userAccount; // returning UserAccount
	}

	public void delete(UserAccount userAccount) {
		
		Session ses = RevanateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();

		ses.delete(userAccount);

		tx.commit();
	}
	
	public int save(UserAccount userAccount) {
		
		Session ses = RevanateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();

		int id = (int) ses.save(userAccount);

		tx.commit();		
		return id;
	}
	
	public void update(UserAccount userAccount) {
		
		Session ses = RevanateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();

		ses.update(userAccount);

		tx.commit();		
	}
	
	public List<UserAccount> getAll() {
		
		// first thing is to capture a session
		Session ses = RevanateUtil.getSession();
		
		List<UserAccount> userAccount = ses.getAll(UserAccount.class).list();

		return userAccount;				
	}
}
