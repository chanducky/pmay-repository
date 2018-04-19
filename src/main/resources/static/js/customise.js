$(document).ready(function() {

	$(".myImg").click(function() {
		$(".modal").css({
			"display" : "block"
		});
		$(".modal-content").attr("src", this.src).width(this.naturalWidth).height(this.naturalHeight);
	});
	$(".close").click(function() {
		$(".modal").css({
			"display" : "none"
		});
	});
});