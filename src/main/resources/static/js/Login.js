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