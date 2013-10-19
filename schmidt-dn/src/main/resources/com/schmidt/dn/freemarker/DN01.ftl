<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Delivery Notes</title>
	</head>
	<script type="text/javascript" >
		function addItem() {
			var tbody = document.getElementById("itemBody");
			var sampleBody = document.getElementById("itemBodySample");
			var item;
			for (var strid = 0; strid < sampleBody.childNodes.length; strid++) {
				if (sampleBody.childNodes[strid].nodeName == "TR") {
					item = sampleBody.childNodes[strid].cloneNode(true);
					break;
				}		
			}
			var number = 1;
			if (tbody.childNodes.length > 0) {
				for(var trid = tbody.childNodes.length - 1; trid >= 0; trid--) {
					if (tbody.childNodes[trid].nodeName == "TR") {
						var lastItem = tbody.childNodes[trid].getAttribute("id").substring(2);
						var number = parseInt(lastItem) + 1;
						break;
					}
				}
			}
			var tnumber = "-" + number.toString();
			item.setAttribute("id",
			item.getAttribute("id").replace("[id]", tnumber));
			for(var trid = 0; trid < item.childNodes.length; trid++) {
				if (item.childNodes[trid].nodeName == "TD") {
					for(var tcid = 0; tcid < item.childNodes[trid].childNodes.length; tcid++) {
						if(item.childNodes[trid].childNodes[tcid].nodeName == "INPUT") {
							if (item.childNodes[trid].childNodes[tcid].getAttribute("id") != null &&
								item.childNodes[trid].childNodes[tcid].getAttribute("id") != ""
							) {
								item.childNodes[trid].childNodes[tcid].setAttribute("id",
								item.childNodes[trid].childNodes[tcid].getAttribute("id").replace("[id]", tnumber)
								);
								item.childNodes[trid].childNodes[tcid].setAttribute("name",
								item.childNodes[trid].childNodes[tcid].getAttribute("name").replace("[id]", tnumber)
								);
							} else {
								item.childNodes[trid].childNodes[tcid].onclick = function() {
									removeItem("r" + tnumber);
								}
								
							}
						}
					}
				}
			}
			tbody.appendChild(item);
		}
		
		function removeItem(id) { 
			var tbody = document.getElementById("itemBody");
			var item = document.getElementById(id);
			if (tbody.childNodes.length > 0) {
				tbody.removeChild(item);
			} 
		}
	</script>
	<body>
		Create Delivery Notes
		<form id="dn01" method="post" action="./dn01">
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
			<table border="1" width="100%">
				<tr>
					<td>Delivery Note Number</td>
					<td>
						<input id="deliveryNo" name="deliveryNo" type="text" value="${deliveryNo}"/>			
					</td>
				</tr>
				<tr>
					<td>Delivery Date</td>
					<td>
						<input id="deliveryDate" name="deliveryDate" type="text""/>			
					</td>
				</tr>
				<tr>
					<td>Description</td>
					<td>
						<textarea id="description" name="description" rows="3" cols="30"></textarea>
					</td>
				</tr>
			</table>
			Delivery Items
			<table border="1" width="100%">
				<thead>
					<tr>
						<td>Material</td>
						<td>Number</td>
						<td>Price</td>
						<td>Description</td>
						<td></td>
					</tr>
				</thead>
				<tbody id="itemBody">
					<tr id="r-1">
						<td>
							<input id="material-1" name="material-1" type="text"/>
						</td>
						<td>
							<input id="number-1" name="number-1" type="text"/>
						</td>
						<td>
							<input id="price-1" name="price-1" type="text"/>
						</td>
						<td>
							<input id="itemDesc-1" name="itemDesc-1" type="text"/>
						</td>
						<td>
							<input type="button" value="-" onclick="removeItem('r-1')"/>
						</td>
					</tr>
				</tbody>
			</table>
			<table border="1" width="100%">
				<tr>
					<td width="90%"></td>
					<td>
						<input type="button" value="ADD" onclick="addItem()"/>
					</td>
				</tr>
			</table>
			<table style="display:none">
				<tbody id="itemBodySample">
						<tr id="r[id]">
							<td>
								<input id="material[id]" name="material[id]" type="text"/>
							</td>
							<td>
								<input id="number[id]" name="number[id]" type="text"/>
							</td>
							<td>
								<input id="price[id]" name="price-" type="text"/>
							</td>
							<td>
								<input id="itemDesc[id]" name="itemDesc[id]" type="text"/>
							</td>
							<td>
								<input type="button" value="-" onclick="removeItem('r[id]')"/>
							</td>
						</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>