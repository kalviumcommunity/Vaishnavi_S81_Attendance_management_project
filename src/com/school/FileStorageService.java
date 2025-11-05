package com.school;

import java.util.*;
import java.io.*;

public class FileStorageService {
    public void saveData(List<?> data, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Object obj : data) {
                if (obj instanceof AttendanceRecord) {
                    writer.println(((AttendanceRecord) obj).toDataString());
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
