package com.example.csv;

import java.util.List;

public class CSVData {

    private List<String[]> data;

    private List<String> headers;

    public void addColumn(String[] column, String header) {
        headers.add(header);
        for (int i = 0; i < data.size(); i ++) {
            String[] row = data.get(i);
            String[] newRow = new String[row.length + 1];
            System.arraycopy(row, 0, newRow, 0, row.length);
            newRow[row.length] = column[i];
            data.set(i, newRow);
        }
    }

    public String[] findByHeader(String header) {
        if (!headers.contains(header)) {
            return null;
        } else {
            String[] dataColumn = new String[data.size()];
            int i = 0;
            for (String[] row : data) {
                dataColumn[i] = row[headers.indexOf(header)];
                i++;
            }
            return dataColumn;
        }
    }

    public CSVData(List<String[]> data, List<String> headers, String fileName, Character separator) {
        this.data = data.subList(1, data.size());
        this.headers = headers;
        this.fileName = fileName;
        this.separator = separator;
    }

    private String fileName;

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Character getSeparator() {
        return separator;
    }

    public void setSeparator(Character separator) {
        this.separator = separator;
    }

    private Character separator;

}
