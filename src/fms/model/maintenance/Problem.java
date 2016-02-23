package fms.model.maintenance;

public class Problem {
	private int problemID;
	private String problem;

	
	public Problem(){}
	
	
	public int getProblemID() {
		return problemID;
	}
	public void setProblemID(int problemID) {
		this.problemID = problemID;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String toString(){
		return "ProblemID " + getProblemID() + ": " + getProblem();
		
	}

}