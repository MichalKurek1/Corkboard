$(document).ready(function () {

    product();
    photo();

    function photo() {

        var urlParams = new URLSearchParams(window.location.search);
        var param = urlParams.get('product');

        $.ajax({
            url: 'http://localhost:8080/pictures/'+param,
            type: 'GET',
            success: function (result) {
                var rawImageData = result.image;
                $("#image").attr("src","data:image/gif;base64," + rawImageData);
            }
        });

    }

    function product() {
        var name = $('#name');
        var price = $('#price');
        var description = $('#description');
        var user = $('#user');
        var photo = $('#photo');

        var urlParams = new URLSearchParams(window.location.search);
        var param = urlParams.get('product');

        $.ajax({
            url: 'http://localhost:8080/adds/'+param,
            type: 'GET',
            success: function (result) {
                name.text(result.title);
                price.text("$ "+result.price);
                description.text(result.fullDescription);
                user.text("Contact: "+result.username.firstName+" "+result.number);
                var rawImageData = result.image;
                $("#image").attr("src","data:image/gif;base64," + result.image);
            }
        });



    }
});