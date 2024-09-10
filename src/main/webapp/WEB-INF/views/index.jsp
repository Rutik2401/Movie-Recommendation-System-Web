<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html lang="en">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<title>MOVIE RECOMMENDATION SYSTEM</title>
<link href="<c:url value="/resources/CSS/style.css" />" rel="stylesheet"></link>

<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.12.2/gsap.min.js"></script>
<!-- ion-icon -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<!-- bootstrap@5.2.3 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- External JS -->
<script src="${pageContext.request.contextPath}/resources/JS/index.js"></script>

<style>
.container-fluid {
	width: 90%;
	margin: 0 auto;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.navbar-collapse {
	flex-grow: 0;
}

.navbar-nav {
	gap: 2rem;
}

.logo p {
	margin: 0;
	font-family: 'Cinzel Decorative', cursive;
}
</style>
</head>

<body>

	<div class="wrapper ">
		<!-- Hero Image -->
		<div class="banner"></div>
		<div class="Sub-Conatiner position-absolute top-0 d-flex flex-column justify-content-center gap-5">
			<!-- Navbar -->

			<nav class="navbar navbar-expand-lg bg-light p-2">
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
								aria-current="page" href="#">Home</a></li>
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
							<div class="media d-flex gap-3 justify-content-center align-items-center fs-3">
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
			<div class="search pt-4">
				<form class="d-flex " role="search">
					<input class="form-control me-2" type="search"
						placeholder="Search Movie" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
			<!-- Hero Section -->
			<div
				class="Hero d-flex flex-column align-items-center text-white gap-2">
				<h1 class="Heading px-5">MOVIE RECOMMENDATION SYSTEM</h1>
				<p class="fs-5 fw-medium text-center">Struggling to Choose from
					Thousands of Streaming Movies?</p>
				<div class="btn d-flex justify-content-center align-items-center">
					<form action="recommend" name="frm" method="post">
						<button type="submit" class="btn btn-danger">Start Now</button>
					</form>
				</div>
			</div>
		</div>

		<div class="Movie-Topper d-flex flex-column gap-1">



			<div class="Recommended-Movies d-flex flex-column text-dark">
				<!-- Topic with Title and "See All" link -->
				<div class="topic d-flex justify-content-between">
					<p class="text-white">Recommended Movies</p>
					<a href="" class="btn btn-link text-white text-decoration-none">See
						All</a>
				</div>
				<!-- AllMovies Section containing movie cards -->
				<div class="AllMovies Recommended d-flex justify-content-center">


					<!-- Iterate over the movies list -->
					<c:forEach var="movie" items="${movies}">
						<div class="movie d-flex gap-3 flex-column">
							<a href="watch?movieId=${movie.movId}"> <img
								src="<c:url value='/resources/Images/${movie.movName.toLowerCase().replaceAll(" ","")}.jpg' />"
								class="img-fluid" alt="${movie.movName}" />
							</a>
							<p class="MovieName text-white ">${movie.movName}</p>
						</div>
					</c:forEach>


				</div>

			</div>


			<!-- Romance Movies Start Here -->
			<div class="Romance-Movies d-flex flex-column ">
				<!-- Topic with Title and "See All" link -->
				<div class="topic d-flex justify-content-between">
					<p>Romance Movies</p>
					<a href="#" class="btn btn-link text-dark text-decoration-none">See
						All</a>
				</div>
				<!-- AllMovies Section containing movie cards -->
				<div class="AllMovies d-flex justify-content-center">
					<!-- Iterate over the movies list -->
					<c:forEach var="movie" items="${movies}">
						<div class="movie d-flex gap-3 flex-column">
							<a href="watch?movieId=${movie.movId}"> <img
								src="<c:url value='/resources/Images/${movie.movName.toLowerCase().replaceAll(" ","")}.jpg' />"
								class="img-fluid" alt="${movie.movName}" />
							</a>
							<p class="MovieName text-dark ">${movie.movName}</p>
						</div>
					</c:forEach>
				</div>
			</div>

			<!-- Remainder For Directly Login -->
			<div class="remainder ">
				<div class="continue">
					<h2 class="fs-3 fw-semibold">Continue Watching</h2>
				</div>

				<div class="blur-div ">
					<img
						src="${pageContext.request.contextPath}/resources/Images/IMG.jpg"
						class="img-fluid" alt="Example Image">

				</div>
				<!-- <div class="entry d-flex flex-column gap-2 justify-content-center align-items-center gap-1">
                    <ion-icon name="logo-instagram" class="fs-4"></ion-icon>
                    <h2 class=" rounded p-1 fs-1 fw-bold ">Log in to pick up where you left of</h2>
                    <a class="btn fs-4 text-center ">Sign in & Watch For FREE</a>
                    <h3 class="text-white p-2 rounded fw-bold text-black">You don't have to sign in. It's just better when you do.</h3>
                </div>  -->
			</div>


			<div class="action-Movies d-flex flex-column">
				<!-- Topic with Title and "See All" link -->
				<div class="topic d-flex justify-content-between">
					<p>Action Movies</p>
					<a href="#" class="btn btn-link text-dark text-decoration-none">See
						All</a>
				</div>
				<!-- AllMovies Section containing movie cards -->
				<div class="AllMovies d-flex justify-content-center">
					<!-- Iterate over the movies list -->
					<c:forEach var="movie" items="${movies}">
						<div class="movie d-flex gap-3 flex-column">
							<a href="watch?movieId=${movie.movId}"> <img
								src="<c:url value='/resources/Images/${movie.movName.toLowerCase().replaceAll(" ","")}.jpg' />"
								class="img-fluid" alt="${movie.movName}" />
							</a>
							<p class="MovieName text-white ">${movie.movName}</p>
						</div>
					</c:forEach>
				</div>
			</div>


		</div>


		<!-- Footer Code  -->
		<div
			class="footer d-flex justify-content-center align-items-center flex-column">
			<div class="sign-in d-flex justify-content-center">
				<button type="button" href="asset/signin.html"
					class="btn btn-danger">Sign in for more Access</button>
			</div>
			<div
				class="All-Footer d-flex justify-content-center align-items-center ">
				<div class="connection d-flex flex-column">
					<div>
						<h4>Follow SuggestMeMovie on social</h4>
					</div>
					<div class="social">
						<ion-icon name="logo-instagram" class=""></ion-icon>
						<ion-icon name="logo-linkedin" class=""></ion-icon>
						<ion-icon name="logo-facebook" class=""></ion-icon>
						<ion-icon name="logo-youtube" class=""></ion-icon>
					</div>
				</div>

				<div class="get ">
					<p class="">Get the SuggestMeMovie app For Android and iOS</p>

				</div>
			</div>
			<div class="links text-dark">
				<a href="#" class="text-decoration-none text-white">Privacy
					Policy</a> <a href="#" class="text-decoration-none text-white">Terms
					& Conditions</a> <a href="#" class="text-decoration-none text-white">Cookies</a>
				<a href="#" class="text-decoration-none text-white">Help</a> <a
					href="#" class="text-decoration-none text-white">About Us</a> <a
					href="#" class="text-decoration-none text-white">FAQ</a> <a href="#"
					class="text-decoration-none text-white">Become Our Partner</a>
			</div>
			<div class="by">
				<p class="text-white">© 2024 by SuggestMeMovie.com, Inc.</p>
			</div>
		</div>



	</div>





	<!-- Javascript Links -->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>

</html>	