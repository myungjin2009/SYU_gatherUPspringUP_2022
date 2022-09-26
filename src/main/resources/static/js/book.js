function hideBook() {
    $('#bookTr').hide();

    let text = "<tr><p>예약 현황이 없습니다.</p></tr>"
    $('.settings__table').append(text);
}

function bookCancel(bookId){

    $.ajax({
        type: 'delete',
        url: `/book/${bookId}/cancel`,
        async: false,
        success: function (result){
            alert(result);
            hideBook();
        },error: function (error){
            alert(error.responseText);
        }
    })

}