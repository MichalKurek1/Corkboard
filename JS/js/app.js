$(document).ready(function () {

    var cars = $('#cars');
    var parts = $('#parts');
    var wheels = $('#wheels');


     cars.on('click', function () {

        var adds = $('#adds');

        adds.empty();

        $.ajax({
            url: 'http://localhost:8080/adds/active/1',
            type:'GET',
            success: function(result){

                for(var i=0; i<result.length; i++){
                    var html = "";
                    html +=
                        '<div class="col-lg-4 col-md-6 mb-4">'
                            +'<div class="card h-100">'
                                +'<a href="#">'
                                    +'<img class="card-img-top" src="http://placehold.it/700x400" alt="">'
                                +'</a>'
                        +'<div class="card-body">'
                            +'<h4 class="card-title">'
                                +'<a href="pages/singleAdd.html?product='+result[i].id+'">'+result[i].title+'</a>'
                            +'</h4>'
                            +'<h5>$ '+result[i].price+'</h5>'
                        +'<p class="card-text">'+result[i].shortDescription+'</p>'
                        +'</div>'
                        +'</div>'
                        +'</div>';


                    adds.append(html);
                }
            }
        })
    })

    parts.on('click', function () {

        var adds = $('#adds');

        adds.empty();

        $.ajax({
            url: 'http://localhost:8080/adds/active/2',
            type:'GET',
            success: function(result){

                for(var i=0; i<result.length; i++){
                    var html = "";
                    html +=
                        '<div class="col-lg-4 col-md-6 mb-4">'
                        +'<div class="card h-100">'
                        +'<a href="#">'
                        +'<img class="card-img-top" src="http://placehold.it/700x400" alt="">'
                        +'</a>'
                        +'<div class="card-body">'
                        +'<h4 class="card-title">'
                        +'<a href="#">'+result[i].title+'</a>'
                        +'</h4>'
                        +'<h5>$ '+result[i].price+'</h5>'
                        +'<p class="card-text">'+result[i].shortDescription+'</p>'
                        +'</div>'
                        +'</div>'
                        +'</div>';

                    adds.append(html);
                }
            }
        })
    })

    wheels.on('click', function () {

        var adds = $('#adds');

        adds.empty();

        $.ajax({
            url: 'http://localhost:8080/adds/active/3',
            type:'GET',
            success: function(result){

                for(var i=0; i<result.length; i++){
                    var html = "";
                    html +=
                        '<div class="col-lg-4 col-md-6 mb-4">'
                        +'<div class="card h-100">'
                        +'<a href="">'
                        +'<img class="card-img-top" src="http://placehold.it/700x400" alt="">'
                        +'</a>'
                        +'<div class="card-body">'
                        +'<h4 class="card-title">'
                        +'<a href="">'+result[i].title+'</a>'
                        +'</h4>'
                        +'<h5>$ '+result[i].price+'</h5>'
                        +'<p class="card-text">'+result[i].shortDescription+'</p>'
                        +'</div>'
                        +'</div>'
                        +'</div>';

                    adds.append(html);
                }
            }
        })
    })

});