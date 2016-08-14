package com.test;

import java.util.ArrayList;
import java.util.List;

import com.geneticalgo.Chromosome;
import com.jobshopalgo.Operation;

public class CustomTestChromosome {

	public static void main(String[] args) {
		
		List<Operation> opList = new ArrayList<Operation>();
		Operation op11 = new Operation(1, 1, 1, 4);
		
		
		Operation op12 = new Operation(1, 2, 2, 3);
		
		
		Operation op13 = new Operation(1, 3, 3, 3);
		
		
		Operation op21 = new Operation(2, 1, 1, 1);
		
		
		Operation op22 = new Operation(2, 2, 3, 5);
		
		
		Operation op23 = new Operation(2, 3, 2, 3);
		
		
		Operation op31 = new Operation(3, 1, 2, 2);
		
		
		Operation op32 = new Operation(3, 2, 1, 4);
		
		
		Operation op33 = new Operation(3, 3, 3, 1);
		
		
		
		// Series
		opList.add(op11);
		opList.add(op21);
		opList.add(op12);
		opList.add(op22);
		opList.add(op31);
		opList.add(op13);
		opList.add(op32);
		opList.add(op23);
		opList.add(op33);
		
		Chromosome.setNumJobs(3);
		Chromosome.setNumMachines(3);
		Chromosome ch = new Chromosome(opList);
		System.out.println(ch);
		System.out.println(ch.getFitness());
	}

}
