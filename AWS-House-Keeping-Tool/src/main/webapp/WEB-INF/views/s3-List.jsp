<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H6>Welcome ${name}</H6>
	<p>
		<font color="red">${errorMessage}</font>
	</p>




	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr class="info">
				<th>Name</th>
				<th>CreationDate</th>
				<th>Owner</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bucket" items="${s3Buckets}">
				<tr>
					<td>${bucket.name}</td>
					<td>${bucket.creationDate}</td>
					<td>${bucket.owner}</td>
				
				</tr>
			</c:forEach>
		</tbody>
	</table>






</div>
<%@ include file="../common/footer.jspf"%>