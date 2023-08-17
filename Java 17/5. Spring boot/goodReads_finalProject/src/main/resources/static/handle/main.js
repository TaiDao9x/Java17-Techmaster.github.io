$(document).ready(function () {
    $('#reading-book-status .dropdown-item').on('click', function (event) {
        console.log("click")
        event.preventDefault();
        let bookId = $(this).attr('book-id')
        let readingStatus = $(this).data('value')

        let formData = {
            "bookId": bookId,
            "readingStatus": readingStatus
        }
        $.ajax({
            url: '/api/v1/users/book-reading',
            type: 'POST',
            data: JSON.stringify(formData),
            contentType: 'application/json',
            success: function (data) {
                if (isLoginPage(data)) {
                    window.location.href = '/login';
                } else {
                    window.location.reload();
                }
            },
            error: function () {
                toastr.warning('Not success!')
            }
        })
    })

    function isLoginPage(data) {
        return $(data).find('.signin-form').length > 0;
    }
})