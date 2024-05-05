package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> listSymptoms = analyticsCounter.getSymptoms();
        Map<String,Integer> symptomsCounted = analyticsCounter.countSymptoms(listSymptoms);
        Map<String,Integer> symptomsOrdered = analyticsCounter.sortSymptoms(symptomsCounted);
        analyticsCounter.writeSymptoms(symptomsOrdered);
    }
}
