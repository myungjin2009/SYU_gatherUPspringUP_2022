

function reserveRoom() {
        $.ajax({
            type: 'post',
            url: `/board/Delete`,
            async: false,
            success: function (result){
                alert(result);
            },error: function (error){
                alert(error.responseText);
            }
        })

}