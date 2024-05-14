package com.hemebiotech.analytics;

import java.util.Map;

/**
 *  To write processed data into an output.
 *
 */

public interface ISymptomWriter {

    /**
     *  Write the symptoms into an output file
     * @param symptoms a Map of symptom and their sum
     */
    void writeSymptoms(Map<String, Integer> symptoms);

}
