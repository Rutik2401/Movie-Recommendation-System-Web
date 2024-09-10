<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign in</title>
    <link rel="stylesheet" href="signin.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/signin.css">
    
    <!-- ion-icon -->
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <!-- bootstrap@5.2.3 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
    <div class="container1 d-flex flex-column align-items-center justify-content-center">
        <div class="back-img"></div>
        <form name="frm" action="${pageContext.request.contextPath }/validate" method="post">
            <div class="sign-section  d-flex gap-4 flex-column align-items-center justify-content-center">
                <h1 class="fw-bold fs-2 text-white ">Sign In</h1>
                <div class="input-group ">
                    <input type="text" class="form-control" placeholder="Enter Your Username" aria-label="Username" name="username"
                        aria-describedby="basic-addon1">
                </div>
                <div class="input-group ">
                    <input type="text" class="form-control" placeholder="Enter Your  Password" aria-label="Password" name="password"
                        aria-describedby="basic-addon1">
                </div>
                <button type="submit" class="btn btn-danger">Login</button>
                <div class="forgat">
                    <a href="#" class="text-decoration-none text-white fw-medium">Forgot password?</a>
                </div>
                <div class="ref-register d-flex gap-3 text-white">
                    <p>New to MRC</p>
                    <a href="reg" cestlass="Sign-up-now text-white text-decoration-none fw-bold">Register
                        Now.</a>
                </div>
            </div>
        </form>
    </div>
    <!-- Javascript Links -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>