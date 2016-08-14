package com.geneticalgo;

import java.util.ArrayList;
import java.util.List;

import com.jobshopalgo.Operation;
import com.utility.UtilityFunction;


public class GeneticAlgorithm {
	/*
	 * Static Data members
	 */		
	private static int BESTPOOLSIZE;
	private static int CROSSOVERSIZE;
	private static int MUTATIONSIZE;
	
	/*
	 * Data members
	 */
	private Population population;	
	
	/*
	 * Constructor
	 */
	public GeneticAlgorithm(Population chromosomes) {
		this.population = chromosomes;		
	}
	
	public static int getBestPoolSize() {
		return BESTPOOLSIZE;
	}

	public static void setBestPoolSize(int bestPoolSize) {
		GeneticAlgorithm.BESTPOOLSIZE = bestPoolSize;
	}

	public static int getCrossoverSize() {
		return CROSSOVERSIZE;
	}

	public static void setCrossoverSize(int crossoverSize) {
		GeneticAlgorithm.CROSSOVERSIZE = crossoverSize;
	}

	public static int getMutationSize() {
		return MUTATIONSIZE;
	}

	public static void setMutationSize(int mutationSize) {
		GeneticAlgorithm.MUTATIONSIZE = mutationSize;
	}

	// Set Population
	public void setPopulation(Population population) {
		this.population = population;
	}
	
	// Get Population
	public Population getPopulation() {
		return this.population;
	}
	
	public Chromosome procedureGA () {		
		Population currGen = this.population;
		Chromosome currGenBestChromosome = null;		
		Population bestPopulationPool = null;
		Population crossoverPopulation = new Population();
		Population mutationPopulation = new Population();
		
		if(currGen == null || currGen.size() <= 0) {
			System.out.println("DEBUG:CurrGen is empty");
			return null;
		}
		
		while( true ) {
			Population nexGen = new Population();
			
			bestPopulationPool = currGen.getBestChromosomePool(BESTPOOLSIZE);
			
			if (bestPopulationPool != null && bestPopulationPool.size() > 0)
				nexGen.add(bestPopulationPool);
			else {
				System.out.println("DEBUG: bestPopulationPool is empty");
				return null;
			}
			
			//CROSSOVER
			if (bestPopulationPool != null && bestPopulationPool.size() > 0) {						 
				Chromosome randomBestChromosom = bestPopulationPool.getRandomChromosome();
				Chromosome randomCurrGenChromosome = currGen.getRandomChromosome();
				crossoverPopulation.add(crossover(randomBestChromosom, randomCurrGenChromosome));				
			}
			else {
				System.out.println("DEBUG:Best Population pool is empty");
				return null;
			}
			
			if(crossoverPopulation != null && crossoverPopulation.size() > 0)
				nexGen.add(crossoverPopulation);
			else {
				System.out.println("DEBUG: crossoverPopulation is empty");
				return null;
			}
				
			
			//MUTATION
			for (int mut = 0; mut < MUTATIONSIZE; mut++) {
				Chromosome randomCurrGenChromosome = currGen.getRandomChromosome();
				mutationPopulation.add(mutation(randomCurrGenChromosome));
			}
			
			if(mutationPopulation != null && mutationPopulation.size() > 0)
				nexGen.add(mutationPopulation);
			else {
				System.out.println("DEBUG: mutationPopulation is empty");
				return null;
			}
			
			Chromosome nexGenBestChromosome = nexGen.getFittestChromosome();
			currGenBestChromosome = currGen.getFittestChromosome();
			
			if (currGenBestChromosome.getFitness() >=  nexGenBestChromosome.getFitness())
				break;
			else {				
				currGen = nexGen;
			}
		}
		
		System.out.println(currGen);
		return currGenBestChromosome;		
	}
	
	
	
    // Crossover chromosome (Single point Cross implementation)
    public Population crossover(Chromosome chromo1, Chromosome chromo2) {
    	List<Chromosome> crossChromoSomes = new ArrayList<Chromosome>();
    	int chromoLength = Chromosome.getDefaultChromosomeLength();    	
    	Operation temp = null;
    	
    	for (int j = 0; j < CROSSOVERSIZE; j++) {
    		int crossPoint = UtilityFunction.getRandom(chromoLength);
	    	if (chromo1 != null && chromo2 != null) {
	    		for (int i = 0; i < chromoLength; i++) {
	    			if (i >= crossPoint) {
	    				temp = chromo1.get(i);
	    				chromo1.set(i, chromo2.get(i));
	    				chromo2.set(i, temp);
	    			}
	    		}
	    	}
	    	crossChromoSomes.add(chromo1);
	    	crossChromoSomes.add(chromo2);
    	}
    	return new Population(crossChromoSomes);
    	
    }    
    
    //Completed: Mutate a chromosome
	public Population mutation(Chromosome chromosome) {
		int chromoLength = Chromosome.getDefaultChromosomeLength();
		int randomMutationPoint1 = UtilityFunction.getRandom(chromoLength);
		int randomMutationPoint2 = UtilityFunction.getRandom(chromoLength);
		Operation temp = null;
		
		if (chromosome != null) {
			temp = chromosome.get(randomMutationPoint1);
			chromosome.set(randomMutationPoint1, chromosome.get(randomMutationPoint2));
			chromosome.set(randomMutationPoint1, temp);
		}
		
    	return new Population(chromosome);
    }

}
