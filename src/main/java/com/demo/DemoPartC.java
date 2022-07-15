package com.demo;

import java.sql.SQLException;

import com.demo.model.UserAccount;
import com.demo.util.RevanateUtil;
import com.revanate.session.Session;
import com.revanate.transaction.Transaction;

public class DemoPartC {

	public static void main(String[] args) {
		UserAccount user1 = new UserAccount("askae0", "Adamo", "Skae", "NYhmsmZ0xbB", "askae0@geocities.jp");
		UserAccount user2 = new UserAccount("sverner1", "Stern", "Verner", "b8BeGA", "sverner1@economist.com");
		UserAccount user3 = new UserAccount("dcholwell2", "Demetra", "Cholwell", "tKIJK9aPLDF",
				"dcholwell2@friendfeed.com");
		UserAccount user4 = new UserAccount("mwarrick3", "Mareah", "Warrick", "P8J2Xf7XDBl", "mwarrick3@answers.com");
		UserAccount user5 = new UserAccount("gmacgillivrie4", "Gale", "MacGillivrie", "PFaNXJXcfl",
				"gmacgillivrie4@chicagotribune.com");

		Session ses = RevanateUtil.getSession();
		// creating session here so transactions can be controlled manually

		Transaction tx = ses.beginTransaction();

		UserAccount[] array = new UserAccount[] { user4, user2, user3, user1 };

		// Try again
		System.out.println("\nTrying again........\n");

		tx = ses.beginTransaction();
		for (int i = 0; i < array.length / 2; i++) {
			int id = (int) ses.save(array[i]);
			System.out.println("I am saving UserAccount with ID " + id + " will it remain?");
		}

		tx.setSavepoint("savepoint!");
		System.out.println("\nJust made a save point\n");

		for (int i = array.length / 2; i < array.length; i++) {
			int id = (int) ses.save(array[i]);
			System.out.println("I am saving UserAccount with ID " + id + " will it remain?");
		}
		try {
			tx.rollback("savepoint!");
			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("=======");
	}

}
