$(document).ready(function () {

    let eventLog = function (ctx, e) {
        let html = [
            "name: " + ctx.get("name"),
            "event.type: " + e.type
        ];
        $(".events-plate").html(html.join("<br />"));
    };

    // $.prototype.mSelectDBox.prototype._globalStyles[".m-select-d-box__list-item_selected"]["background-color"] = "mediumseagreen";
    // $.prototype.mSelectDBox.prototype._globalStyles[".m-select-d-box__list-item_selected:hover, .m-select-d-box__list-item_selected.m-select-d-box__list-item_hover"]["background-color"] = "green";
    // $.prototype.mSelectDBox.prototype._globalStyles[".m-select-d-box__list-item:active, .m-select-d-box__list-item_selected:active"]["background-color"] = "darkgreen";

    let greeceAlphabet = [
        "alpha", "beta", "gamma", "delta",
        "epsilon", "zeta", "eta", "theta", "iota",
    ];

    let msdba2 = $("#msdb-a-2").mSelectDBox({
        "list": greeceAlphabet,
        "multiple": true,
        "autoComplete": true,
        "input:empty": eventLog,
        "onselect": eventLog,
        "name": "a2"
    });

    // function _onChange(_this) {
    //     let list = _this.get("list");
    //     let selectedItems = _this.getSelectedItems();
    //
    //     // if (selectedItems.length >= 3) {
    //     // 	list.forEach(function (item) {
    //     // 		if (!item.selected) {
    //     // 			_this.disableItem(item);
    //     // 		}
    //     // 	});
    //     //
    //     // } else {
    //     // 	list.forEach(function (item) {
    //     // 		_this.enableItem(item);
    //     // 	});
    //     // }
    // }
    //
    // msdba2.on("select", _onChange);

    let pageNumber = $('#msdb-a').attr('pageNumber')
    console.log(pageNumber)
    $("#msdb-a").mSelectDBox({
        "list": (function () {
            let arr = [];
            for (let c = 1; c <= pageNumber; c++) {
                arr.push(c);
            }
            return arr;
        })(),
        "multiple": false,
        "autoComplete": true,
        "input:empty": eventLog,
        "onselect": function () {
            goToPage();
        },
        "name": "a"
    });

    $('#msdb-a').on('keyup', function (event) {
        if (event.key === 'Enter') {
            goToPage();
        }
    });

    function goToPage() {
        let pageIndex = $('#msdb-a').val();

        if (pageIndex >= 1 && pageIndex <= pageNumber) {
            window.location.href = '/admin/books?pageIndex=' + pageIndex;
        } else {
            alert('Trang không hợp lệ!');
        }
    }

});