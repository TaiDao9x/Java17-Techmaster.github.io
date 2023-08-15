const pageSize = 8;
const urlParam = new URLSearchParams(window.location.search);
const showPageSize = urlParam.get('pageSize') || pageSize;
const lastSearchCriteria = urlParam.get('title') || '';
$('#search-input').val(lastSearchCriteria);
$('#show-pagesize').val(showPageSize);

$(document).ready(function () {

    // $('#pageInput').select2({});
    // $('#pageNumberInput').select2({});


    let searchFrom = getPreviousSearchCriteria();

    $('#search-input').on('keyup', function (event) {
        if (event.key === 'Enter') {
            $('#search-btn').click();
        }
    })

    $('#search-btn').click(() => {
        changeUrl(1, showPageSize);
    })

    $('#pageInput').change(() => {
        let pageNumber = $('#pageInput').val();
        changeUrl(pageNumber, showPageSize);
    })

    $('.chose-page').click(event => {
        let pageIndex = $(event.currentTarget).attr('page-number');
        changeUrl(pageIndex, showPageSize);
    })

    $('.previous-link').click(() => {
        const pageIndex = urlParam.get('pageIndex')
        changeUrl(pageIndex - 1, showPageSize);
    })

    $('.next-link').click(() => {
        const pageIndex = parseInt(urlParam.get('pageIndex')) || 1
        changeUrl(pageIndex + 1, showPageSize);
    })

    $('#show-pagesize').change((event) => {
        let chosenPageSize = event.target.value;
        changeUrl(1, chosenPageSize)
    })

    function checkSearchInput() {
        let searchKeyword = $('#search-input').val();
        return searchKeyword.trim();
    }

    function changeUrl(pageNumber, pageSize) {
        let keyword = checkSearchInput();
        if (keyword !== '') {
            window.location.href = `/books?pageIndex=${pageNumber}&pageSize=${pageSize}&title=${keyword}`;
        } else {
            window.location.href = `/books?pageIndex=${pageNumber}&pageSize=${pageSize}`;
        }
    }

    function getPreviousSearchCriteria() {
        const name = urlParam.get('name')
        const email = urlParam.get('email')

        const currentUrl = window.location.href;
        const adminIndex = currentUrl.indexOf("/admin/");
        const paramIndex = currentUrl.indexOf("?");

        let searchFrom;
        if (paramIndex !== -1) {
            searchFrom = currentUrl.substring(adminIndex + ("/admin/".length), paramIndex);
        } else {
            searchFrom = currentUrl.substring(adminIndex + ("/admin/".length), currentUrl.length);
        }

        if (searchFrom === 'books') {
            $('.search-admin').val(checkParamsAndCheckBoxesAndGetSearchBook());
        } else if (searchFrom === 'categories') {
            $('.search-admin').val(name);
        } else if (searchFrom === 'users') {
            $('.search-admin').val(email);
        }
        return searchFrom;
    }

    function checkParamsAndCheckBoxesAndGetSearchBook() {
        let searchBook;
        const paramToCheck = ['title', 'author', 'category', 'all'];
        paramToCheck.forEach(function (param) {
            if (urlParam.has(param)) {
                const checkboxId = `#checkbox${param.charAt(0).toUpperCase() + param.slice(1)}`;
                $(checkboxId).prop('checked', true);
            }
            if (urlParam.get(param) !== null) {
                searchBook = urlParam.get(param);
            }
        })
        return searchBook;
    }
})
