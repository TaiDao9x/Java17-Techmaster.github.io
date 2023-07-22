$(document).ready(function () {
    $('.btn-upload-image').click(() => {
        $('#fileInput').click();
    });

    let chosenFile = null;
    $('#fileInput').change(event => {
        const tempFiles = event.target.files;
        if (!tempFiles || tempFiles.length === 0) {
            return;
        }
        chosenFile = tempFiles[0];
        const imageBlob = new Blob([chosenFile], {type: chosenFile.type});
        const imageUrl = URL.createObjectURL(imageBlob);
        $('#image-book .btn-upload-image').empty();
        let showImageHtml = `<img alt='Avatar' style="width: auto; height: 100%; object-fit: cover" src='${imageUrl}'/>`;
        $('#image-book .btn-upload-image').append(showImageHtml)
    });
})