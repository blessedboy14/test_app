package com.example.csv;

public interface CSVReader {
    CSVData readAll(String filename, Character separator, boolean isEscape);
}
