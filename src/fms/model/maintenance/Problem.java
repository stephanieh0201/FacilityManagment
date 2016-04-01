package fms.model.maintenance;

public class Problem implements ProblemInterface {
	private int problemID;
	private String problem;
	private int requestID;
	
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

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

}