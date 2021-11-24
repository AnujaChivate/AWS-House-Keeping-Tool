<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>



<div class="container">
	Add New Budget <font color="red">${errorMessage}</font>
	<form method="POST" action="add-budget.do">
		<fieldset class="form-group">
			<label>Budget Id</label> <input name="budgetId" type="text"
				class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>Budget Start Date</label> <input name="budgetStartDate"
				type="text" class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>Budget End Date</label> <input name="budgetEndDate"
				type="text" class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>Budget Amount</label> <input name="budgetAmount" type="text"
				class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>Budget Description</label> <input name="budgetDescription"
				type="text" class="form-control" />
		</fieldset>


		<fieldset class="form-group">
			<label>Budget Conditional Operator</label> <input
				name="budgetConditionalOperator" type="text" class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>Account Id</label> <input name="accountId" type="text"
				class="form-control" />
		</fieldset>


		<input name="add" type="submit" class="btn btn-success" value="Submit" />
		<button type="button" class="btn btn-danger">Cancel</button>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>