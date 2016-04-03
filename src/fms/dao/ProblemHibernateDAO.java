package fms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fms.model.maintenance.ProblemInterface;

public class ProblemHibernateDAO {

	public void addProblem(ProblemInterface problem) {
		System.out.println("*************** Adding problem information in DB with ID ...  " + problem.getProblemID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(problem);
		session.getTransaction().commit();
	}
	
	public void deleteProblem(ProblemInterface problem) {
		System.out.println("*************** Deleteing problem information in DB with ID ...  " + problem.getProblemID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(problem);
		session.getTransaction().commit();
	}
	
	public ProblemInterface retrieveProblem(int problemId) {
		try {
		System.out.println("*************** Searching for problem information with ID ...  " + problemId);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
		Query getProblemQuery = session.createQuery("From Problem where problemId=:problemId");		
		getProblemQuery.setInteger("problemId", problemId);
		
		System.out.println("*************** Retrieve Query is ....>>\n" + getProblemQuery.toString()); 
		
		List problemList = getProblemQuery.list();
		System.out.println("Getting Problem Problem using HQL. \n" + problemList);

		session.getTransaction().commit();
		return (ProblemInterface)problemList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
