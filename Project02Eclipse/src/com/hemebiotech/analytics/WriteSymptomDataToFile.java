package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    public WriteSymptomDataToFile(){

    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){
        if(symptoms != null){
            try {
                FileWriter writer = new FileWriter("result.out");
                for(Map.Entry<String,Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
