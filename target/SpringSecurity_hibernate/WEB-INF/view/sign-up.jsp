<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="includes/base.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header">
						<h3>Please Sign Up</h3>

					</div>
					<div class="card-body">
						<form:form  action ="process-signup" method ="POST" modelAttribute="UserInfo">
						   <div class="mb-3">
								<label>User Name</label> 
								<input type="text" name="userName"
									class="form-control">
								<form:errors path="userName" cssClass="error"></form:errors>
							</div>
							<div class="mb-3">
								<label>Email</label> <input type="text" name="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
									<form:errors path="email" cssClass="error"></form:errors>
							</div>
							
							<div class="mb-3">
								<label>First Name</label> <input type="text" name="firstName"
									class="form-control">
								<form:errors path="firstName" cssClass="error"></form:errors>
							</div>
							<div class="mb-3">
								<label>Last Name</label> <input type="text" name="lastName"
									class="form-control">
								<form:errors path="lastName" cssClass="error"></form:errors>
							</div>
							
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" name="password" class="form-control"
									id="exampleInputPassword1">
									<form:errors path="password" cssClass="error"></form:errors>
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Check me out</label>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>

						</form:form>

					</div>

				</div>


			</div>

		</div>

	</div>

</body>
</html>