<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="includes/base.jsp"%>
	<main class="flex-d align-items-center">
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card">
						<div class="card-header">
							<p>Please log in</p>
						</div>

                     <div class="card-body">
						<c:if test="${param.error != null }">
							<i style="color: red;"> Invalid user name or password </i>
						</c:if>



						<form:form action="process-login" method="POST">

							<div class="mb-3">
								<label>User name</label> 
								<input type="text" name="username"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" name="password" class="form-control"
									id="exampleInputPassword1">
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
	</main>
</body>
</html>