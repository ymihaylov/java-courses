package com.example.car_service.utils;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CsvReader {
    private String delimiter = ",";

    public List<List<String>> readFile(String filePath) throws Exception {
        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(this.delimiter);
                records.add(Arrays.asList(values));
            }
        }

        return records;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
