package com.scm.gsoft.dao.inv;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractSession {
	
	@Autowired
	@Qualifier("invSessionFactory")
	private SessionFactory invSessionFactory;
	
	@Autowired
	@Qualifier("cxcSessionFactory")
	private SessionFactory cxcSessionFactory;
	
	protected Session getInvSession() {
		
		return invSessionFactory.getCurrentSession();
		
	}
	
	protected Session getCxcSession() {
		
		return cxcSessionFactory.getCurrentSession();
		
	}

}
