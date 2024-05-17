package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String fileOutName;

    /**
     *  Constructor of WriteSymptomDataToFile
     * @param fileOutName the name of the output file
     */
    public WriteSymptomDataToFile(String fileOutName){
        this.fileOutName = fileOutName;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){
        if(symptoms != null){
            try(FileWriter writer = new FileWriter(fileOutName)) {
                for(Map.Entry<String,Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException("Error while writing : " + e.getMessage());
            }
        }
    }
}
