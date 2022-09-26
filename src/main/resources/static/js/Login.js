let id = document.querySelector('#id')
let pw = document.querySelector('#pw')
let btn = document.querySelector('#btn')
let positionSelector = "frontEnd";

// btn.addEventListener('click', () => {
//     if (id.value == "") {
//         label = id.nextElementSibling
//         label.classList.add('warning')
//         setTimeout(() => {
//             label.classList.remove('warning')
//         }, 1500)
//     } else if (pw.value == "") {
//         label = pw.nextElementSibling
//         label.classList.add('warning')
//         setTimeout(() => {
//             label.classList.remove('warning')
//         }, 1500)
//     }
// })

function frontClick() {
    positionSelector = "frontEnd";
}

function backClick() {
    positionSelector = "backEnd";
}

function designerClick() {
    positionSelector = "designer";
}

function sendMail() {
    const emailSend_btn = document.getElementById('emailSendBtn');
    emailSend_btn.disabled = true;
    const emailInput = document.getElementById('email');
    emailInput.disabled = true;


    const email = $('#email').val();

    const requestUrl = "/sendAuthNumber";

    $.ajax({
        type: 'post',
        url: requestUrl,
        data: `email=${email}`,
        success: function (result) {
            console.log(result);
        },
        error: function (error) {
            console.log(error);
        }
    })
    alert("인증번호가 발송되었습니다.");
}

function verifyMail() {

    const email = $('#email').val();
    const number= $('#authNumber').val();
    const requestUrl = "/verifyAuthNumber";

    $.ajax({
        type: 'post',
        url: requestUrl,
        data: `email=${email}&authNumber=${number}`,
        success: function (result) {
            const verify_btn = document.getElementById('verifyBtn');
            verify_btn.disabled = true;
            const authInput = document.getElementById('authNumber');
            authInput.disabled = true;
            alert("인증번호가 일치합니다!");
        },
        error: function (error) {
            alert(error.responseText);
        }
    })



//    const target = document.getElementById('email');
//    target.disabled = true;
}

function login() {
    const id = $('#id').val();
    const pw = $('#pw').val();

    let principal = new Object();
    principal.id = id;
    principal.pw = pw;

    $.ajax({
        type: 'post',
        url: '/login',
        contentType: "application/json; charset=UTF-8",
        data: JSON.stringify(principal),
        success: function (result) {
            window.location.replace("/");
        },error: function (error){
            alert(error.responseText);
        }
    })
}

function register(){

    const email = $('#email').val();
    const password = $('#password').val();
    const passwordConfirm = $('#passwordConfirm').val();
    const memberName = $('#memberName').val();
    const nickname = $('#nickname').val();
    const position = positionSelector;

    //TODO 학년 필드 추가 후 값 받아오기
    if(!email || !password || !memberName || !nickname){
        alert("모든 항목을 기입해주세요.");
        return;
    }

    if(password !== passwordConfirm){
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }

    let registerForm = new Object();
    registerForm.email = email;
    registerForm.password = password;
    registerForm.name = memberName;
    registerForm.nickName = nickname;
    registerForm.grade = 4;
    registerForm.position = position;

    console.log(registerForm);

    $.ajax({
        type: 'post',
        url: '/register',
        contentType: "application/json;",
        data: JSON.stringify(registerForm),
        success: function(result){
            alert(result);
            window.location.replace("/login");
        },
        error: function(error){
            alert(error.responseText);
        }
    })
}