package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

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

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
