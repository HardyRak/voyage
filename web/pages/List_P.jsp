<%-- 
    Document   : List_P
    Created on : 9 janv. 2024, 12:45:49
    Author     : HARDY
--%>

<%@page import="java.util.Vector"%>
<%@page import="objet.Voyage"%>
<%@page import="objet.Voyage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1">
        <%
            Vector<Voyage> v=(Vector<Voyage>)session.getAttribute("prixV");
            for(int i=0;i<v.size();i++){
                %><tr><td><%=v.get(i).getLibelle() %></td></tr><%
            }
        %>
        </table>
    </body>
</html>
