<%@ page pageEncoding="UTF-8"%>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Connexion" />
</jsp:include>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-6 col-lg-6 col-md-6">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-12">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Bienvenue</h1>
									</div>
									<form class="user" method="post" action="connexion">
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												id="login" name="login" aria-describedby="login"
												placeholder="Entrer votre login">
										</div>
										<div class="form-group">
											<input type="password" class="form-control form-control-user"
												id="motdepasse" name="motdepasse"
												placeholder="Entrer votre mot de passe">
										</div>
										<%
											if (request.getAttribute("messageErreur") != null) {
										%>
										<hr>
										<span class="erreur">
											<%
												out.println(request.getAttribute("messageErreur"));
											%>
										</span>
										<hr>
										<%
											}
										%>
										<input type="submit"
											class="btn btn-primary btn-user btn-block" value="Connexion" />
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

</body>

</html>