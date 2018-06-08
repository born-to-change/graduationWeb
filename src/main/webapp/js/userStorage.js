function saveUserId(userId) {
    localStorage.setItem("currentUserId",userId);
}

function saveUserName(userName) {
    localStorage.setItem("currentUserName",userName);
}

function getUserId() {
    return localStorage.getItem("currentUserId");


}
function getUserName() {

   return localStorage.getItem("currentUserName");


}
