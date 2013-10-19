<html>
	<head>
		<meta charset="UTF-8">
		<title>Bin Types</title>
	</head>
	<body>
		Bin Types	
		<form action="./wm01">
			<input type="submit" value="ADD" />
			<table border="1" width="100%">
				<thead>
					<tr width="100%">
						<td>Type Code</td>
						<td>Description</td>
						<td width="25"></td>
					</tr>
				</thead>
				<tbody>
					<#list binTypes as binType>
						<tr>
							<td>${binType.binTypeCode}</td>
							<td>${binType.binTypeDescription}</td>
							<td><a href="./wm01?id=${binType.id}">edit</a></td>							
						</tr>
					</#list>
				</tbody>
			</table>
		</form>
	</body>
</html>