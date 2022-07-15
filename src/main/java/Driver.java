import com.demo.dao.UserAccountDao;
import com.demo.model.UserAccount;

public class Driver {

	public static void main(String[] args) {
		 UserAccount user1 = new UserAccount("askae0",  "Adamo",   "Skae",    "NYhmsmZ0xbB", "askae0@geocities.jp");
		 UserAccount user2 = new UserAccount("sverner1",    "Stern",   "Verner",  "b8BeGA",  "sverner1@economist.com");
		 UserAccount user3 = new UserAccount("dcholwell2",  "Demetra", "Cholwell",    "tKIJK9aPLDF", "dcholwell2@friendfeed.com");
		 UserAccount user4 = new UserAccount("mwarrick3",   "Mareah",  "Warrick", "P8J2Xf7XDBl", "mwarrick3@answers.com");
		 UserAccount user5 = new UserAccount("gmacgillivrie4",  "Gale",    "MacGillivrie",    "PFaNXJXcfl",  "gmacgillivrie4@chicagotribune.com");
		
		 UserAccountDao userDao = new UserAccountDao();
		 
		 int id = userDao.save(user5);
		 
		 UserAccount gotUser = userDao.getById(id);
		 
		 System.out.println(gotUser);
		 
	}

}
