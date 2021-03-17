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
// let radios=document.querySelector(".gender");
// let male=document.getElementsByName("male");
// let female=document.getElementsByName("female")
// radios.onclik=function () {
//     if (radios.value == 0) {
//         male.checked = true;
//         female.checked = false;
//     }
//     if (radios.value == 1) {
//         male.checked = false;
//         female.checked = true;
//     }
// }
var radioArr = document.getElementsByName("selfValidateType");
for (var i = 0; i < radioArr.length; i++) {
    if (radioArr[i].value ) {
        // radioArr[i].setAttribute("checked"); 错误的
        radioArr[i].checked = "checked";
    } else {
        //radioArr[i].removeAttribute("checked"); 错误的
        radioArr[i].checked = "";
    }
}





