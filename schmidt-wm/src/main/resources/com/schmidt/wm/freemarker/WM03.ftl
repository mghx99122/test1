<html>
	<head>
		<meta charset="UTF-8">
		<title>Maintain Bin</title>
	</head>
	<body>
		Maintain Bin
		<form  method="post" action="./wm03">
			<table border="1" width="100%">
				<tr>
					<td>Bin Code</td>
					<td>
						<input id="binCode" name="binCode" type="text" value="${binCode}"/>			
					</td>
				</tr>
				<tr>
					<td>Section</td>
					<td>
						<select name="sectionCode", id="sectionCode">
							<#list binSections as scd>
								<#if scd == sectionCode>
									<option value="${scd}" selected="selected">${scd}</option>
								<#else>
									<option value="${scd}">${scd}</option>
								</#if>
							</#list>
						</select>			
					</td>
				</tr>
				<tr>
					<td>Type</td>
					<td>
						<select name="typeCode", id="typeCode">
							<#list binTypes as tcd>
								<#if tcd == typeCode>
									<option value="${tcd}" selected="selected">${tcd}</option>
								<#else>
									<option value="${tcd}">${tcd}</option>
								</#if>
							</#list>
						</select>			
					</td>
				</tr>
				<tr>
					<td>State</td>
					<td>
						<select name="state", id="state">
							<#list states as sta>
								<#if sta == state>
									<option value="${sta}" selected="selected">
										<#switch sta>
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
									</option>
								<#else>
									<option value="${sta}">
										<#switch sta>
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
									</option>
								</#if>
							</#list>
						</select>		
					</td>
				</tr>
				<tr>
					<td>Line</td>
					<td>
						<input id="line" name="line" type="text" value="${line}"/>			
					</td>
					<td>
				</tr>
				<tr>
					<td>Row</td>
					<td>
						<input id="row" name="row" type="text" value="${row}"/>			
					</td>
					<td>
				</tr>
				<tr>
					<td>Column</td>
					<td>
						<input id="column" name="column" type="text" value="${column}"/>			
					</td>
					<td>
				</tr>
				<tr>
					<td>Length</td>
					<td>
						<input id="length" name="length" type="text" value="${length}"/>			
					</td>
					<td>
				</tr>
				<tr>
					<td>Width</td>
					<td>
						<input id="width" name="width" type="text" value="${width}"/>			
					</td>
					<td>
				</tr>
				<tr>
					<td>Height</td>
					<td>
						<input id="height" name="height" type="text" value="${height}"/>			
					</td>
					<td>
				</tr>
				<tr>
					<td>Load Weight</td>
					<td>
						<input id="weight" name="weight" type="text" value="${weight}"/>			
					</td>
					<td>
				</tr>
				<tr>
					<td>Description</td>
					<td>
						<textarea id="description" name="description" rows="3" cols="30">${description}</textarea>
					</td>
				</tr>
			</table>
			<table border="1" width="100%">
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