package com.example.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class IFSCCodeDAO {

    private static Map<String, String> ifscCodeMap = new HashMap<>();

    static {
        loadIFSCCodes();
    }

    private static void loadIFSCCodes() {
        try (InputStream inputStream = IFSCCodeDAO.class.getClassLoader().getResourceAsStream("WEB-INF/ifsc_codes.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String bankName = parts[0].trim();
                    String branchName = parts[1].trim();
                    String ifscCode = parts[2].trim();
                    String key = bankName + "," + branchName;
                    ifscCodeMap.put(key, ifscCode);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getIFSCCode(String bankName, String branchName) {
        String key = bankName + "," + branchName;
        return ifscCodeMap.getOrDefault(key, "IFSC Code not found");
    }
}