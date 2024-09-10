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
<!-- <link rel="stylesheet" href="admin.css"> -->
<link rel="stylesheet" href="resources/CSS/Adminpro.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/CSS/Adminpro.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.12.2/gsap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- ion-icon -->
<!-- external JS -->
<script
	src="${pageContext.request.contextPath}/resources/JS/Adminpro.js"></script>

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
<link
	href="https://fonts.googleapis.com/css2?family=Cinzel+Decorative&family=Playfair+Display:wght@700&family=Abril+Fatface&family=Lobster&family=Righteous&family=Pacifico&family=Monoton&display=swap"
	rel="stylesheet">
<!-- Bootstrap Icons CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.5/font/bootstrap-icons.min.css"
	rel="stylesheet">
<style>
.add {
	height: 2.5rem;
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

		<!-- Navbar -->
		<nav
			class="Sub-Conatiner d-flex flex-column navbar navbar-expand-lg bg-light ">

			<div class="container-fluid d-flex gap-0 ">


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

					<ul class="navbar-nav nav nav-pills" id="pills-tab" role="tablist">
						<li class="nav-item " role="presentation"><a
							class="nav-link active bg-white text-black" id="pills-home-tab"
							data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
							role="tab" aria-controls="pills-home" aria-selected="true">Movie
								Analysis
								<div class="line"></div>
						</a></li>
						<li class="nav-item " role="presentation"><a
							class="nav-link bg-white text-black" id="pills-profile-tab"
							data-bs-toggle="pill" data-bs-target="#pills-profile"
							type="button" role="tab" aria-controls="pills-profile"
							aria-selected="false">Manage Movie
								<div class="line"></div>
						</a></li>
						<li class="nav-item " role="presentation"><a
							class="nav-link bg-white text-black" id="pills-user-tab"
							data-bs-toggle="pill" data-bs-target="#pills-user" type="button"
							role="tab" aria-controls="pills-user" aria-selected="false">Add
								Movie
								<div class="line"></div>
						</a></li>
						<li class="nav-item " role="presentation"><a
							class="nav-link bg-white text-black" id="pills-contact-tab"
							data-bs-toggle="pill" data-bs-target="#pills-contact"
							type="button" role="tab" aria-controls="pills-contact"
							aria-selected="false">Manage User
								<div class="line"></div>
						</a></li>
						<div
							class="dropdown  d-flex justify-content-center  align-items-center">
							<a href="#"
								class="d-flex  gap-2 d-flex justify-content-center  align-items-center text-white text-decoration-none dropdown-toggle"
								id="dropdownUser1" data-bs-toggle="dropdown"
								aria-expanded="false"> <img src="" alt="hugenerd" width="30"
								height="30" class="rounded-circle"> <span
								class="d-none d-sm-inline mx-1 text-dark">Rutik</span>
							</a>
							<ul class="dropdown-menu dropdown-menu-dark text-small shadow">
								<li><a class="dropdown-item" href="#">New project...</a></li>
								<li><a class="dropdown-item" href="#">Settings</a></li>
								<li><a class="dropdown-item" href="#">Profile</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="#">Sign out</a></li>
							</ul>
						</div>
					</ul>

				</div>






			</div>

			<div class="tab-content" id="pills-tabContent">

				<div class="tab-pane  fade show active" id="pills-home"
					role="tabpanel" aria-labelledby="pills-home-tab">
					<!-- !!!!!!!!!!!! -->

					<div class="Analysis">
						<div class="info text-white">
							<h1 class="">Movie Category Wise Analysis</h1>
							<p>{Action} is Most Watch by user</p>
						</div>

						<!-- <img src="newasdd.avif" alt=""> -->
					</div>
					<!-- !!!!!!! -->


				</div>
				<div class="tab-pane fade add-movie" id="pills-user" role="tabpanel"
					aria-labelledby="pills-user-tab">
					<div
						class="container1 d-flex flex-column align-items-center justify-content-center">
						<form name="frm" action="addmov" method="post">

							<div
								class="sign-section flex-column align-items-center justify-content-center">
								<h1 class="fw-bold fs-2 text-white add">Add New Movie</h1>
								<div class="input-group ">
									<input type="text" class="form-control"
										placeholder="Enter Your Movie Name" aria-label="movName"
										name="movName" aria-describedby="basic-addon1">
								</div>
								<div class="input-group ">
									<textarea class="form-control" placeholder="Movie Information"
										aria-label="Movie Information" rows="3" name="about"></textarea>
								</div>
								<div class="input-group ">
									<input type="text" class="form-control"
										placeholder="Release Year" aria-label="Year" name="movYear"
										aria-describedby="basic-addon1">
								</div>
								<div class="input-group ">
									<select class="form-select" aria-label="Default select example">
										<option selected>Select Language</option>
										<c:forEach var="language" items="${LangList}">
											<option value="${language.getId()}">${language.getLanguage()}</option>
										</c:forEach>
									</select>
								</div>
								<div class="input-group ">
									<select class="form-select" aria-label="Default select example">
										<option selected>Select Category</option>
										<option value="1">Action</option>
										<option value="2">Horrer</option>
										<option value="3">Comedy</option>
										<option value="4">Funnny</option>
									</select>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value=""
										id="invalidCheck2" required> <label
										class="form-check-label text-white" for="invalidCheck2">
										Agree to terms and conditions </label>
									<p></p>
								</div>
								<button type="submit" class="btn btn-danger">Add Movie</button>

							</div>
						</form>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-profile" role="tabpanel"
					aria-labelledby="pills-profile-tab">

					<!-- ----------- -->

					<div class="container w-100">
						<!-- <h1>Inline Edit DataTable Example with Dummy Data</h1> -->
						<table id="example" class="display table pt-3 w-100 "
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
					<!-- ---------------- -->

				</div>
				<div class="tab-pane fade" id="pills-contact" role="tabpanel"
					aria-labelledby="pills-contact-tab">

					<!-- ----------- -->

					<div class="container w-100">
						<!-- <h1>Inline Edit DataTable Example with Dummy Data</h1> -->
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
								<tr>
									<td>1</td>
									<td>john_doe</td>
									<td>$2a$10$gVg1FYinb3rXBDJjh1ewAOZ.W60beKl4qkpscaahYkphDw1pZQEkG</td>
									<td>john.doe@example.com</td>
									<td>123-456-7890</td>
									<td><button>Edit</button></td>
									<td><button>Delete</button></td>
								</tr>
								<tr>
									<td>2</td>
									<td>jane_smith</td>
									<td>$2a$10$gVg1FYinb3rXBDJjh1ewAOZ.W60beKl4qkpscaahYkphDw1pZQEkG</td>
									<td>jane.smith@example.com</td>
									<td>987-654-3210</td>
									<td><button>Edit</button></td>
									<td><button>Delete</button></td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- ---------------- -->
				</div>
			</div>
		</nav>








	</div>





	<!-- Javascript Links -->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>


	<!-- DataTables JS -->
	<script
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

	<!-- Bootstrap JS (optional) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>