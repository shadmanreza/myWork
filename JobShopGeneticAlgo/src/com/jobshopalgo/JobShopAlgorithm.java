package com.jobshopalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.geneticalgo.Chromosome;
import com.geneticalgo.Population;

public class JobShopAlgorithm {
	/*
	 * Data members
	 */
	private List<Job> jobs;	
	private Population chromosomes;
	
	/*
	 * Constructor
	 */
	public JobShopAlgorithm (int numMachines, int numJobs, List<Map<Integer, Map<String,Integer>>> jobDetailList, int populationSize) {		
		this.jobs = buildJobsList(numMachines, numJobs, jobDetailList);
		this.chromosomes = buildPopulation(numMachines, numJobs, populationSize);		
	}

	
	public List<Job> getJobs() {
		return jobs;
	}


	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}


	public Population getPopulation() {
		return chromosomes;
	}


	public void setPopulation(Population population) {
		this.chromosomes = population;
	}

	public List<Job> buildJobsList (int numMachine, int numJobs, List<Map<Integer, Map<String,Integer>>> jobDetailList) {
		// Set static parameter of the Job
		Job.setNumMachine(numMachine);
		Job.setNumJobs(numJobs);
		
		List<Job> jobsList = new ArrayList<Job>();
		int jobCounter = 0;
		
		for (Map<Integer, Map<String,Integer>> jobOperation : jobDetailList) {
			Job newJob = new Job( jobCounter++, jobOperation );
			jobsList.add(newJob);
		}
		
		return jobsList;
	}
	

	public Chromosome buildRandomChromosome (List<Operation> m) {
		List<Operation> randomChromosome = new ArrayList<Operation>();
		List<Operation> mergedJobsOperation = new ArrayList<Operation>();
		mergedJobsOperation.addAll(m);
		
		Random rand = new Random();
		int randomIndex = 0;
		
		// Logic to generate random list of Operation from the List of Operations available
		while ( ! mergedJobsOperation.isEmpty() ) {
			randomIndex = rand.nextInt(mergedJobsOperation.size());
			randomChromosome.add(mergedJobsOperation.get(randomIndex));
			mergedJobsOperation.remove(randomIndex);
		}
		
		return new Chromosome(randomChromosome);
	}
	
	public Population buildPopulation (int numMachines, int numJobs, int populationSize) {		
		List<Chromosome> randomChromosomeList = new ArrayList<Chromosome>();
		List<Operation> mergedJobsOperation = new ArrayList<Operation>();
		List<Operation> jobsOperationList;
		List<Job> jobList = getJobs();
		
		// Merge Operation of all the Jobs
		for (Job j: jobList) {
			jobsOperationList = j.getOperationList();
			mergedJobsOperation.addAll(jobsOperationList);
		}
		
		Chromosome.setDefaultChromosomeLength(mergedJobsOperation.size());
		Chromosome.setNumMachines(numMachines);
		Chromosome.setNumJobs(numJobs);
		
		for (int index = 0; index < populationSize; index++) {
			Chromosome newChromosome = buildRandomChromosome(mergedJobsOperation);
			randomChromosomeList.add(newChromosome);
		}
		
		// Set the list of Chromosome to the Population
		return new Population(randomChromosomeList);
	}
}
