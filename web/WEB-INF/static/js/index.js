$(function() {
    $("#searchInput").keydown(function (event) {
        if (event.keyCode == 13) {
            window.location.href = "/search/paper/" + $("#searchInput").val();
        }
    })
});