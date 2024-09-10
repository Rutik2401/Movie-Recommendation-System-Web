<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<title>MOVIE RECOMMENDATION SYSTEM</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<!-- DataTables CSS -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">

<!-- External CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/CSS/Admin.css">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Cinzel+Decorative&family=Playfair+Display:wght@700&family=Abril+Fatface&family=Lobster&family=Righteous&family=Pacifico&family=Monoton&display=swap"
	rel="stylesheet">

<!-- Bootstrap Icons CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.5/font/bootstrap-icons.min.css"
	rel="stylesheet">

<style>
.navbar-collapse {
	flex-grow: 0;
}
</style>
</head>

<body>
	<div class="wrapper ">

		<!-- Hero Image -->
		<div class="banner"></div>

		<!-- Navbar -->
		<nav
			class="Sub-Conatiner d-flex flex-column navbar navbar-expand-lg bg-light ">

			<div class="container-fluid d-flex gap-0">
				<div class="logo">
					<p>Suggest Me Movie</p>
				</div>

				<!-- Navbar Toggler Button -->
				<button class="navbar-toggler btn-light bg-transparent btn border-0"
					type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<!-- User Profile Dropdown inside Navbar Toggler -->
					<div
						class="dropdown d-flex justify-content-center align-items-center">
						<a href="#"
							class="d-flex gap- justify-content-center align-items-center border-0 text-white text-decoration-none dropdown-toggle"
							id="dropdownUser1" data-bs-toggle="dropdown"
							aria-expanded="false"> <img src="resources\Images/Rutik.jpg" alt="hugenerd" width="35"
							height="35" class="rounded-circle"> <span
							class="d-none d-sm-inline mx-1 text-dark">Rutik</span>
						</a>
						<ul class="dropdown-menu dropdown-menu-dark text-small shadow">
							<li><a class="dropdown-item" href="#">Profile</a></li>
							<!-- <li><hr class="dropdown-divider"></li> -->
							<li><a class="dropdown-item" href="signout">Sign out</a></li>
						</ul>
					</div>
				</button>

				<!-- Collapsible Navbar Content -->
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav nav nav-pills " id="pills-tab" role="tablist">
						<li class="nav-item" role="presentation"><a
							class="nav-link active bg-white text-black" id="pills-home-tab"
							data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
							role="tab" aria-controls="pills-home" aria-selected="true">Movie
								Analysis
								<div class="line"></div>
						</a></li>
						<li class="nav-item" role="presentation"><a
							class="nav-link bg-white text-black" id="pills-profile-tab"
							data-bs-toggle="pill" data-bs-target="#pills-profile"
							type="button" role="tab" aria-controls="pills-profile"
							aria-selected="false">Manage Movie
								<div class="line"></div>
						</a></li>
						<li class="nav-item" role="presentation"><a
							class="nav-link bg-white text-black" id="pills-user-tab"
							data-bs-toggle="pill" data-bs-target="#pills-user" type="button"
							role="tab" aria-controls="pills-user" aria-selected="false">Add
								Movie
								<div class="line"></div>
						</a></li>
						<li class="nav-item" role="presentation"><a
							class="nav-link bg-white text-black" id="pills-contact-tab"
							data-bs-toggle="pill" data-bs-target="#pills-contact"
							type="button" role="tab" aria-controls="pills-contact"
							aria-selected="false">Manage User
								<div class="line"></div>
						</a></li>
						<div
							class="dropdown user-icon d-flex justify-content-center align-items-center">
							<a href="#"
								class="d-flex gap-2 justify-content-center align-items-center text-white text-decoration-none dropdown-toggle"
								id="dropdownUser1" data-bs-toggle="dropdown"
								aria-expanded="false"> <img src="resources\Images/Rutik.jpg" alt="hugenerd" width="35"
								height="35" class="rounded-circle"> <span
								class="d-none d-sm-inline mx-1 text-dark">Rutik</span>
							</a>
							<ul class="dropdown-menu dropdown-menu-dark text-small shadow">
								<li><a class="dropdown-item" href="#">Profile</a></li>
								<!-- <li><hr class="dropdown-divider"></li> -->
								<li><a class="dropdown-item" href="signout">Sign out</a></li>
							</ul>
						</div>
					</ul>
				</div>
			</div>

			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-home"
					role="tabpanel" aria-labelledby="pills-home-tab">
					<div class="Analysis">
						<div class="info text-white">
							<h1 class="">Movie Category Wise Analysis</h1>
							<p>{Action} is Most Watch by user</p>
						</div>
						<!-- <img src="newasdd.avif" alt=""> -->
					</div>
				</div>
				<div class="tab-pane fade add-movie" id="pills-user" role="tabpanel"
					aria-labelledby="pills-user-tab">
					<div
						class="container1 d-flex flex-column align-items-center justify-content-center">
						<form name="frm" action="addmovie" method="post"
							enctype="multipart/form-data">
							<div
								class="sign-section flex-column align-items-center justify-content-center">
								<h1 class="fw-bold fs-2 text-white add">Add New Movie</h1>
								<div class="input-group ">
									<input type="text" class="form-control"
										placeholder="Enter Your Movie Name" name="movName"
										aria-label="movName" aria-describedby="basic-addon1">
								</div>
								<div class="input-group ">
									<textarea class="form-control" placeholder="Movie Information"
										aria-label="Movie Information" rows="3" name="about"></textarea>
								</div>

								<div class="input-group ">
									<input type="text" class="form-control"
										placeholder="Release Year" aria-label="Year"
										aria-describedby="basic-addon1" name="movYear">
								</div>
								<div class="input-group ">
									<input class="form-control" type="file" id="formFile"
										name="movImg">
								</div>
								<div class="input-group ">
									<select class="form-select" name="language"
										aria-label="Default select example">
										<option selected>Select Language</option>
										<c:forEach var="language" items="${LangList}">
											<option value="${language.getId()}">${language.getLanguage()}</option>
										</c:forEach>
									</select>
								</div>
								<div class="input-group ">
									<select class="form-select" name="genres"
										aria-label="Default select example">
										<option selected>Select Genres</option>
										<c:forEach var="Category" items="${GenresList}">
											<option value="${Category.getId()}">${Category.getGenre()}</option>
										</c:forEach>
									</select>
								</div>
								<div
									class="form-check d-flex justify-content-center align-items-center gap-3">
									<input class="form-check-input" type="checkbox" value=""
										id="invalidCheck2" required> <label
										class="form-check-label text-white" for="invalidCheck2">Agree
										to terms and conditions </label>
								</div>
								<button type="submit" class="btn btn-danger">Add Movie</button>
							</div>
						</form>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-profile" role="tabpanel"
					aria-labelledby="pills-profile-tab">
					<div class="container w-100">
						<table id="example" class="display table pt-3 w-100"
							style="width: 100%">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>About</th>
									<th>Year</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								<!-- Data comes from Ajax here  -->
							</tbody>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-contact" role="tabpanel"
					aria-labelledby="pills-contact-tab">
					<div class="container w-100">
						<table id="user" class="display table pt-3 w-100"
							style="width: 100%">
							<thead>
								<tr>
									<th>ID</th>
									<th>Username</th>
									<th>Password</th>
									<th>Email</th>
									<th>Contact</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								<!-- User Are Here Populated -->
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<!-- 	<script>
		$(document).ready(function() {
			// Get the value from the server side
			let selectedTab = '${tab}';

			// If a tab is specified, trigger its click event
			if (selectedTab) {
				$('#' + selectedTab + '-tab').click();
			}
		});
	</script>
 -->
	<!-- jQuery JS -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<!-- DataTables JS -->
	<script
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

	<!-- Bootstrap JS (optional) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

	<!-- External JS -->
	<script
		src="${pageContext.request.contextPath}/resources/JS/Adminpro.js"></script>
	<!-- External JS -->
	<script src="${pageContext.request.contextPath}/resources/JS/movie.js"></script>
	<!-- Ionicons -->
	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>

</html>
