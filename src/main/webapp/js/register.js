$("#user_register").click(function () {
    $.ajax({
        type: 'POST',
        url: "http://127.0.0.1:8081/user/createUser",
        data: JSON.stringify({
            userLabel: $("#register_userLabel").val(),
            userPassword: $("#register_password").val(),
            telephone: $("#register_telephone").val()

        }),
        dataType: "JSON",
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            console.log(data);
            // var jsonData = JSON.parse(data);
            // if(jsonData.isSuccess == false){
            //     alert("验证用户信息失败，请重新输入用户名及密码")
            // }else {
            //     window.location.href='./view/main.html';
            // }

        },
        error: function (jqXHR) {
            return "哎呀呀，出错了" + jqXHR.status;
        }
    });
});