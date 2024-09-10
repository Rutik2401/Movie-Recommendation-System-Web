<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <title>MOVIE RECOMMENDATION SYSTEM</title>
    <link href="<c:url value="/resources/CSS/Allmovies.css" />" rel="stylesheet"></link>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.12.2/gsap.min.js"></script>

    <!-- ion-icon -->
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <!-- bootstrap@5.2.3 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link
        href="https://fonts.googleapis.com/css2?family=Cinzel+Decorative&family=Playfair+Display:wght@700&family=Abril+Fatface&family=Lobster&family=Righteous&family=Pacifico&family=Monoton&display=swap"
        rel="stylesheet">
    <style>
        .navbar-collapse {
            flex-grow: 0;
        }

        .navbar-nav {
            gap: 2rem;
        }
    </style>
</head>

<body>
    <div class="wrapper ">
        <!-- Hero Image -->
        <div class="banner"></div>
        <div class="Sub-Conatiner position-absolute top-0 d-flex flex-column justify-content-center ">
            <!-- Navbar -->

            <nav class="navbar Navbar navbar-expand-lg bg-light p-2">
               <div class="container-fluid d-flex gap-0">
					<div class="logo">
						<p>Suggest Me Movie</p>
					</div>
					<button class="navbar-toggler " type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav gap-4">
							<li class="nav-item"><a class="nav-link active text-dark"
								aria-current="page" href="/MovieRecommendationSystem">Home</a></li>
							<li 	class="nav-item"><a class="nav-link active text-dark"
								href="#">Features</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle active text-dark" href="#"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
									Top Language </a>
								<ul class="dropdown-menu">
									
									<c:forEach var="language" items="${LangList}">
									    <li><a class="dropdown-item" href="Allmovies?language=${language.id}">${language.language}</a></li>
									</c:forEach>
								</ul></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle active text-dark" href="#"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
									Top Category </a>
								<ul class="dropdown-menu">
									<c:forEach var="category" items="${GenresList}">
									    <li><a class="dropdown-item" href="Allmoviess?category=${category.id}">${category.genre}</a></li>
									</c:forEach>
								</ul></li>
							<li class="nav-item"><a class="nav-link active text-dark"
								href="#">Blogs</a></li>
							<div
								class="media d-flex gap-3 justify-content-center align-items-center fs-3">
								<a type="button" href="reg"
									class="btn btn-outline-primary text-bg-dark">Register</a> <a
									type="button" href="login" class="btn btn-danger">Sign
									in</a>
							</div>
						</ul>
					</div>
				</div>
            </nav>

            <!-- Search Bar -->
            <div class="search pt-4 text-center" style="background-color: #f0f0f0; padding: 20px;">
                <h1 class="text-black fw-bolder">Discover the Best ${type} Movies</h1>
                <h2 class="text-dark fw-medium">Not sure what to watch? Try our Movie Picker!</h2>
            </div>
            <!-- All Movies Present Here  Section -->
            <div class="Recommended-Movies d-flex flex-column ">

                <!-- AllMovies Section containing movie cards -->
                <div class="AllMovies d-flex justify-content-center">
                     <!-- <div class="movie d-flex gap-3 flex-column">
                        <a href="details.html">
                            <img src="king.jpg" class="img-fluid" alt="">
                        </a>
                        <p>Title</p>
                    </div>  -->
                    <!-- Iterate over the movies list -->
				 	<c:forEach var="movieInfo" items="${AllMovies}">
					    <div class="movie d-flex gap-3 flex-column">
					        <a href="watch?movieId=${movieInfo.movie.movId}">
					            <img src="<c:url value='/resources/Images/king.jpg' />" 
					                 class="img-fluid" alt="${movieInfo.movie.movName}" />
					        </a>
					        <p class="MovieName text-white">${movieInfo.movie.movName}</p>
					    </div>
					</c:forEach> 
					<p class="fs-5 ">${Message}</p>
					

                </div>
            </div>


        </div>






    </div>





    <!-- Javascript Links -->
    
<script>
    // GSAP animation for the main heading
    gsap.from("h1", { 
      duration: 1.5, 
      opacity: 0, 
      y: -50, 
      ease: "power4.out", 
      scale: 0.9,
      delay: 0.2,
      onStart: function() {
        // Ensure text is visible at the start of the animation
        document.querySelector("h1").style.opacity = "1";
      }
    });
  
    // GSAP animation for the subheading
    gsap.from("h2", { 
      duration: 1.5, 
      opacity: 0, 
      y: 50, 
      ease: "power4.out", 
      scale: 0.9,
      delay: 0.5,
      onStart: function() {
        // Ensure text is visible at the start of the animation
        document.querySelector("h2").style.opacity = "1";
      }
    });
  </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>

</html>