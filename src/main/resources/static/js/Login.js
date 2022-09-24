let id = document.querySelector('#id')
let pw = document.querySelector('#pw')
let btn = document.querySelector('#btn')

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

function sendMail() {
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
    registerForm.passwordConfirm = passwordConfirm;
    registerForm.memberName = memberName;
    registerForm.nickname = nickname;

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