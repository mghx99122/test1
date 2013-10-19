<html>
	<head>
		<meta charset="UTF-8">
		<title>Maintain Bin Type</title>
	</head>
	<body>
		Maintain Bin Type
		<form  method="post" action="./wm01">
			<table border="1" width="100%">
				<tr>
					<td>Type Code</td>
					<td>
						<input id="typeCode" name="typeCode" type="text" value="${typeCode}"/>			
					</td>
				</tr>
				<tr>
					<td>Description</td>
					<td>
						<textarea id="typeDescription" name="typeDescription" rows="3" cols="30">${typeDescription}</textarea>
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
		<#if !firstin>
			<#if saved>
				Successful saved the Bin Type Information !
			</#if>
			<#if !saved>
				Sorry, cannot save the Bin Type Information !
			</#if>
		</#if>
	</body>
</html>