let firebaseConfig = {
    apiKey: "AIzaSyDHL076Sw_Aru3k1TwtODbumP1uvVNP9tg",
    projectId: "fir-e9a96",
    storageBucket: "fir-e9a96.appspot.com",
};
// Khởi tạo Firebase
firebase.initializeApp(firebaseConfig);
// Lấy tham chiếu đến Firebase Storage bucket
let storage = firebase.storage();
let storageRef = storage.ref();

$(document).ready(function () {

    //open chosen image form
    $('#change-avatar').click(() => {
        $('#fileInput').click()
    })

    // show image
    let chosenFile = null;
    $('#fileInput').change(event => {
        const tempFiles = event.target.files;
        const maxSizeInBytes = 5242880;
        if (!tempFiles || tempFiles.length === 0) {
            return;
        }
        chosenFile = tempFiles[0];
        if (chosenFile && chosenFile.size > maxSizeInBytes) {
            alert("File size exceeded the allowed limit (5MB)!");
            this.value = '';
            return;
        }
        const imageBlob = new Blob([chosenFile], {type: chosenFile.type});
        const imageUrl = URL.createObjectURL(imageBlob);
        // $('#show-avatar').empty();
        let showImageHtml = `<img src="${imageUrl}" alt="image" class="img-ratio rounded-4">`
        $('#show-avatar').html(showImageHtml)
    });

    $.validator.addMethod("pastDate", function (value, element) {
        let currentDate = new Date();
        let inputDate = new Date(value);
        return inputDate < currentDate;
    }, "date must be the past date");

    $.validator.addMethod("phoneWithZeroPrefix", function (value, element) {
        return this.optional(element) || /^0\d{9}$/.test(value);
    }, "Please enter a valid 10-digit phone number starting with 0.");

// Edit user
    $("#edit-profile-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            error.addClass("error-message");
            error.insertAfter(element);
        },
        rules: {
            "fullName": {
                maxlength: 255
            },
            "about": {
                maxlength: 65535
            },
            "dob": {
                pastDate: true
            },
            "phone": {
                phoneWithZeroPrefix: true
            }
        },
        messages: {
            "fullName": {
                maxlength: "Cannot be longer than 255 characters"
            },
            "about": {
                maxlength: "Cannot be longer than 65535 characters"
            },
            "dob": {
                pastDate: "* Date of birth must be the past date"
            },
            "phone": {
                phoneWithZeroPrefix: "Phone number incorrect"
            }
        },
        invalidHandler: function (form, validator) {
            let errors = validator.numberOfInvalids();
            if (errors) {
                let firstErrorElement = $(validator.errorList[0].element);
                $('html, body').animate({
                    scrollTop: firstErrorElement.offset().top - 200
                }, 500);
                firstErrorElement.focus();
            }
        }
    });

    $('#edit-profile-form input', '#edit-profile-form textarea').on('keyup', function (event) {
        if (event.key === 'Enter') {
            $('#submit-edit-personal-btn').click();
        }
    })

    $('#submit-edit-personal-btn').click(event => {
        let userId = userResponse.id;
        let isValidForm = $("#edit-profile-form").valid();
        if (!isValidForm) return;
        $('#submit-edit-personal-btn').prop('disabled', true);
        uploadImageAndUpdateUser(userId);
    })

    async function uploadImageAndUpdateUser(userId) {
        let fullName = $('#fullName').val();
        let phone = $('#phone').val();
        let dob = $('#dob').val();
        let about = $('#about').val();
        let gender = $('#gender').val();

        let editUser = {
            avatar: "",
            fullName: fullName,
            phone: phone,
            dob: dob,
            about: about,
            gender: gender,
            email: ''
        };

        if (chosenFile != null) {
            editUser.avatar = await uploadImage(chosenFile)
            updateUser(editUser);
        } else {
            updateUser(editUser);
        }
    }

    async function uploadImage(chosenFile) {
        try {
            let imageName = chosenFile.name;
            let imageRef = storageRef.child("images/" + imageName);
            let snapshort = await imageRef.put(chosenFile);
            return await snapshort.ref.getDownloadURL();
        } catch (error) {
            throw error;
        }
    }

    function updateUser(editUser) {
        $.ajax({
            url: '/api/v1/admin/profile',
            type: 'PUT',
            contentType: "application/json",
            data: JSON.stringify(editUser),
            success: function () {
                toastr.success("Update profile successfully!");
                window.scrollTo(0, 0);
                setTimeout(function () {
                    $('#submit-edit-personal-btn').prop('disabled', false);
                    saveNewInformation(editUser);
                    window.location.reload();
                }, 700)
            },
            error: function () {
                toastr.warning("Update profile not successfully!");
                $('#submit-edit-personal-btn').prop('disabled', false);
            }
        })
    }
})

function saveNewInformation(newInfo) {
    let userInfomation = JSON.parse(localStorage.getItem("userInfomation"))
    let userData = {
        "email": newInfo.email === '' ? userInfomation.email : newInfo.email,
        "userId": userInfomation.userId,
        "avatar": newInfo.avatar === '' ? userInfomation.avatar : newInfo.avatar,
        "fullName": newInfo.fullName === '' ? userInfomation.fullName : newInfo.fullName,
        "role": userInfomation.role
    };
    localStorage.setItem('userInfomation', JSON.stringify(userData))
}

