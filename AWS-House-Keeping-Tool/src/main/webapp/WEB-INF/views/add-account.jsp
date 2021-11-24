<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<div class="container">
	Add New Account <font color="red">${errorMessage}</font>
	<form method="POST" action="add-account.do">


		<fieldset class="form-group">
			<label>Project Id</label> <input name="projectId" type="text"
				class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>Project Name</label> <input name="projectName" type="text"
				class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>AWS Account Number</label> <input name="awsAccountNumber"
				type="text" class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>AWS Account Owner Name</label> <input
				name="awsAccountOwnerName" type="text" class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>Email Id Of Owner</label> <input name="emailIdOfOwner"
				type="text" class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>AWS Account Alias</label> <input name="awsAccountAlias"
				type="text" class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>Account Type</label> <input name="accountType" type="text"
				class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>hspsId</label> <input name="hspsId" type="text"
				class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>HSPS Description</label> <input name="hspsDescription"
				type="text" class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>Business Unit</label> <input name="businessUnit" type="text"
				class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>AWS Access Key</label> <input name="awsAccessKey" type="text"
				class="form-control" />
		</fieldset>

		<fieldset class="form-group">
			<label>AWS Secret Key</label> <input name="awsSecretKey" type="text"
				class="form-control" />
		</fieldset>


		<input name="add" type="submit" class="btn btn-success" value="Submit" />
		<button type="button" class="btn btn-danger">Cancel</button>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>