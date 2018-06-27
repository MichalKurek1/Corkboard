$(document).ready(function () {

    var cars = $('#cars');
    var parts = $('#parts');
    var wheels = $('#wheels');


    cars.on('click', function () {

        var adds = $('#adds');
        var sliders = $('#sliders');


        adds.empty();
        sliders.empty();

        $.ajax({
            url: 'http://localhost:8080/adds/active/1',
            type: 'GET',
            success: function (result) {

                for (var i = 0; i < result.length; i++) {

                    switch (i) {
                        case 0:
                            var html2 = "";
                            html2 +=
                                '<div class="carousel-item active">'
                                + '<img class="d-block img-fluid" src="data:image/gif;base64,' + result[i].image + '"alt="First slide" width="900" height="400">' + '</div>'
                            sliders.append(html2);
                            break;
                        case 1:
                            var html2 = "";

                            html2 +=
                                '<div class="carousel-item ">'
                                + '<img class="d-block img-fluid" src="data:image/gif;base64,' + result[i].image + '"alt="Second slide" width="900" height="400">' + '</div>'

                            sliders.append(html2);
                            break;
                            case2:
                                var html2 = "";

                            html2 +=
                                '<div class="carousel-item ">'
                                + '<img class="d-block img-fluid" src="data:image/gif;base64,' + result[i].image + '"alt="Third slide" width="900" height="400">' + '</div>'

                            sliders.append(html2);
                            break;
                    }


                    // if(i<3){
                    // var html2="";
                    //
                    // html2 +=
                    // '<div class="carousel-item active">'
                    //     +'<img class="d-block img-fluid" src="data:image/gif;base64,'+result[i].image+'"alt="First slide">'+'</div>'
                    //
                    //     sliders.append(html2);
                    // }


                    var html = "";

                    html +=
                        '<div class="col-lg-4 col-md-6 mb-4">'
                        + '<div class="card h-100">'
                        + '<a href="#">'
                        + '<img class="card-img-top" src="data:image/gif;base64,' + result[i].image + '" alt="">'
                        + '</a>'
                        + '<div class="card-body">'
                        + '<h4 class="card-title">'
                        + '<a href="singleAdd.html?product=' + result[i].id + '">' + result[i].title + '</a>'
                        + '</h4>'
                        + '<h5>$ ' + result[i].price + '</h5>'
                        + '<p class="card-text">' + result[i].shortDescription + '</p>'
                        + '</div>'
                        + '</div>'
                        + '</div>';


                    adds.append(html);
                }
            }
        })
    })

    parts.on('click', function () {

        var adds = $('#adds');
        var sliders = $('#sliders');


        adds.empty();
        sliders.empty();

        $.ajax({
            url: 'http://localhost:8080/adds/active/2',
            type: 'GET',
            success: function (result) {

                for (var i = 0; i < result.length; i++) {
                    var html = "";
                    html +=
                        '<div class="col-lg-4 col-md-6 mb-4">'
                        + '<div class="card h-100">'
                        + '<a href="#">'
                        + '<img class="card-img-top" src="http://placehold.it/700x400" alt="">'
                        + '</a>'
                        + '<div class="card-body">'
                        + '<h4 class="card-title">'
                        + '<a href="#">' + result[i].title + '</a>'
                        + '</h4>'
                        + '<h5>$ ' + result[i].price + '</h5>'
                        + '<p class="card-text">' + result[i].shortDescription + '</p>'
                        + '</div>'
                        + '</div>'
                        + '</div>';

                    adds.append(html);
                }
            }
        })
    })

    wheels.on('click', function () {

        var adds = $('#adds');
        var sliders = $('#sliders');


        adds.empty();
        sliders.empty();

        $.ajax({
            url: 'http://localhost:8080/adds/active/3',
            type: 'GET',
            success: function (result) {

                for (var i = 0; i < result.length; i++) {
                    var html = "";
                    html +=
                        '<div class="col-lg-4 col-md-6 mb-4">'
                        + '<div class="card h-100">'
                        + '<a href="">'
                        + '<img class="card-img-top" src="http://placehold.it/700x400" alt="">'
                        + '</a>'
                        + '<div class="card-body">'
                        + '<h4 class="card-title">'
                        + '<a href="">' + result[i].title + '</a>'
                        + '</h4>'
                        + '<h5>$ ' + result[i].price + '</h5>'
                        + '<p class="card-text">' + result[i].shortDescription + '</p>'
                        + '</div>'
                        + '</div>'
                        + '</div>';

                    adds.append(html);
                }
            }
        })
    })

});