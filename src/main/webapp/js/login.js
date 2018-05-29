 $("#user_loginIn").click(function () {
        $.ajax({
            type: 'POST',
            url: "http://127.0.0.1:8081/user/inValidUser",
            data: JSON.stringify({
                userLabel: $("#user_input_userLabel").val(),
                userPassword: $("#user_input_password").val()
            }),
            dataType: "JSON",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                if(data.isSuccess == false){
                    alert("验证用户信息失败，请重新输入用户名及密码")
                }else {
                    window.location.href='./view/main.html';
                }

            },
            error: function (jqXHR) {
                return "哎呀呀，出错了" + jqXHR.status;
            }
        });
    });