<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MOVIE RECOMMENDATION SYSTEM</title>
<!--  <link rel="stylesheet" href="show.css"> -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/CSS/movie.css" />" rel="stylesheet"></link>
<!-- External JS -->
<script src="${pageContext.request.contextPath}/resources/JS/movie.js"></script>
<style>
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
	<div class="wrapper">
		<!-- Hero Image -->
		<div class="banner"></div>
		<div
			class="Sub-Conatiner d-flex flex-column justify-content-center gap-5">
			<!-- Navbar -->
			<nav class="navbar navbar-expand-lg bg-light p-2">
				<div class="container-fluid d-flex gap-0">
					<div class="logo">
						<p>Suggest Me Movie</p>
					</div>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav gap-4">
							<li class="nav-item"><a class="nav-link active text-dark"
								aria-current="page" href="#">Home</a></li>
							<li class="nav-item"><a class="nav-link active text-dark"
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
		</div>

		<div class="main-card">

			<div class="all-content">
				<div class="poster movie">
					<a href="#"> <img
						src="<c:url value='/resources/Images/${fullInfo.getMovie().getMovName().toLowerCase().replaceAll(" ","")}.jpg' />"
						class="img-fluid text-white"
						alt="${fullInfo.getMovie().getMovName()}" />
					</a>
				</div>
				<div class="movie-info d-flex flex-column justify-content-center">
					<div class="MovieName">
						<p class="fw-bold text-white">${fullInfo.getMovie().getMovName()}</p>
					</div>
					<div class="rating">
						<!-- Button trigger modal -->
						<button type="button" class="btn btn-light" data-bs-toggle="modal"
							data-bs-target="#staticBackdrop">
							<i class="bi bi-star"></i> &nbsp;9/10 &nbsp; Rate Now
						</button>


					</div>
					<div class="Language d-flex gap-3 fs-5 fw-semibold text-white">
						<p>Language: ${fullInfo.getLanguage().getLanguage()}</p>
						<p>Genres: ${fullInfo.getGenre().getGenre()}</p>
					</div>
					<div class="watch d-flex gap-3 text-center align-items-center">

						<a href="see" class="btn btn-outline-primary text-bg-dark ">Watch
							Trailer</a> <a href="see" class="btn btn-danger  text-center ">Watch
							Full Movie</a>
					</div>
				</div>
			</div>

		</div>
		<!-- Modal -->
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog">
				<form action="submitRating" method="post">
					<input type="hidden" name="movId"
						value="${fullInfo.getMovie().getMovId()}" /> <input type="hidden"
						name="ratingValue" id="ratingValue" value="0" />
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title text-center" id="staticBackdropLabel">Give
								Rating</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<div class="star-rating">
							    <input type="hidden" name="ratingValue" id="ratingValue" value="0" />
							    <span class="star" data-value="1">&#9733;</span>
							    <span class="star" data-value="2">&#9733;</span>
							    <span class="star" data-value="3">&#9733;</span>
							    <span class="star" data-value="4">&#9733;</span>
							    <span class="star" data-value="5">&#9733;</span>
							    <span class="star" data-value="6">&#9733;</span>
							    <span class="star" data-value="7">&#9733;</span>
							    <span class="star" data-value="8">&#9733;</span>
							    <span class="star" data-value="9">&#9733;</span>
							    <span class="star" data-value="10">&#9733;</span>
							</div>




						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Submit
								Rating</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="about">
			<h1>About the movie</h1>
			<p>${fullInfo.getMovie().getAbout()}</p>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.0/js/bootstrap.bundle.min.js"></script>

</body>

</html>