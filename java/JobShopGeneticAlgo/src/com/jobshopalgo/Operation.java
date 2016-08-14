package com.jobshopalgo;

public class Operation {
	
	/*
	 * Data Members
	 */
	// Index of a Job
	private int jobIndex;
	
	// Index of an Operation
	private int operationIndex;
	
	// Index of the machine
	private int machineIndex;
	
	// Processing time of an operation
	private int procesingTime;
	
	// Constructor
	public Operation (int jobIndex, int operationIndex, int machineIndex, int procesingTime) {
		this.jobIndex = jobIndex;
		this.operationIndex = operationIndex;
		this.machineIndex = machineIndex;
		this.procesingTime = procesingTime;		
	}

	// Getters and Setters
	public int getJobIndex() {
		return jobIndex;
	}

	public void setJobIndex(int jobIndex) {
		this.jobIndex = jobIndex;
	}

	public int getOperationIndex() {
		return operationIndex;
	}

	public void setOperationIndex(int operationIndex) {
		this.operationIndex = operationIndex;
	}
	
	public int getProcesingTime() {
		return procesingTime;
	}

	public void setProcesingTime(int procesingTime) {
		this.procesingTime = procesingTime;
	}

	public int getMachineIndex() {
		return machineIndex;
	}

	public void setMachineIndex(int machineIndex) {
		this.machineIndex = machineIndex;
	}

	// To display an Operation
	// For example to display an Operation of second job and third operation will be displayed as
	// O(2,3)
	@Override
	public String toString() {
		return "O(" + this.jobIndex + ", " + this.operationIndex + " <" + this.machineIndex + "|" + this.procesingTime + ">" + ")";
		
	}
}

