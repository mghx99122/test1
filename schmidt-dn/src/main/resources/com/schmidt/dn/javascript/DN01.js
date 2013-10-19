/**
 * add item
 * 
 */
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

/**
 *remove item
 */
function removeItem(id) { 
	var tbody = document.getElementById("itemBody");
	var item = document.getElementById(id);
	if (tbody.childNodes.length > 0) {
		tbody.removeChild(item);
	}
}
