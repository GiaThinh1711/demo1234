<%@ page import="entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Product" %>
<%
    List<Product> list = (List<Product>)request.getAttribute("listObj");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>List Product</title>
</head>
<body>
<table class="table">
    <h1 style="text-align:center">List Product</h1>
    <thead class="thead-light">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Thumbnail</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <%
        for (int i =0; i < list.size(); i++){
            Product pr = list.get(i);

    %>
    <tr>
        <td><%=pr.getId()%></td>
        <td><img src="<%=pr.getThumbnail()%>" style="object-fit: contain; width: 150px; height: 150px"></td>
        <td><%=pr.getName()%></td>
        <td><%=pr.getPrice()%></td>
        <td><a href="/products/delete?id=<%=pr.getId()%>"><button >Delete</button></a> ||
            <a href="/products/update?id=<%=pr.getId()%>"><button >Update</button></a></td>
    </tr>
    <%}%>
    </tbody>
</table>
<a href="/products/create">Create</a>
</body>
</html>