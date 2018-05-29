$(document).ready(function () {
    $("#testAjax").click(function () {
        $.ajax({
            type: 'POST',
            url: "http://127.0.0.1:8081/book/getBooksBySearchKey",
            data: JSON.stringify({
                userLabel: $("#user_input_userLabel").val(),
                userPassword: $("#user_input_password").val()
            }),
            dataType: "JSON",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                console.log(data)

            },
            error: function (jqXHR) {
                return "哎呀呀，出错了" + jqXHR.status;
            }
        });
    });
})