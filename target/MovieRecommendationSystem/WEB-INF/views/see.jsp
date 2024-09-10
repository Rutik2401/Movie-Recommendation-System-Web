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

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.0/css/bootstrap.min.css"
	rel="stylesheet">

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

.watch {
	width: 100%;
	height: 100vh;
	background-color: gray;
}

iframe {
	width: 100%;
	height: 100%;
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
										<li><a class="dropdown-item"
											href="Allmovies?language=${language.id}">${language.language}</a></li>
									</c:forEach>
								</ul></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle active text-dark" href="#"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
									Top Category </a>
								<ul class="dropdown-menu">
									<c:forEach var="category" items="${GenresList}">
										<li><a class="dropdown-item"
											href="Allmoviess?category=${category.id}">${category.genre}</a></li>
									</c:forEach>
								</ul></li>
							<li class="nav-item"><a class="nav-link active text-dark"
								href="#">Blogs</a></li>
							<div
								class="media d-flex gap-3 justify-content-center align-items-center fs-3">
								<a type="button" href="reg"
									class="btn btn-outline-primary text-bg-dark">Register</a> <a
									type="button" href="login" class="btn btn-danger">Sign in</a>
							</div>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="watch">
			<iframe src="https://www.youtube.com/embed/XO8wew38VM8?autoplay=1"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen> </iframe>
		</div>




	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.0/js/bootstrap.bundle.min.js"></script>

</body>

</html>