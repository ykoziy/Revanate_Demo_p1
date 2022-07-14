package com.demo.util;

import com.revanate.config.Configuration;
import com.revanate.session.Session;
import com.revanate.session.SessionManager;

public class RevanateUtil {

	private static Session ses;

	private static SessionManager sm = new Configuration().configure("revanate.cfg.xml").buildSessionManager();

	public static Session getSession()
	{
		if (ses == null)
		{
			ses = sm.openSession();
		}
		return ses;
	}

	public static void closeSes()
	{
		ses.close();
	}
}
