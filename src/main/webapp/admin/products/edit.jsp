<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Product" %>
<% Product obj = (Product) request.getAttribute("obj");%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>Update Products</title>
</head>
<body>
<form style="margin:auto" class="col-md-6" action="/products/update" method="post">
    <h2 style="text-align:center">Update Products Here</h2>
    <div class="form-group">
        <label>Thumbnail</label>
        <input type="text" name="thumbnail" class="form-control" value="<%=obj.getThumbnail()%>">
        <input type="hidden" name="id" class="form-control" value="<%=obj.getId()%>">
    </div>
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" class="form-control" value="<%=obj.getName()%>">
    </div>
    <div class="form-group">
        <label>Price</label>
        <input type="number" name="price" class="form-control" value="<%=obj.getPrice()%>">
    </div>
    <div class="form-group">
        <label>Status</label>
        <input type="number" name="price" class="form-control" value="<%=obj.getStatus()%>">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>