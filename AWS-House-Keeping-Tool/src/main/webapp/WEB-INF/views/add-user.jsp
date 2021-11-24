<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<div class="container">
	Add New User <font color="red">${errorMessage}</font>
	<form method="POST" action="add-user.do">
		<fieldset class="form-group">
			<label>First Name</label> <input name="firstName" type="text"
				class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>Last Name</label> <input name="lastName" type="text"
				class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>User Name</label> <input name="userName" type="text"
				class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>Password</label> <input name="password" type="password"
				class="form-control" />
		</fieldset>



		<div class="form-group">
			<label for="exampleSelect1">role</label> <select class="form-control"
				id="role" name="role">
				<option>Admin</option>
				<option>SuperAdmin</option>
			</select>
		</div>

		<div class="form-group">
			<label for="exampleSelect1">Account name</label> <select
				class="form-control" id="exampleSelect1">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">Email address</label> <input
				type="email" class="form-control" id="email" name="email"
				aria-describedby="emailHelp" placeholder="Enter email"> <small
				id="emailHelp" class="form-text text-muted">We'll never
				share your email with anyone else.</small>
		</div>
		
		<input name="add" type="submit" class="btn btn-success" value="Submit" />
		<button type="button" class="btn btn-danger">Cancel</button>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>