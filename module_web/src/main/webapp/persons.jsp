<%@ page import="java.util.List" %>
<%@ page import="com.pvt.bsa.*" %>
<html>
<body>
<h2>Hello World!</h2>
<table border="1">
<% List<Person> usersList=(List<Person>)request.getAttribute("userList");
    if( !usersList.isEmpty())
    for(Person person: usersList){
  %>
        <tr>
        <td><%person.getName(); %></td>
        <td><%person.getAge(); %></td>
        </tr>


    <%}
%>
</table>
</body>
</html>
