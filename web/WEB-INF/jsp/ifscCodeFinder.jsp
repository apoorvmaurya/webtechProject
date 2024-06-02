<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IFSC Code Finder</title>
    <style>
        /* Cool dark-themed UI/UX styles */
        body {
            background-color: #1c1c1e;
            color: #d4d4d8;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #2c2c2e;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"] {
            padding: 10px;
            border-radius: 4px;
            border: none;
            background-color: #3a3a3c;
            color: #d4d4d8;
            margin-bottom: 15px;
        }

        button[type="submit"] {
            padding: 10px 20px;
            border-radius: 4px;
            border: none;
            background-color: #0a84ff;
            color: #ffffff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #0a66cc;
        }

        .result {
            margin-top: 30px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>IFSC Code Finder</h1>
    <form action="IFSCCodeServlet" method="post">
        <label for="bankName">Bank Name:</label>
        <input type="text" id="bankName" name="bankName" required>

        <label for="branchName">Branch Name:</label>
        <input type="text" id="branchName" name="branchName" required>

        <button type="submit">Find IFSC Code</button>
    </form>

    <%
        String ifscCode = (String) request.getAttribute("ifscCode");
        if (ifscCode != null) {
    %>
    <div class="result">
        IFSC Code: <%= ifscCode %>
    </div>
    <%
        }
    %>
</div>
</body>
</html>