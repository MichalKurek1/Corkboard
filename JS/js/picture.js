$(document).ready(function () {


    var submit = $('#submit');

    submit.on('click', function () {
        var formData = new FormData($('#uploadForm')[0]);
        $.ajax({
            url: "http://localhost:8080/pictures",
            type: "POST",
            // dataType: 'text',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function () {

            },

        })

    })


})
