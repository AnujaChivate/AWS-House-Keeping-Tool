<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${firstName}</H1>


	<table class="table table-striped table-bordered table-hover">
		<caption>AWS Account-List</caption>
		<thead>
		<tr class="info">
			<th>Account Id</th>
			<th>Created On</th>
			<th>Created By</th>
			<th>Updated On</th>
			<th>Updated By</th>
			<th>hsps Id</th>
			<th>Project Expire Date</th>
			<th>Free Trial Expire Date</th>
			<th>AWS Account Owner Name</th>
			<th>hsps Expire Date</th>
			<th>Email Id Of Owner</th>
			<th>Projec tName</th>
			<th>Project Id</th>
			<th>Account Type</th>
			<th>hsps Description</th>
			<th>Business Unit</th>
			<th>AWS Account Number</th>
			<th>AWS Account Alias</th>
			<th>AWS Access Key</th>
			<th>AWS Secret Key</th>
			<th>awsAccessKeyXXXX</th>
			<th>awsSecretKeyXXXX</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.accountId}</td>
					<td>${account.createdOn}</td>
					<td>${account.createdBy}</td>
					<td>${account.updatedOn}</td>
					<td>${account.updatedBy}</td>
					<td>${account.hspsId}</td>
					<td>${account.projectExpireDate}</td>
					<td>${account.freeTrialExpireDate}</td>
					<td>${account.awsAccountOwnerName}</td>
					<td>${account.hspsExpireDate}</td>
					<td>${account.emailIdOfOwner}</td>
					<td>${account.projectName}</td>
					<td>${account.projectId}</td>
					<td>${account.accountType}</td>
					<td>${account.hspsDescription}</td>
					<td>${account.businessUnit}</td>
					<td>${account.awsAccountNumber}</td>
					<td>${account.awsAccountAlias}</td>
					<td>${account.awsAccessKey}</td>
					<td>${account.awsSecretKey}</td>
					<td>${account.awsAccessKeyXXXX}</td>
					<td>${account.awsSecretKeyXXXX}</td>

					<td>&nbsp;&nbsp;<a class="btn btn-danger"
						href="delete-account.do?&projectName=${account.projectName}&porjectId=${account.projectId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="add-account.do">Add New Account</a>
</div>

<%@ include file="../common/footer.jspf"%>