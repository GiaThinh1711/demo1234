<%@ page import="entity.Student" %>
<%@ page import="java.util.List" %>
<%
    List<Student> list = (List<Student>)request.getAttribute("listStudent");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>List Student</title>
</head>
<body>
<table class="table">
    <h1>List Student</h1>
    <thead class="thead-light">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Roll Number</th>
        <th scope="col">Email</th>
        <th scope="col">Name</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (int i =0; i < list.size(); i++){
            Student st = list.get(i);

    %>
    <tr>
        <td><%=st.getId()%></td>
        <td><%=st.getRollNumber()%></td>
        <td><%=st.getEmail()%></td>
        <td><%=st.getName()%></td>
    </tr>
    <%}%>
    </tbody>
</table>
<a href="/students/create">Create</a>
</body>
</html>