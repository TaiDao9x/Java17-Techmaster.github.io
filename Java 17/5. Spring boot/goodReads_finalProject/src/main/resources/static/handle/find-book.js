$(document).ready(function () {
    // find book user
    $('.icon-magnifier').click(() => {
        let keyWord = $('.typeahead').val();
        let requestParam = '?' + keyWord;

        window.location.href = 'http://localhost:8080/users/books' + requestParam;
    });

});