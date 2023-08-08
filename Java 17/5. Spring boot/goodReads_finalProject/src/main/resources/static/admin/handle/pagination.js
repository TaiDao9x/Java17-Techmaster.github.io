$(document).ready(function () {


    $('#pageInput').select2({});
    $('#pageNumberInput').select2({});


    const currentUrl = window.location.href;
    const title = urlParam.get('title')
    const name = urlParam.get('name')
    const email = urlParam.get('email')

    const adminIndex = currentUrl.indexOf("/admin/");
    const paramIndex = currentUrl.indexOf("?");
    let searchBy;
    if (paramIndex !== -1) {
        searchBy = currentUrl.substring(adminIndex + ("/admin/".length), paramIndex);
    } else {
        searchBy = currentUrl.substring(adminIndex + ("/admin/".length), currentUrl.length);
    }

    if (searchBy === 'books') {
        $('.search-admin').val(title);
    } else if (searchBy === 'categories') {
        $('.search-admin').val(name);
    } else if (searchBy === 'users') {
        $('.search-admin').val(email);
    }

    $('.search-admin').on('keyup', function (event) {
        if (event.key === 'Enter') {
            $('#btn-search-admin').click();
        }
    })

    $('#btn-search-admin').click(() => {
        changeUrl(1, pageSize);
    })

    $('#add-book').click(() => {
        window.location.href = '/admin/add-book'
    })

    $('#pageInput').change(() => {
        let pageNumber = $('#pageInput').val();
        changeUrl(pageNumber, pageSize);
    })

    $('.chose-page').click(event => {
        let pageIndex = $(event.currentTarget).attr('page-number');
        changeUrl(pageIndex, pageSize);
    })

    $('.previous-link').click(() => {
        const pageIndex = urlParam.get('pageIndex')
        changeUrl(pageIndex - 1, pageSize);
    })

    $('.next-link').click(() => {
        const pageIndex = parseInt(urlParam.get('pageIndex')) || 1
        changeUrl(pageIndex + 1, pageSize);
    })

    function changeUrl(pageNumber, pageSize) {
        let keyword = checkSearchInput();
        if (keyword !== '') {
            if (searchBy === 'books') {
                window.location.href = `/admin/${searchBy}?pageIndex=${pageNumber}&pageSize=${pageSize}&title=${keyword}`;
            } else if (searchBy === 'categories') {
                window.location.href = `/admin/${searchBy}?pageIndex=${pageNumber}&pageSize=${pageSize}&name=${keyword}`;
            } else if (searchBy === 'users') {
                window.location.href = `/admin/${searchBy}?pageIndex=${pageNumber}&pageSize=${pageSize}&email=${keyword}`;
            }
        } else {
            window.location.href = `/admin/${searchBy}?pageIndex=${pageNumber}&pageSize=${pageSize}`;
        }
    }

    function checkSearchInput() {
        let searchKeyword = $('.search-admin').val();
        return searchKeyword.trim();
    }

    $('#pageNumberInput').change((event) => {
        let chosenPageSize = event.target.value;
        changeUrl(1, chosenPageSize)
    })
})





