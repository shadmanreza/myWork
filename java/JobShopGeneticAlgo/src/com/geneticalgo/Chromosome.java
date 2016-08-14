package com.geneticalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jobshopalgo.Operation;

public class Chromosome {
	/*
	 * Static Data members
	 */	
	// Default size of the chromosome
	private static int defaultChromosomeLength;
	private static int numMachines;
	private static int numJobs;
	
	/*
	 * Data Members
	 */
	// ArrayList of Operation, which forms the chromosome
	private List<Operation> genes;
	
	//Fitness of the Chromosome to be calculated when a chromosome is initialized in the constructor
	private int fitness;

	
	/*
	 * Constructor
	 */
	public Chromosome(List<Operation> genes) {
		this.genes = genes;
		this.fitness = calculateFitness();
	}
	
	public Chromosome( ) {
		this.genes = new ArrayList<Operation>();
		this.fitness = 0;
	}

	/*
	 * GETTERS and SETTERS
	 */
	public int getFitness() {
		return fitness;
	}	
	
	public int getGenesLength() {
		return genes.size();
	}
	
	public Operation get(int index) {
		return genes.get(index);
	}	
	
	public void set(int index, Operation value) {
		genes.set(index, value);	
	}
	
	public List<Operation> getGenes() {
		return genes;
	}

	public void setGenes(List<Operation> genes) {
		this.genes = genes;
	}
	
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	
	public static int getDefaultChromosomeLength() {
		return defaultChromosomeLength;
	}

	public static void setDefaultChromosomeLength(int defaultChromosomeLength) {
		Chromosome.defaultChromosomeLength = defaultChromosomeLength;
	}

	// Calculate Fitness
	public static int getNumMachines() {
		return numMachines;
	}

	public static void setNumMachines(int numMachines) {
		Chromosome.numMachines = numMachines;
	}

	public static int getNumJobs() {
		return numJobs;
	}

	public static void setNumJobs(int numJobs) {
		Chromosome.numJobs = numJobs;
	}

	public int calculateFitness() {
		List<Operation> chromosome = this.genes;		
		
		int machineArray[] = new int[numMachines];
		//List<Integer> machineList = new ArrayList<Integer>();
		//for (int i = 0; i < numMachines; i++) machineList.add(0);
		
		int jobsArray[] = new int[numJobs];
		//List<Integer> jobsList = new ArrayList<Integer>();
		//for (int i = 0; i < numMachines; i++) jobsList.add(0);
		
		int currentJob = Integer.MIN_VALUE;
		int currentMachine = Integer.MIN_VALUE;
		int currentProcessingTime = Integer.MIN_VALUE;
		int maxValue = Integer.MIN_VALUE;
		
		/*
		 * Logic to calculate the fitness of a chromosome to be Implemented here
		 */		
		for (Operation o : chromosome) {
			currentJob = o.getJobIndex();
			currentMachine = o.getMachineIndex();
			currentProcessingTime = o.getProcesingTime();			
			
			if( machineArray[currentMachine - 1] >= jobsArray[currentJob - 1])
				maxValue = machineArray[currentMachine - 1];
			else
				maxValue = jobsArray[currentJob - 1];			  
			
			machineArray[currentMachine - 1] = maxValue + currentProcessingTime;
			jobsArray[currentJob - 1] = maxValue + currentProcessingTime;				
		}
		
		Arrays.sort(machineArray);
		Arrays.sort(jobsArray);
		
		return (machineArray[numMachines - 1] > jobsArray[numJobs - 1] ? machineArray[numMachines - 1] : jobsArray[numJobs - 1]);		
		//return (machineList.get(machineList.size() - 1) >= jobsList.get(jobsList.size() - 1) ? machineList.get(machineList.size() - 1) : jobsList.get(jobsList.size() - 1));
	}
	
	public boolean match(Chromosome that) {
		if (this.genes.containsAll(that.getGenes())) 
			return true;
		else 
			return false;
	}

	// To display a Chromosome
	@Override
    public String toString() {
        String geneString = "[";
        
        for (Operation gene : genes)
        	geneString += gene.toString() + " ";
        
        geneString = geneString.trim() + "]";
        
        return geneString;
    }
	
}
