var shown = false;
var baseUrl = "http://localhost:8080/naKup/";
//var baseUrl = "http://nakup.herokuapp.com/";

$( window ).load(function() {
	$("#cart-noajax-button").css({"display" : "none"});
	$("#cart-ajax-button").show();
	loadCart();
	
	$("#cart-ajax-button").on("click", function (evt) {
		if (!shown) {
			loadCart();
			$('#cart-ajax-button').popover('show');
			shown = true;
		} else {
			$('#cart-ajax-button').popover('destroy');
			shown = false;
		}
	});
});

function loadCart() {
	
	var getCartUrl = baseUrl + "ajax/cart";
	$.getJSON(getCartUrl, function (data) {
		$("#cart-ajax-table").hide();
		var content = "<div style=\"width: 250px;\">";
		
		var empty = isEmpty(data);
		if (!empty) {
			content += "<table id=\"cart-ajax-table\" class=\"table\">";
			content += "<thead></thead><tbody>";
			
			var i;
			for (i in data) {
				var goods = data[i];
				content += "<tr><td>" + goods.name + "</td><td><button onclick=\"removeCartItem(" + goods.entityId + ")\"><span class=\"glyphicon glyphicon-trash\"></span></button></td></tr>";
			}
			var badges = parseInt(i);
			++badges;
			$("#cart-ajax-button .badge").html(badges);
			
			content += "</tbody></table>";
			content += "<button style=\"\" onclick=\"emptyCart()\" class=\"btn btn-danger\">Remove all</button>";
			content += "<button style=\"position: relative; left: 50px;\" onclick=\"sendCart()\" class=\"btn btn-primary\">Send order</button>";
		} else {
			content += "Cart is empty. Add some goods.";
			$("#cart-ajax-button .badge").html(0);
		}
		
		content += "</div>";
		$("#cart-ajax-button").attr("data-content", content);
		$("#cart-ajax-table").fadeIn("fast");
	});
	
}

function removeCartItem(goodsId) {
	var nakupUrl = baseUrl + "ajax/cart/remove/" + goodsId;
	$.ajax({
		type: "POST",
		url: nakupUrl
	});
	$("#cart-ajax-button").attr("data-content", "");
	loadCart();
}

function emptyCart() {
	var emptyCartUrl = baseUrl + "ajax/cart/empty";
	$.ajax({
		type: "POST",
		url: emptyCartUrl
	});
	$("#cart-ajax-button").attr("data-content", "");
	loadCart();
}

function sendCart() {
	var sendCartUrl = baseUrl + "cart/send";
	$.ajax({
		type: "POST",
		url: sendCartUrl
	});
	$("#cart-ajax-button").attr("data-content", "");
	loadCart();
}

function isEmpty(data) {
	for (var i in data) {
		return false;
	}
	return true;
}

