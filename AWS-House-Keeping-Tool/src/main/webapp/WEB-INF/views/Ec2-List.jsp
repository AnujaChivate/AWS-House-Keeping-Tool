<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H6>Welcome ${name}</H6>
	<p>
		<font color="red">${errorMessage}</font>
	</p>


	<c:forEach var="ec2" items="${ec2instances}">


		<table class="table table-striped table-bordered table-hover">
			<caption>Region: ${ec2.key}</caption>
			<thead>
				<tr class="info">
					<th>Instance Id</th>
					<th>Instance Type</th>
					<th>Launch Time</th>
					<th>Public IP</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="instance" items="${ec2.value}">
					<tr>
						<td>${instance.instanceId}</td>
						<td>${instance.instanceType}</td>
						<td>${instance.launchTime}</td>
						<td>${instance.publicIpAddress}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</c:forEach>



</div>
<%@ include file="../common/footer.jspf"%>