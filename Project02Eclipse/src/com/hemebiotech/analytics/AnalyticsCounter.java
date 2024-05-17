package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructor of AnalyticsCounter
	 * @param reader get the data from the source
	 * @param writer write data into a file
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 *	Get the symptoms from the source
	 * @return a list of symptoms as String
	 */
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	/**
	 *	Count the number of each symptom
	 * @param symptoms a list of symptom as String
	 * @return a Map : symptom as key and the sum of each of them as value
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsCounted = new HashMap<>();
		for(String symptom : symptoms){
			if(!symptomsCounted.containsKey(symptom)){
				symptomsCounted.put(symptom,1);
			}else{
				symptomsCounted.put(symptom,symptomsCounted.get(symptom)+1);
			}
		}
		return symptomsCounted;
	}

	/**
	 *	Sort the symptoms by alphabetic order
	 * @param symptoms a map of symptoms to be sorted
	 * @return a map of symptoms sorted
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 *	Write the symptoms and the sum of each of them into a file
	 * @param symptoms a map of String and Integer to be written into a file
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
