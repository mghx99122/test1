<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>POLIST</title>
	</head>
	<body>
		<form  method="post" action="./gr01q">
			<table border="1" width="100%">
				<tr>
					<td>PO NO.</td>
					<td>
						<input id="POSHNO" name="POSHNO" type="text" value="${POSHNO!}"/>			
					</td>
				</tr>
				<tr> 
					<td colspan=2>
						<input type="submit" value="Query" />
					</td>
				</tr>
			</table>
		</form>
		<#if (poheads?size>0) >
			<table border="1" width="100%">
					<thead>
						<tr width="100%">
							<td>PO NO.</td>
							<td>Pucharse Time</td>
							<td>Desc</td>
						</tr>
					</thead>
					<tbody>
						<#list poheads as pohead>
							<tr>
								<td>${pohead.POSHNO}</td>
								<td>${pohead.POSHDT1}</td>
								<td>${pohead.PODESC}</td>							
							</tr>
						</#list>
					</tbody>
			</table>
	  </#if>
	</body>
</html>