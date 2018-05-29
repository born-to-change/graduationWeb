/*$(document).ready(function () {
    $("#search").click(function () {
        $.ajax({
            type: "GET",
            url: "http://127.0.0.1:8081/book/getBooksBySearchKey/?" + $("#search_box").val(),
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    //document.getElementById("").innerHTML=data.msg;
                    $("#").html(data.msg);
                } else {
                    document.getElementById("").innerHTML = "哎呀呀，出错了" + data.msg;
                }
            },
            error: function (jqXHR) {
                alert("哎呀呀，出错了" + jqXHR.status);
            }
        });
    });

});*/
    $("#search_box").click(function(){
        $.ajax({
            type:'POST',
            url: "http://127.0.0.1:8081/book/getBooksBySearchKey",
            data:JSON.stringify({data : $("#testSearch").val()}) ,
            dataType:"JSON",
            contentType: 'application/json;charset=utf-8',
            success:function (data) {
                console.log(data)
            },
            success: function (data) {
                if (data.success) {
                    document.getElementById("content").innerHTML=data

                    //return data;
                } else {
                    //document.getElementById("").innerHTML = "哎呀呀，出错了";
                    // return "哎呀呀，出错了";
                    $("#content").html("哎呀呀，出错了");
                }
            },
            error: function (jqXHR) {
                return "哎呀呀，出错了" + jqXHR.status;
            }
        });
    });