$.ajaxSetup({
    beforeSend: function (xhr) {
        let jwtToken = getJwtToken();
        // xhr.setRequestHeader("Accept", "application/vvv.website+json;version=1");
        xhr.setRequestHeader("Authorization", "Bearer " + jwtToken);
    }
});

