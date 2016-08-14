package com.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JobPropertiesBean {
	/*
	 * data memebers
	 */
	private int numOfJobs;
	private int numOfMachines;
	private int populationSize;
	private int bestPoolSize;
	private int crossoverSize;
	private int mutationSize;
	
	private List<Map<Integer, Map<String, Integer>>> jobsDetailsMapList;
	
	/*
	 * Constructor
	 */
	public JobPropertiesBean () {
		this.numOfJobs = 0;
		this.numOfMachines = 0;
		this.populationSize = 0;
		
		this.jobsDetailsMapList = new ArrayList<Map<Integer,Map<String,Integer>>>();
		
	}
	
	public int getNumOfJobs() {
		return numOfJobs;
	}
	public void setNumOfJobs(int numOfJobs) {
		this.numOfJobs = numOfJobs;
	}
	public int getNumOfMachines() {
		return numOfMachines;
	}
	public void setNumOfMachines(int numOfMachines) {
		this.numOfMachines = numOfMachines;
	}
	public int getPopulationSize() {
		return populationSize;
	}
	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public List<Map<Integer, Map<String, Integer>>> getJobsDetailsMapList() {
		return jobsDetailsMapList;
	}

	public void setJobsDetailsMapList(
			List<Map<Integer, Map<String, Integer>>> jobsDetailsMap) {
		this.jobsDetailsMapList = jobsDetailsMap;
	}
	
	
	public int getBestPoolSize() {
		return bestPoolSize;
	}

	public void setBestPoolSize(int bestPoolSize) {
		this.bestPoolSize = bestPoolSize;
	}

	public int getCrossoverSize() {
		return crossoverSize;
	}

	public void setCrossoverSize(int crossoverSize) {
		this.crossoverSize = crossoverSize;
	}

	public int getMutationSize() {
		return mutationSize;
	}

	public void setMutationSize(int mutationSize) {
		this.mutationSize = mutationSize;
	}

	@Override
	public String toString() {
		String opString = "numOfJobs: " + this.numOfJobs + "\n";
		opString += "numOfMachines: " + this.numOfMachines + "\n";
		opString += "populationSize: " + this.populationSize + "\n";
		opString += "jobsDetailsMap: " + this.jobsDetailsMapList + "\n";
		return opString;
	}
	
}
