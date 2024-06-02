package com.example.utility;

public class IFSCCodeUtility {

    public static String processBankName(String bankName) {
        // Process the bank name (e.g., remove spaces, convert to uppercase)
        return bankName.replaceAll("\\s+", "").toUpperCase();
    }

    public static String processBranchName(String branchName) {
        // Process the branch name (e.g., remove spaces, convert to uppercase)
        return branchName.replaceAll("\\s+", "").toUpperCase();
    }
}