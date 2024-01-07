package com.example.csv;

import java.util.Arrays;
import java.util.Objects;

public class SupportMethods {

    public static boolean complementPostingsData(CSVData postings, CSVData logins) {
        String[] appAccountName = logins.findByHeader("AppAccountName");
        String[] isActive = logins.findByHeader("IsActive");
        String[] userName = postings.findByHeader("User Name");
        if (isActive != null && appAccountName != null) {
            String[] newColumn = new String[userName.length];
            for (int i = 0; i < postings.getData().size(); i++) {
                if (Arrays.asList(appAccountName).contains(userName[i])
                        && Objects.equals(isActive[Arrays.asList(appAccountName).indexOf(userName[i])], "True")) {
                    newColumn[i] = "True";
                } else {
                    newColumn[i] = "False";
                }
            }
            postings.addColumn(newColumn, "Authorized");
            return true;
        } else {
            return false;
        }
    }

}
