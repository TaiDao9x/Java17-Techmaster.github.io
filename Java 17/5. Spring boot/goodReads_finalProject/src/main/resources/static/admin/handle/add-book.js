// Cấu hình thông tin Firebase của bạn
let firebaseConfig = {
    apiKey: "AIzaSyDHL076Sw_Aru3k1TwtODbumP1uvVNP9tg",
    projectId: "fir-e9a96",
    storageBucket: "fir-e9a96.appspot.com",
};

// let firebaseConfig = {
//     apiKey: "AIzaSyDZwCuyQHeig-aRWvDVPrxbDOArhB4Lx1A",
//     authDomain: "final-project-&#45;&#45;goodreads.firebaseapp.com",
//     projectId: "final-project-&#45;&#45;goodreads",
//     storageBucket: "final-project-&#45;&#45;goodreads.appspot.com",
//     messagingSenderId: "438803212569",
//     appId: "1:438803212569:web:41304f80b268288b977d88",
//     measurementId: "G-RV3X1H3MLM"
// }

// Khởi tạo Firebase
firebase.initializeApp(firebaseConfig);

// Lấy tham chiếu đến Firebase Storage bucket
let storage = firebase.storage();
let storageRef = storage.ref();

$(document).ready(function () {

    // Tìm kiếm category
    $("#search-category").keyup(function () {
        let searchText = $(this).val().toLowerCase();
        $(".show-genres").each(function () {
            let categoryText = $(this).find(".text-15").text().toLowerCase();
            if (categoryText.includes(searchText)) {
                $(this).show();
            } else {
                $(this).hide();
            }
        });
    });

    //open chosen image form
    $('.btn-upload-image').click(() => {
        $('#fileInput').click();
    });

    // show image
    let chosenFile = null;
    $('#fileInput').change(event => {
        const maxSizeInBytes = 5242880;
        const tempFiles = event.target.files;
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
        $('#image-book .btn-upload-image').empty();
        let showImageHtml = `<img alt='Avatar' style="width: auto; height: 100%; object-fit: cover" src='${imageUrl}'/>`;
        $('#image-book .btn-upload-image').append(showImageHtml)
    });


    function uploadImageAndCreateBook() {
        let title = $("#title").val();
        let author = $("#author").val();
        let published = $("#published").val();
        let about = $("#about").val();

        let categories = $('#book-category').val();
        let categoryConvert = categories.map(c => String(c));

        // Create the Book object (newBook) based on the CreateBookRequest structure
        let newBook = {
            image: "",
            title: title,
            categoryId: categoryConvert,
            author: author,
            description: about,
            published: published,
        };

        // Upload the image first
        if (chosenFile != null) {
            let imageName = chosenFile.name;

            // Tạo tham chiếu đến file trên Firebase Storage
            let imageRef = storageRef.child("images/" + imageName);

            // Tải lên ảnh lên Firebase Storage
            let uploadTask = imageRef.put(chosenFile);

            return uploadTask.then(snapshot => {
                // Lấy URL download của ảnh
                return snapshot.ref.getDownloadURL();
            }).then(downloadURL => {
                // Sau khi lấy URL, gán vào newBook.image
                newBook.image = downloadURL;

                console.log(newBook)
                // Gửi yêu cầu POST để tạo sách với URL ảnh đã tải lên
                return $.ajax({
                    type: "POST",
                    url: "/api/v1/admin/book",
                    contentType: "application/json",
                    data: JSON.stringify(newBook),
                });
            }).then(response => {
                toastr.success("Create book success!");
                window.location.reload();
            }).catch(error => {
                toastr.warning("Create book not success!");
            });
        } else {
            // Create the book without the image URL
            $.ajax({
                type: "POST",
                url: "/api/v1/admin/book",
                contentType: "application/json",
                data: JSON.stringify(newBook),
                success: function (response) {
                    toastr.success("Create book success!");
                    $('#submitBtn').prop('disabled', false);
                    window.location.reload();
                },
                error: function (error) {
                    toastr.warning("Create book not success!");
                }
            });
        }

    }

    $.validator.addMethod("pastDate", function (value, element) {
        // Lấy ngày hiện tại
        let currentDate = new Date();

        // Chuyển đổi giá trị ngày nhập vào sang đối tượng Date
        let inputDate = new Date(value);

        // So sánh ngày nhập vào với ngày hiện tại
        return inputDate < currentDate;
    }, "date must be the past date");

    $("#create-book-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        errorPlacement: function (error, element) {
            if (element.attr("name") === "category") {
                error.addClass("error-message");
                error.appendTo("#category-error");
            } else {
                error.addClass("error-message");
                error.insertAfter(element);
            }
        },
        rules: {
            "title": {
                required: true,
                maxlength: 255
            },
            "author": {
                required: true,
                maxlength: 255
            },
            "category": {
                required: true
            },
            "about": {
                maxlength: 65535
            },
            "published": {
                required: true,
                pastDate: true
            }
        },
        messages: {
            "title": {
                required: "* Enter title",
                maxlength: "Cannot be longer than 255 characters"
            },
            "author": {
                required: "* Enter author",
                maxlength: "Cannot be longer than 255 characters"
            },
            "category": {
                required: "* Select category",
            },
            "about": {
                maxlength: "Cannot be longer than 65535 characters"
            },
            "published": {
                required: "* Enter published date",
                pastDate: "* Published date must be the past date"
            }
        },
        invalidHandler: function (form, validator) {
            // Tìm trường đầu tiên có lỗi
            let errors = validator.numberOfInvalids();
            if (errors) {
                let firstErrorElement = $(validator.errorList[0].element);
                // Cuộn trình duyệt đến trường đầu tiên có lỗi
                $('html, body').animate({
                    scrollTop: firstErrorElement.offset().top - 200 // Điều chỉnh vị trí cuộn để hiển thị tooltip không bị che khuất
                }, 500);
                firstErrorElement.focus(); // Đưa con trỏ vào trường đầu tiên có lỗi
            }
        }
    });

// Call the uploadImageAndCreateBook function when a form submit button is clicked
    $('#submitBtn').click(event => {
        console.log("click");
        event.preventDefault();
        let isValidForm = $("#create-book-form").valid();
        if (!isValidForm) return;
        $('#submitBtn').prop('disabled', true);
        uploadImageAndCreateBook();
    })

// $('.custom_shadow').on('keyup', function (event) {
//     if (event.which === 13 || event.keyCode === 13) {
//         event.preventDefault();
//         $('#submitBtn').click();
//     }
// })

})