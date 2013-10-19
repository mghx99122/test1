<html>
	<head>
		<meta charset="UTF-8">
		<title>Bins</title>
	</head>
	<body>
		Bins	
		<form action="./wm03">
			<input type="submit" value="ADD" />
			<table border="1" width="100%">
				<thead>
					<tr width="100%">
						<td>Bin Code</td>
						<td>Section</td>
						<td>Type</td>
						<td>Line</td>
						<td>Row</td>
						<td>Column</td>
						<td>Length</td>
						<td>Width</td>
						<td>Height</td>
						<td>Load Weight</td>
						<td>Description</td>
						<td width="25"></td>
					</tr>
				</thead>
				<tbody>
					<#list bins as bin>
						<tr>
							<td>${bin.binCode}</td>
							<td>${bin.sectionCode}</td>
							<td>${bin.typeCode}</td>
							<td>
								<#switch bin.state>
  									<#case "N">
    									Normal
    									<#break>
  									<#case "E">
    									Empty
    									<#break>
  									<#case "B">
    									Block
    									<#break>
  									<#default>
    									Normal
								</#switch>
							</td>
							<td>${bin.line}</td>
							<td>${bin.row}</td>
							<td>${bin.column}</td>
							<td>${bin.length}</td>
							<td>${bin.width}</td>
							<td>${bin.height}</td>
							<td>${bin.weight}</td>
							<td>${bin.description}</td>
							<td><a href="./wm03?id=${bin.id}">edit</a></td>							
						</tr>
					</#list>
				</tbody>
			</table>
		</form>
	</body>
</html>