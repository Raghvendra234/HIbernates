package com.session;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Answer;
import com.entity.Question;


public class Main {

	public static void main(String[] args) 
	{
	try
	{
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory fs=cfg.buildSessionFactory();
	Session session=fs.openSession();

	System.out.println(session);
	
	Transaction ts=session.beginTransaction();
	
	//Creating Question
	
	Question q=new Question();
	//q.setQuestionId(133);
	q.setQuestion("What is Jsp ?");

    Question q2=new Question();
    //q.setQuestionId(232);
	q2.setQuestion("What is Servlet ?");
	
	
	
	// creating Answer
	
	Answer ans=new Answer();
    //ans.setAnswerId(244);
	ans.setAnswer("JSP is a server side technology...");
	
	Answer ans2=new Answer();
	//ans.setAnswerId(344);
	ans2.setAnswer("Servlet is a server side technology..");
	
	
	q.setAnswer(ans);
	q2.setAnswer(ans2);
	
	
	
	
	session.save(q);
	session.save(q2);
	session.save(ans);
	session.save(ans2);
	
	
	
	ts.commit();
	//session.close();
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
