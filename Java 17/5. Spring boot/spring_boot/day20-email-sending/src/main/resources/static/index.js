$(document).ready(function () {

    let chosenFile = null;

    $(".attachment-btn").click(() => {
        $("#attachment-input").click()
    })

    $("#attachment-input").change((event) => {
        const tempFile = event.currentTarget.files
        if (!tempFile || tempFile.length === 0) return
        chosenFile = tempFile[0];
        console.log(chosenFile)
    })

    $(".send-mail").click(() => {
        const email = $("#email").val().trim()

        if (!email || email.length === 0) {
            toastr.warning("Chưa nhập email");
            return
        }
        if (!chosenFile) {
            $.ajax({
                url: `/api/v1/users/${email}/otp-sending`,
                type: "POST",
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    console.log(data);
                    toastr.success(data);
                },
                error: function (errorData) {
                    console.log(errorData);
                    toastr.error(errorData);
                }
            })
        } else {

            const requestData = {
                "recipient": `${email}`,
                "attachment": `${chosenFile.name}`
            }
            console.log(requestData)
            $.ajax({
                url: "/api/v1/users/attach-file",
                type: "POST",
                data: JSON.stringify(requestData),
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    toastr.success(data);
                },
                error: function (errorData) {
                    console.log(errorData);
                    toastr.error(errorData);
                }
            })
        }


    })
})