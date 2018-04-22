$(document).ready(function() {	
	//$(".myImg").click(function() {
	$(".sd-view").on( "click", ".myImg", function() {
		$(".modal").css({
			"display" : "block"
		});
		$(".modal-content").attr("src", this.src).width(this.naturalWidth).height(this.naturalHeight);
	});
	//$(".close").click(function() {
	$("body").on( "click", ".close", function() {
		$(".modal").css({
			"display" : "none"
		});
	});
});