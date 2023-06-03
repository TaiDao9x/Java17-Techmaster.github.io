$(document).ready(() => {
    toastr.options.timeOut = 2500; // 1.5s
    setTimeout(() => {
        toastr.info('Page Loaded!');
    }, 1000);

    // get task status
    $.get("/api/v1/tasks/status", (data) => {
        const statusList = $('#task-modal #status')
        if (statusList.children().length === 0) {
            if (!data || data.length === 0) {
                toastr.error("Không có dữ liệu danh sách Status trả về!");
                return;
            }
            let statusOptions = "";
            for (let i = 0; i < data.length; i++) {
                statusOptions += `<option value=${data[i].code}>${data[i].name}</option>`
            }
            statusList.append($(statusOptions))
        }
    })

    // $.ajax({
    //     url: "/api/v1/tasks/status",
    //     type: 'GET',
    //     contentType: 'application/json;charset:urf-8',
    //     success: (data) => {
    //         const statusList = $('#task-modal #status')
    //         if (statusList.children().length === 0) {
    //             if (!data || data.length === 0) return;
    //             let statusOptions = "";
    //             for (let i = 0; i < data.length; i++) {
    //                 statusOptions += `<option value=${data[i].code}>${data[i].name}</option>`;
    //             }
    //             statusList.append($(statusOptions));
    //         }
    //
    //     }, error: (data) => {
    //         toastr.warning(data.responseJSON.error);
    //     }
    //
    // })

    $.validator.addMethod("futureDateCustom", function (value, element) {
        const now = new Date();
        const myDate = new Date(value);
        console.log(value)
        console.log(element)
        return this.optional(element) || myDate > now;
    })
    $('#task-modal-form').validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            "name": {
                required: true,
                maxlength: 255
            },
            "expectedEndTime": {
                required: true,
                date: true,
                futureDateCustom: true
            },
            "status": {
                required: true
            }
        },
        messages: {
            "name": {
                required: "Tên không được để trống",
                maxlength: "Tên không được dài quá 255 ký tự"
            },
            "expectedEndTime": {
                required: "Ngày hết hạn không được trống",
                date: "Yêu cầu nhập đúng định dạng",
                futureDateCustom: "Ngày hết hạn phải ở tương lai"
            },
            "status": {
                required: "Status không được để trống"
            }
        }
    })


// open modal to create a task
    $(".btn-create-task").click((event) => {
        console.log(event)
        const taskStatus = $(event.currentTarget).attr("task-status")
        console.log(taskStatus)

        $('#task-modal #status').val(taskStatus)

        $('#task-modal #save-task').attr("action-type", "Create")

        $("#task-modal").modal("show")
    })

// open modal to update a task
    $('.task-title').click(async event => {
        const taskId = $(event.currentTarget).attr('task-id')
        console.log(taskId)
        let task = null;
        await $.get(`/api/v1/tasks/${taskId}`, (data) => {
            task = data;
            console.log(task);
        })
        // if (!task) {
        //     toastr.error("Có lỗi, vui lòng thử lại!")
        // }
        //
        $('#task-modal-form #name').val(task.name)
        $('#task-modal-form #status').val(task.status)
        $('#task-modal-form #expectedEndTime').val(task.expectedEndTime)
        $('#task-modal-form #description').val(task.description)

        $('#task-modal #save-task').attr("action-type", "Update")
        $('#task-modal #save-task').attr("task-id", taskId)

        $('#task-modal').modal('show');

    })

// close modal -> clear form + reset form, delete action-type attribute at submit button

// create or update a task
    $('#save-task').click(event => {
        let isConfirm = $('#task-modal-form').valid();
        if (!isConfirm) return;

        const formData = $('#task-modal-form').serializeArray()
        console.log(formData)
        const requestData = {}
        for (let i = 0; i < formData.length; i++) {
            requestData[formData[i].name] = formData[i].value;
        }

        const actionType = $('#task-modal #save-task').attr("action-type")
        const taskId = $('#task-modal #save-task').attr("task-id")

        if (actionType === "Create") {
            $.ajax({
                    url: '/api/v1/tasks',
                    type: 'POST',
                    data: JSON.stringify(requestData),
                    contentType: 'application/json; charset=urf-8',
                    success: function () {
                        toastr.success("Create Successfully!")
                        $(event.currentTarget).attr("action-type", "");
                        $('#task-modal').modal('hide');
                        setTimeout(() => {
                            location.reload();
                        }, 500);
                    },
                    error: function (data) {
                        toastr.warning(data.responseJSON.error);
                    }
                }
            )
        } else {
            $.ajax({
                url: `/api/v1/tasks/${taskId}`,
                type: 'PUT',
                data: JSON.stringify(requestData),
                contentType: 'application/json; charset=urf-8',
                success: function () {
                    toastr.success("Update Successfully!")
                    $(event.currentTarget).attr("action-type", "");
                    $('#task-modal').modal('hide');
                    setTimeout(() => {
                        location.reload();
                    }, 500);
                },
                error: function (data) {
                    toastr.warning(data.responseJSON.error);
                }
            })
        }

        $("#task-modal #save-task").attr("action-type", "");
        $("#task-modal #save-task").attr("task-id", "");
        $('#task-modal-form').trigger("reset");

    })

// open delete confirmation modal


// do delete task


})




