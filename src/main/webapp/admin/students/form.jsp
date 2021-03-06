<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <title>Create Student</title>
</head>
<body>
<form style="margin:auto" class="col-md-6" action="/students/create" method="post">
    <h2 style="text-align:center">Create Students Here</h2>
    <div class="form-group">
        <label>Id</label>
        <input type="number" name="id" class="form-control" >
    </div>
    <div class="form-group">
        <label>Roll Number</label>
        <input type="text" name="rollNumber" class="form-control" >
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="email" name="email" class="form-control" >
    </div>
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" class="form-control" >
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-primary">Reset</button>
</form>
</body>
</html>