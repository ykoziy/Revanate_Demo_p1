package com.demo;

import java.util.List;

import com.demo.dao.UserAccountDao;
import com.demo.model.UserAccount;

public class DemoPartA {
	public static void main(String[] args) {
		UserAccount user1 = new UserAccount("askae0", "Adamo", "Skae", "NYhmsmZ0xbB", "askae0@geocities.jp");
		UserAccount user2 = new UserAccount("sverner1", "Stern", "Verner", "b8BeGA", "sverner1@economist.com");
		UserAccount user3 = new UserAccount("dcholwell2", "Demetra", "Cholwell", "tKIJK9aPLDF",
				"dcholwell2@friendfeed.com");
		UserAccount user4 = new UserAccount("mwarrick3", "Mareah", "Warrick", "P8J2Xf7XDBl", "mwarrick3@answers.com");
		UserAccount user5 = new UserAccount("gmacgillivrie4", "Gale", "MacGillivrie", "PFaNXJXcfl",
				"gmacgillivrie4@chicagotribune.com");

		UserAccountDao userDao = new UserAccountDao();

		int id = userDao.save(user5);

		UserAccount gotUser = userDao.getById(id);

		System.out.println(gotUser);

		System.out.println("===================================================");

		userDao.save(user2);
		userDao.save(user3);
		userDao.save(user1);
		int id2 = (int) userDao.save(user4);

		System.out.println("====== " + id2 + " I WILL EDIT THIS ID LATER!!!!");

		// get all after adding 5 users
		List<UserAccount> list = userDao.getAll();
		list.stream().forEach(System.out::println);

		UserAccount u = userDao.getById(id2);

		u.setFirstName("SPIDERMAN");
		userDao.update(u);
		System.out.println("====== " + id2 + " I DID EDIT THIS");
		u = userDao.getById(id2);
		System.out.println(u);
	}
}
