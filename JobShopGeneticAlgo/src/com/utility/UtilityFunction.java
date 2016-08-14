/**
 * 
 */
package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * @author shadman
 *
 */
public final class UtilityFunction {
	public static int getRandom(int size) {		
		return new Random().nextInt(size);
	}
	
	public static JobPropertiesBean readJobProperties (String filename) {
		JobPropertiesBean jobPropBeanOb = new JobPropertiesBean();
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			
			input = new FileInputStream(filename);			
			prop.load(input);
			
			jobPropBeanOb.setNumOfJobs(Integer.parseInt(prop.getProperty("num_of_jobs")));
			
			jobPropBeanOb.setNumOfMachines(Integer.parseInt(prop.getProperty("num_of_machines")));
			
			jobPropBeanOb.setPopulationSize(Integer.parseInt(prop.getProperty("population_size")));
			
			jobPropBeanOb.setBestPoolSize(Integer.parseInt(prop.getProperty("best_pool_size")));
			
			jobPropBeanOb.setCrossoverSize(Integer.parseInt(prop.getProperty("crossover_size")));
			
			jobPropBeanOb.setMutationSize(Integer.parseInt(prop.getProperty("mutaiton_size")));
			
			
			// Retrieve jobs list
			String jobKey = "job";
			int jobIndex = 1;
			String jobPropertyKey = jobKey + jobIndex;
			List<Map<Integer, Map<String, Integer>>> jobsDetailsMap = new ArrayList<Map<Integer,Map<String,Integer>>>();
			
			while (prop.getProperty(jobPropertyKey) != null && prop.getProperty(jobPropertyKey).length() > 0) {
				Map<Integer, Map<String, Integer>> jobMap = new HashMap<Integer, Map<String,Integer>>();				
				String jobOperationDetails =  prop.getProperty(jobPropertyKey);
				String[] operationDetails =  jobOperationDetails.split(";");
				
				for (int i = 0; i < operationDetails.length; i++) {
					Map<String, Integer> operationMap = new HashMap<String, Integer>();
					String operationString = operationDetails[i].trim();					
					String[] operationArray = operationString.substring(1,operationString.length() - 1).split(",");
					operationMap.put("mIndex", Integer.parseInt(operationArray[0]));
					operationMap.put("pTime", Integer.parseInt(operationArray[1]));
					jobMap.put(i + 1, operationMap);
				}
				
				jobsDetailsMap.add(jobMap);
				jobIndex++;
				jobPropertyKey = jobKey + jobIndex;
			}
			
			jobPropBeanOb.setJobsDetailsMapList(jobsDetailsMap);			

			
		} catch (NumberFormatException ex) {
			System.out.println("ERROR: Invalid integer");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("ERROR: Invalid integer");
    		ex.printStackTrace();
        } finally{
        	if( input != null ){
        		try {
        			input.close();
        		} catch (IOException e) {
        			System.out.println("ERROR: Error while closing File input stream");
        			e.printStackTrace();
        		}
        	}
        }
		
		return jobPropBeanOb;
	}
}
