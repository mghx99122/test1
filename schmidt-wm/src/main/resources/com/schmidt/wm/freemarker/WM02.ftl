<html>
	<head>
		<meta charset="UTF-8">
		<title>Maintain Bin Section</title>
	</head>
	<body>
		Maintain Bin Section
		<form  method="post" action="./wm02">
			<table border="1" width="70%">
				<tr>
					<td>Section Code</td>
					<td>
						<input id="sectionCode" name="sectionCode" type="text" value="${sectionCode}"/>			
					</td>
				</tr>
				<tr>
					<td>Ware House Code</td>
					<td>
						<select name="wareHouseCode", id="wareHouseCode">
							<#list wareHouseCodes as whc>
								<#if whc == wareHouseCode>
									<option value="${whc}" selected="selected">${whc}</option>
								<#else>
									<option value="${whc}">${whc}</option>
								</#if>
							</#list>
						</select>			
					</td>
				</tr>
				<tr>
					<td>Description</td>
					<td>
						<textarea id="description" name="description" rows="3" cols="30">${description}</textarea>
					</td>
				</tr>
				<tr> 
					<td width="50%">
						<input type="submit" value="SAVE" />
					</td>
				<td>
						<input type="button" value="CANCEL"/>			
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>