document.write("<script type='text/javascript' src='../../js/axios-0.18.0.js'></script>");

function exit(){
    console.log("执行exit")
    //发送请求
    axios({
        method:"get",
        url:"http://localhost:8080/PetAMSystem/admin/exit"
    }).then(function (resp){
        alert("退出成功");
        location.href = "http://localhost:8080/PetAMSystem/static/html/admin/login.html";
    })
}