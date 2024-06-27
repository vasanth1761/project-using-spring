<%@page import="com.spring.demo.model.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
<%@page import="com.spring.demo.model.UserDetails"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Videos</title>
    <style>
        .module {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top:150px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        iframe {
            width: 80%; 
            display: block; 
            margin: 0 auto;            
            height: auto; 
        }

        .take-test-button {
            display: inline-block;
            padding: 8px 16px;
            background-color: #2A73CC;
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 14px;
            margin-top: 20px;
        }
         .navbar {
        display: flex;
        justify-content: space-between; 
        align-items: center;
        background-color: #0056b3;
        padding: 10px 20px;
        color: white;
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
    }

    .navbar span {
        font-size: 18px;
        margin-right: 10px;
    }

    .navbar .profile-section {
        display: flex;
        align-items: center;
        cursor: pointer; 
        position: relative; 
    }

    .navbar img {
        width: 30px;
        height: 30px;
        margin-right: 10px;
        border-radius: 50%; 
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #fff;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
        right: 0;
        top: 40px;
        min-width: 160px;
        border-radius: 8px;
    }

    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content a:hover {
        background-color: #f1f1f1;
    }

    .profile-section:hover .dropdown-content {
        display: block;
    }
    </style>
</head>
<body>
    <div class="module">
        <h1>Welcome</h1>
        <form action="/search" method="post">
            <input type="hidden" name="action" value="search">
            <input type="text" name="searchname" placeholder="Enter the  name">
            <button type="submit">Search</button>
        </form>
        <br>
        <br>
        <table>
            <thead>
                <tr>
                    <th>name</th>
                    <th>email</th>
                    <th>password</th>
                    <th>Remove</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
               
                <%
                               List<UserDetails> output = (List<UserDetails>) request.getAttribute("details"); 
                                               for (UserDetails user : output) { 
                                               int i=1;
                               %>
                    <tr>
                     
                        <td><%= user.getUserName()%></td>
                        <td><%=user.getEmail()%></td>
                        <td><%=user.getPassword() %></td>
                        <td><form action="/delete" method="post">
                            <input type="hidden" name="delete" value="<%=user.getId() %>">
                            <button type="submit" name="delete">delete</button>
                        </form></td>
                        <td>
			
			<input type="hidden" name="updateid" value="<%=user.getId()%>">
			<button type="submit" title="update" onclick="location.href='Update.jsp?updateid=<%= user.getId() %> '">Update</button>
			
			</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        
    </div>
   
</body>
</html>
