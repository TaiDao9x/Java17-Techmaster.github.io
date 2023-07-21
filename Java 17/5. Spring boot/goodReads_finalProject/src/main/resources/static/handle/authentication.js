//PAGE LOADER
$(window).on("load", function () {

    function checkLoggedIn() {
        const jwtToken = localStorage.getItem("jwtToken");
        if (!jwtToken) {
            const userInfo = JSON.parse(localStorage.getItem("userInfomation"));
            $(".tg-userlogin").empty();
            const userHtmlContent = "<div class='btn-group btn-group-regis'>\n" +
                "<a type=\"button\" href=\"/login\" class=\"btn btn-regis-signin\">SIGN IN</a>\n" +
                " <a type=\"button\" href=\"/signup\" class=\"btn btn-regis-signup\">SIGN UP</a>\n" +
                " </div>";
            $(".tg-userlogin").append(userHtmlContent);
        } else {
            const userHtmlContent = "<figure><a href=\"javascript:void(0);\"><img src=\"original/images/users/img-01.jpg\"\n" +
                "                                                                       alt=\"image description\"></a></figure>\n" +
                "                            <span>Hi, John</span>";
            $(".tg-userlogin").append(userHtmlContent);
        }
    }

    checkLoggedIn();

});

jQuery(function ($) {

    $('.sign-out').click(() => {
        let jwtToken = getJwtToken();
        if (jwtToken) {
            $.ajax({
                url: '/api/v1/authentication/logout',
                type: 'POST',
                headers: {
                    'Authorization': 'Bearer' + " " + jwtToken
                },
                success: function () {
                    localStorage.clear()
                    toastr.success("Log out success")

                    setTimeout(function () {
                        window.location.reload();
                        // window.location.href = 'http://localhost:8080/login';
                    }, 700)
                },
                error: function () {

                }
            })
        } else {
            toastr.warning("You are not log in")
        }
    });

});

function getJwtToken() {
    return localStorage.getItem('jwtToken');
}

function getRefreshToken() {
    return localStorage.getItem('refreshToken');
}

function refreshToken() {
    let jwtToken = getJwtToken();
    if (!jwtToken) {
        return;
    }
    let refreshToken = getRefreshToken();
    let request = {
        refreshToken: refreshToken
    };
    $.ajax({
        url: "/api/v1/authentication/refresh-token",
        type: "POST",
        data: JSON.stringify(request),
        contentType: "application/json; charset=utf-8",
        headers: {
            'Authorization': 'Bearer' + " " + jwtToken
        },
        success: function (response) {
            localStorage.setItem("jwtToken", response.jwt);
        },
        error: function () {
            console.log(error);
        }
    })
}

setInterval(refreshToken, 29.5 * 60 * 1000);

