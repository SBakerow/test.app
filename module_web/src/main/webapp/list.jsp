

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pvt.bsa.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %>

<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 20.01.14
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<body>

 <b>users:</b> </br>
 <%

     List < User > users = (List<User>)request.getAttribute( "users" );
     if(!users.isEmpty()){
     %>   <%=
      "<form method=\"post\" name=\"form1\" action=\"delete_users\">"+
 "<table border=\"1\">"%>

       <%
     for(User user : users){%>
<%= "<tr>"%>
     <%= "<td><input type=\"checkbox\" name =\"checkbox\" value="+user.getId()+"></td>"+"<td>"+  user.getName()+"</td>"+ "<td>"+user.getAge()+"</td>"%>
<%= "</tr>"%>
   <%  ;} %>
 <%= "<tr>"%>
 <%= "<td></td>"+"<td><input type=\"text\" name =\"nameUpd\"> </td><td>  <input type=\"text\" name =\"ageUpd\"></td>"%>
 <%= "</tr>"%>
<%= "</table>"
+"<p><input type=\"submit\" name=\"delete\" value=\"delete\"  />\n"
+"<p><input type=\"submit\" name=\"update\" value=\"update\"  />\n" +
        "</form>"
%>
 <%}
 %>



<form method="post" action=" users">
   name <input type="text" name ="name">
    age <input type="text" name ="age">
    <input type="submit" name ="submit">
</form>

</body>
</html>