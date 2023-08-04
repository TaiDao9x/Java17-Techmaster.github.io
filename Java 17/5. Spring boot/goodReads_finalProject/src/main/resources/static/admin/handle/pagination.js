$(document).ready(function () {


    $('#pageInput').select2({});
    $('#pageNumberInput').select2({});

    $('#add-book').click(() => {
        window.location.href = '/admin/add-book'
    })

    const title = urlParam.get('title')

    $('.search-admin').val(title)

    $('.search-admin').on('keyup', function (event) {
        if (event.key === 'Enter') {
            $('#btn-search-admin').click();
        }
    })

    $('#btn-search-admin').click(() => {
        changeUrl(1, pageSize);
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
            window.location.href = `/admin/books?pageIndex=${pageNumber}&pageSize=${pageSize}&title=${keyword}`;
        } else {
            window.location.href = `/admin/books?pageIndex=${pageNumber}&pageSize=${pageSize}`;
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



