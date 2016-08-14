package com.jobshopalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Job {
	/*
	 * Static Data members
	 */
	private static int NUMMACHINE;
	private static int NUMJOBS;
	/*
	 * Data Members
	 */
	private int jobIndex;	
	private List<Operation> operationList;
	
	// Constructor
	public Job ( int jobIndex, Map<Integer, Map<String,Integer>> operationsMap) {
		this.jobIndex = jobIndex;			
		this.operationList = generateOperationList(jobIndex, operationsMap);
	}

	// Getters and Setters for static members
	public static int getNumMachine() {
		return NUMMACHINE;
	}

	public static void setNumMachine(int numMachine) {
		Job.NUMMACHINE = numMachine;
	}

	public static int getNumJobs() {
		return NUMJOBS;
	}

	public static void setNumJobs(int numJobs) {
		Job.NUMJOBS = numJobs;
	}

	// Getters & Setters
	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}
	
	public int getJobNumber() {
		return jobIndex;
	}

	public void setJobNumber(int jobNumber) {
		this.jobIndex = jobNumber;
	}

	// Generate Operations
	public List<Operation> generateOperationList(int jobIndex, Map<Integer, Map<String,Integer>> operationsMap) {
		List<Operation> operations = new ArrayList<Operation>();
		
		// New Generate operation logic
		for (Map.Entry<Integer, Map<String,Integer>> entry : operationsMap.entrySet()) {
			int operationIndex = entry.getKey();
			int operationMachineIndex = entry.getValue().get("mIndex");
			int operationProcessingTime = entry.getValue().get("pTime");
			
			Operation newOperation = new Operation(jobIndex + 1, operationIndex, operationMachineIndex, operationProcessingTime);
			operations.add(newOperation);
		}
		
		return operations;
	}
	
	// To display a Job
	// For example 4th job of 3 operations will be displayed as
	// Job[O(1,1) O(1,2) O(1,3)]
	@Override
	public String toString() {
		String jobString = "";
		
		jobString += "Job[";
		
		for (Operation o : this.operationList) {
			jobString += o.toString() + " "; 
		}
		
		jobString = jobString.trim() + "]";
		
		return jobString;
	}

}
