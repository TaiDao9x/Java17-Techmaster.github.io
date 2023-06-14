$(document).ready(function () {
    toastr.options.timeOut = 2500; // 2.5s

    let chosenFile = null;
    $(".change-avatar-btn").click(() => {
        console.log("change avatar")

        $("#avatar-input").click();
    });

    $('#avatar-input').change(event => {
        console.log(event)
        const tempFile = event.currentTarget.files
        console.log(tempFile)
        if (!tempFile || tempFile.length === 0) return
        chosenFile = tempFile[0]
        console.log(chosenFile)
        const imageBlob = new Blob([chosenFile], {type: chosenFile.type})
        const imageUrl = URL.createObjectURL(imageBlob)
        console.log(imageUrl)
        $('#avatar').attr("src", imageUrl)
    })

    $('.submit-avatar-btn').click(() => {
        console.log("save avatar")
        if (!chosenFile) {
            return;
        }

        const formData = new FormData();
        formData.append('avatar', chosenFile)
        $.ajax({
            url: '/api/v1/users/avatar',
            data: formData,
            type: 'POST',
            contentType: false,
            processData: false,
            success: function (data) {
                console.log(data);
                toastr.success(data);
            },
            error: function (errorData) {
                console.log(errorData);
                toastr.error(errorData);
            }
        })
    })

})