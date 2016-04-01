package fms.model.manager;

import fms.dao.ProblemHibernateDAO;
import fms.model.maintenance.ProblemInterface;

public class ProblemManager {

	private ProblemHibernateDAO problemDAO = new ProblemHibernateDAO();
	
	public void addProblem(ProblemInterface problem) {
		try {
			problemDAO.addProblem(problem);
	    } catch (Exception se) {
	      System.err.println("ProblemManager: Threw a Exception adding problem.");
	      System.err.println(se.getMessage());
	    }
	}
	
	public ProblemInterface findProblemById(int problemId) {
		try {
			ProblemInterface problem = problemDAO.retrieveProblem(problemId);
	    	return problem;
	    } catch (Exception se) {
	      System.err.println("ProblemManager: Threw a Exception retrieving problem.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	public void deleteProblem(ProblemInterface problem) {
		
		try {
			problemDAO.deleteProblem(problem);
	    } catch (Exception se) {
	      System.err.println("ProblemManager: Threw a Exception retrieving problem.");
	      System.err.println(se.getMessage());
	    }
	}
}
