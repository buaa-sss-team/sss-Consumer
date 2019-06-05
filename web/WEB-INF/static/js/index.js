$(function() {
    $("#searchInput").keydown(function (event) {
        if (event.keyCode == 13) {
            var url=window.location.pathname.split("/");
            url[3]=$("#searchInput").val();

            window.location.href = url.join('/');
        }
    });
    $("#btnSearch").click(function () {
        var url=window.location.pathname.split("/");
        url[3]=$("#searchInput").val();

        window.location.href = url.join('/');
    });

    $("#btnNavSearch").click(function () {
        window.location.href = "/search/paper/" + $("#inputNavSearch").val();
    })
});