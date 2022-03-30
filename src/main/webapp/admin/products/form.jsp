<%@ page import="java.util.HashMap" %>
<% HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
if (errors == null){
    errors = new HashMap<>();
}
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
    <title>Create Products</title>
</head>
<body>
<form style="margin:auto" class="col-md-6" action="/products/create" method="post">
    <h2 style="text-align:center">Create Products Here</h2>
    <%
        if(errors != null && errors.size() > 0){
    %>
    <div class="form-group">
        <h3>FIX ERRORS</h3>
        <ul>
            <%
            for (String message : errors.values()){
            %>
            <li><%=message %></li>
            <%}%>
        </ul>
    </div>
    <%}%>
    <div class="form-group">
        <label>Thumbnail</label>
        <input type="text" name="thumbnail" class="form-control" >
        <%
        if (errors.containsKey("thumbnail")){%>
        <span><%=errors.get("thumbnail")%></span>
        <%}%>
    </div>
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" class="form-control" >
        <%
            if (errors.containsKey("name")){%>
        <span><%=errors.get("name")%></span>
        <%}%>
    </div>
    <div class="form-group">
        <label>Price</label>
        <input type="number" name="price" value="0" class="form-control" >
        <%
            if (errors.containsKey("price")){%>
        <span><%=errors.get("price")%></span>
        <%}%>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-primary">Reset</button>
</form>
</body>
</html>