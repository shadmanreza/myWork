package com.geneticalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {
	
	private List<Chromosome> chromosomes;
	private int populationSize;
	
    /*
     * Constructors
     */
    // Create a population
	public Population(List<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
		this.populationSize = chromosomes.size();		
    }
	
	public Population(Chromosome chromosome) {
		this.chromosomes = new ArrayList<Chromosome>();
		this.chromosomes.add(chromosome);
		this.populationSize = 1;		
    }
	
	public Population( ) {
		this.chromosomes = new ArrayList<Chromosome>();
		this.populationSize = 0;		
    }

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}
    
    public int size() {
		return this.populationSize;
	}

	public List<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public void setChromosomes(List<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}

	public Chromosome get (int index) {
		if (this.chromosomes != null && chromosomes.size() >= index)
			return chromosomes.get(index);
		else
			return new Chromosome();
	}
	
	public void set (int index, Chromosome chromosome) {
		chromosomes.set(index, chromosome);
	}
	
	public void add ( Population p) {
		this.chromosomes.addAll(p.getChromosomes());
		this.populationSize += p.size();
	}
	
	public Chromosome getRandomChromosome () {
		Random rand = new Random();
		int randomIndex = 0;
		
		if(populationSize > 0)
			randomIndex = rand.nextInt(populationSize) ;		
		
		if (chromosomes != null && chromosomes.size() >= randomIndex)			
			return chromosomes.get(randomIndex);
		else
			return null;
	}
    // Get Fittest
    public Chromosome getFittestChromosome() {    	
    	List<Chromosome> sortedChromoList = null;
    	if (this.chromosomes == null || this.populationSize <= 0)
    		return new Chromosome();
    	else {
    		sortedChromoList = sortChromosomeList();
    		return sortedChromoList.get(0);
    	}    	
    }
    
    //
	public Population getBestChromosomePool( int bestPoolSize) {		
		List<Chromosome> bestPopulation = new ArrayList<Chromosome>();		
		List<Chromosome> sortedPopulation = sortChromosomeList();
		
		if(sortedPopulation != null && sortedPopulation.size() >= bestPoolSize) {
			for (int i = 0; i < bestPoolSize; i++)
				bestPopulation.add(sortedPopulation.get(i));
		}
		
		return new Population(bestPopulation);
	}
	
	public List<Chromosome> sortChromosomeList( ) {
		Chromosome minChromosome = null;
		List<Chromosome> chromosomeList = this.chromosomes;
		
		if (chromosomeList != null && chromosomeList.size() > 0) {			
			// New Sorting Algorithm
			for (int i = 0; i < chromosomeList.size(); i++)
				for (int j = i + 1; j < chromosomeList.size(); j++) {
					if (chromosomeList.get(i).getFitness() >= chromosomeList.get(j).getFitness()) {
						minChromosome = chromosomeList.get(j);
						chromosomeList.set(j, chromosomeList.get(i));
						chromosomeList.set(i, minChromosome);
					}
				}
		}
		
		return chromosomeList;
	}
    
    
 
    // Display a population
    @Override
    public String toString() {
        String populationString = "";
        
        for (Chromosome chromo : chromosomes)
        	populationString += chromo.toString() + "\n";
        
        return populationString;
    }
}
