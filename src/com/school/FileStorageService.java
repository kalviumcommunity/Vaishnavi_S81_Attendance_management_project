package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileStorageService {

    /**
     * Save a list of Storable items to a text file (one item per line).
     * Each item's toDataString() method is used to get the line content.
     */
    public void saveData(List<? extends Storable> items, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Storable s : items) {
                writer.println(s.toDataString());
            }
            System.out.println("Data saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
            e.printStackTrace();
        }
    }
}
