$(document).ready(function () {



    $("#data").submit(function(e) {
        e.preventDefault();
        var formData = new FormData(this);

        $.ajax({
            url: "http://localhost:8080/adds",
            type: "POST",
            // dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function () {
            },
        })

    });

});

