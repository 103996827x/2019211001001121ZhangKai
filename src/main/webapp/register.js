let tips = document.querySelector("#tip");
let password = document.querySelector("#password");
console.log(password.value.length);
password.onkeyup=function(){
    if(password.value.length>8) {
        tips.innerHTML = "password is ok";
    }else{
        tips.innerHTML = "length must be at least 8 characters"
    }
}
var radioArr = document.getElementsByName("selfValidateType");
for (var i = 0; i < radioArr.length; i++) {
    if (radioArr[i].value ) {
        radioArr[i].checked = "checked";
    } else {
        radioArr[i].checked = "";
    }
}





