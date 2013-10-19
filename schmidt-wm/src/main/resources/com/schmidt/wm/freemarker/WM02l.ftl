<html>
	<head>
		<meta charset="UTF-8">
		<title>Bin Sections</title>
	</head>
	<body>
		Bin Sections	
		<form action="./wm02">
			<input type="submit" value="ADD" />
			<table border="1" width="100%">
				<thead>
					<tr width="100%">
						<td>Section Code</td>
						<td>Ware House Code</td>
						<td>Description</td>
						<td width="20"></td>
					</tr>
				</thead>
				<tbody>
					<#list binSections as binSection>
						<tr>
							<td>${binSection.sectionCode}</td>
							<td>${binSection.wareHouseCode}</td>
							<td>${binSection.description}</td>
							<td><a href="./wm02?id=${binSection.id}">edit</a></td>							
						</tr>
					</#list>
				</tbody>
			</table>
		</form>
	</body>
</html>