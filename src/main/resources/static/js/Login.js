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

function sendMail(){
    const email = $('#email').val();
    alert("test");
    const requestUrl = "/sendAuthNumber";


    $.ajax({
        type: 'post',
        url : requestUrl,
        data: `email=${email}`,
        success: function(result){
            console.log(result);
        },
        error: function (error){
            console.log(error);
        }
    })
}