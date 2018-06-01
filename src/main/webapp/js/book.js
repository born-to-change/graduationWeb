//
// var bookInfo_img_str = $("#bookInfo_img").val() + item.bookImage;
// $("#bookInfo_price").val(bookInfo_img_str);
//
// var bookInfo_description_str = $("#bookInfo_description").val() + item.bookDescription;
// $("#bookInfo_description").val(bookInfo_description_str)
// $.ajax({
//     type: 'POST',
//     url: "http://127.0.0.1:8081/book/getBookByBookId",
//     data: JSON.stringify({data: item.bookId}),
//     dataType: "JSON",
//     contentType: 'application/json;charset=utf-8',
//     success: function (data) {
//         console.log(data);
//         console.log("index=" + index);
//
//
//     },
//     error: function (jqXHR) {
//         return "哎呀呀，出错了" + jqXHR.status;
//     }
// });