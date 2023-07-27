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
        // headers: {
        //     'Authorization': 'Bearer' + " " + jwtToken
        // },
        success: function (response) {
            localStorage.setItem("jwtToken", response.jwt);
        },
        error: function () {
            console.log(error);
        }
    })
}

setInterval(refreshToken, 29.5 * 60 * 1000);

// login and signup
$(document).ready(function () {
    // Sign up
    toastr.options = {
        positionClass: 'toast-center',
        timeOut: 1500
    };

    $("#register-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element);
        },
        rules: {
            "email": {
                required: true,
                email: true
            },
            "password": {
                required: true,
            },
            "re-pass": {
                required: true,
                equalTo: "#password"
            }
        },
        messages: {
            "email": {
                required: "Enter your email",
                email: "Incorrect email format"
            },
            "password": {
                required: "Enter your password"
            },
            "re-pass": {
                required: "Repeat your password",
                equalTo: "Re-password incorrect"
            }
        }
    });

    $("#signup").click((key, value) => {
        let isValidForm = $("#register-form").valid()
        if (!isValidForm) return
        let signupName = $('#name').val()
        let signupEmail = $('#email').val()
        let signupPassword = $('#password').val()
        let request = {
            fullName: signupName,
            email: signupEmail,
            password: signupPassword
        }
        $.ajax({
            url: '/api/v1/authentication/signup',
            type: 'POST',
            data: JSON.stringify(request),
            contentType: "application/json; charset=utf-8",
            success: function (data) {

                toastr.success("Signup Success");
                setTimeout(function () {
                    alert("Please check your email to active now!");
                    window.location.href = 'http://localhost:8080/login';
                }, 1000)
            },
            error: function (data) {
                toastr.warning("Email is existed!");
                setTimeout(function () {
                    window.location.reload();
                }, 700);
            },
        });
    });

    $('.container input').on('keyup', function (event) {
        if (event.key === 'Enter') {
            $("#signup").click();
        }
    });


    // Login
    $("#login-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element);
        },
        rules: {
            "email": {
                required: true,
                email: true
            },
            "password": {
                required: true,
            }
        },
        messages: {
            "email": {
                required: "Enter your email",
                email: "Incorrect email format"
            },
            "password": {
                required: "Enter your password"
            }
        }
    });

    $("#signin").click((key, value) => {
        let isValidForm = $("#login-form").valid();
        if (!isValidForm) return;
        let loginEmail = $('#email').val();
        let loginPassword = $('#password').val();
        let request = {
            email: loginEmail,
            password: loginPassword
        };
        $.ajax({
            url: '/api/v1/authentication/login',
            type: 'POST',
            data: JSON.stringify(request),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                console.log(data);
                localStorage.clear();
                localStorage.setItem('jwtToken', data.jwt);
                localStorage.setItem('refreshToken', data.refreshToken);
                let userInfomation = {
                    email: data.email,
                    userId: data.id,
                    avatar: data.avatar,
                    fullName: data.fullName,
                    role: data.roles
                };
                localStorage.setItem('userInfomation', JSON.stringify(userInfomation));

                toastr.success("Login Success");
                setTimeout(function () {
                    window.location.href = 'http://localhost:8080/'
                }, 700);
            },
            error: function (data) {
                toastr.warning("Email or Password not correct!");
            },
        });
    });


    $('#login-form input').on('keyup', function (event) {
        if (event.key === 'Enter') {
            $("#signin").click();
        }
    });

    $('.forgot-password-link').click(() => {
        $('#forgot-password-modal').modal('show');
    });

    $(".email-reset-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element);
        },
        rules: {
            "email": {
                required: true,
                email: true
            }
        },
        messages: {
            "email": {
                required: "Enter your email",
                email: "Incorrect email format"
            }
        }
    });

    $("#submit-reset-modal").click(async event => {
        let isValidForm = $(".email-reset-form").valid();
        if (!isValidForm) {
            return;
        }
        let emailReset = $(".email-reset-form #email").val();
        let request = {
            email: emailReset
        };
        await $.ajax({
            url: "/api/v1/users/otp-sending",
            type: 'POST',
            data: JSON.stringify(request),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                $('#forgot-password-modal').modal('hide');
                toastr.success("Please check your email!");
            },
            error: function () {
                toastr.warning("Email not exist or not activated!");
            }
        });
    });

    $('#forgot-password-modal input').on('keydown', function (event) {
        if (event.which === 13 || event.keyCode === 13) {
            event.preventDefault();
            $("#submit-reset-modal").click();
        }
    });


    // Sign out
    $('.sign-out').click(() => {
        let jwtToken = getJwtToken();
        if (jwtToken) {
            $.ajax({
                url: '/api/v1/authentication/logout',
                type: 'POST',
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
            });
        } else {
            toastr.warning("You are not log in")
        }
    });
})