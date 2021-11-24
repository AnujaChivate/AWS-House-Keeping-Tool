<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H6>Welcome ${name}</H6>

	<table class="table table-striped table-bordered table-hover">
		<caption>All Users</caption>
		<thead>
		<tr class="info">
			<th>ID</th>
			<th>User Name</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Create On</th>
			<th>Role</th>
			<th>Is Active</th>
			<th>Create By</th>
			<th>Updated On</th>
			<th>Updated By</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.uid}</td>
					<td>${user.userName}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
					<td>${user.createOn}</td>
					<td>${user.role}</td>
					<td>${user.isActive}</td>
					<td>${user.createdBy}</td>
					<td>${user.updatedOn}</td>
					<td>${user.updatedBy}</td>
					<td>&nbsp;&nbsp;<a class="btn btn-danger"
						href="delete-user.do?&firstName=${user.firstName}&lastname=${user.lastName}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="add-user.do">Add New User</a>
</div>

<%@ include file="../common/footer.jspf"%>