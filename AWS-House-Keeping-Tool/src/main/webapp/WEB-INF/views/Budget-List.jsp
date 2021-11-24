<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H6>Welcome ${name}</H6>

	<table class="table table-striped table-bordered table-hover">
		<caption>All Budgets</caption>
		<thead>
		<tr class="info">
			<th>Budget Id</th>
			<th>Budget Start Date</th>
			<th>Budget End Date</th>
			<th>Budget Amount</th>
			<th>Budget Description</th>
			<th>Budget Conditional Operator</th>
			<th>Account Id</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${budgets}" var="budget">
				<tr>
					<td>${budget.budgetId}</td>
					<td>${budget.budgetStartDate}</td>
					<td>${budget.budgetEndDate}</td>
					<td>${budget.budgetAmount}</td>
					<td>${budget.budgetDescription}</td>
					<td>${budget.budgetConditionalOperator}</td>
					<td>${budget.accountId}</td>

					<td>&nbsp;&nbsp;<a class="btn btn-danger"
						href="delete-budget.do?&bubgetId=${budget.budgetId}&budgetStartDate=${budget.budgetStartDate}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="add-budget.do">Add New Budget</a>
</div>

<%@ include file="../common/footer.jspf"%>