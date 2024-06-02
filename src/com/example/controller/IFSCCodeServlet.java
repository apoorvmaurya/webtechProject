package com.example.controller;

import com.example.dao.IFSCCodeDAO;
import com.example.utility.IFSCCodeUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/IFSCCodeServlet")
public class IFSCCodeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the bank name and branch name from the request
        String bankName = request.getParameter("bankName");
        String branchName = request.getParameter("branchName");

        // Process the bank name and branch name
        String processedBankName = IFSCCodeUtility.processBankName(bankName);
        String processedBranchName = IFSCCodeUtility.processBranchName(branchName);

        // Get the IFSC code from the DAO
        String ifscCode = IFSCCodeDAO.getIFSCCode(processedBankName, processedBranchName);

        // Set the IFSC code as a request attribute
        request.setAttribute("ifscCode", ifscCode);

        // Forward the request to the JSP file
        request.getRequestDispatcher("/WEB-INF/jsp/ifscCodeFinder.jsp").forward(request, response);
    }
}