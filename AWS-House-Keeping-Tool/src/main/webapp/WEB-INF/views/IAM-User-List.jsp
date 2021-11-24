<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H6>Welcome ${name}</H6>
	<p>
		<font color="red">${errorMessage}</font>
	</p>




	<table class="table table-striped table-bordered table-hover">
		<caption>All Users</caption>
		<thead>
			<tr class="info">
				<th>User Name</th>
				<th>Create Date</th>
				<th>Password Last Used</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.userName}</td>
					<td>${user.createDate}</td>
					<td>${user.passwordLastUsed}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




</div>
<%@ include file="../common/footer.jspf"%>