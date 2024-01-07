package com.example.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCSVReader implements CSVReader{
    @Override
    public CSVData readAll(String fileName, Character separator, boolean isEscape) {
        CSVParser parser;
        parser = new CSVParserBuilder().withEscapeChar('\t').withSeparator(separator).build();
        try (FileReader reader = new FileReader(fileName);
             com.opencsv.CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build()){
             List<String[]> data = csvReader.readAll();
             if (isEscape) {
                 data.remove(1);
             }
             return new CSVData(data, getHeaders(data), fileName, separator);
        } catch (IOException | CsvException e) {
            return null;
        }
    }

    private List<String> getHeaders(List<String[]> data) {
        return new ArrayList<>(Arrays.asList(data.get(0)));
    }
}
