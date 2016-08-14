package com.controller;

import com.geneticalgo.Chromosome;
import com.geneticalgo.GeneticAlgorithm;
import com.geneticalgo.Population;
import com.jobshopalgo.JobShopAlgorithm;
import com.utility.JobPropertiesBean;
import com.utility.UtilityFunction;

public class MainAlgoDriver {
	
	public static void main(String[] args) {
		// Read input arguments from the properties file
		JobPropertiesBean inputArgsOb = UtilityFunction.readJobProperties("resources\\job.properties");
		System.out.println(inputArgsOb);
		
		JobShopAlgorithm jobShopOb = new JobShopAlgorithm(
				inputArgsOb.getNumOfMachines(), 
				inputArgsOb.getNumOfJobs(),
				inputArgsOb.getJobsDetailsMapList(),
				inputArgsOb.getPopulationSize());
		
		Population opulationOb = jobShopOb.getPopulation();
		System.out.println(opulationOb);
		
		// Set STATIC parameters
		GeneticAlgorithm.setBestPoolSize(inputArgsOb.getBestPoolSize());
		GeneticAlgorithm.setCrossoverSize(inputArgsOb.getCrossoverSize());
		GeneticAlgorithm.setMutationSize(inputArgsOb.getMutationSize());
		
		GeneticAlgorithm geneticAlgoOb = new GeneticAlgorithm(opulationOb);
		Chromosome bestSchedulingPattern = geneticAlgoOb.procedureGA();
		
		System.out.println(bestSchedulingPattern);
		System.out.println(bestSchedulingPattern.getFitness());

	}
}
