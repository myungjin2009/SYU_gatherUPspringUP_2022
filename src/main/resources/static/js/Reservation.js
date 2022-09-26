function addReservation(requestObject) {



}

function reserve(){
    const requestUrl = '/building/reservationCheck';

//                  <input id="buildingId" name="buildingId" style="display:none" th:value="${buildingId}">
//                 <input id="time" name="time" style="display:none" th:value="${num}">
//                 <input id="classRoom" name="classRoom" style="display:none" th:value="${m.name}">

    let requestObject = {};
    requestObject.buildingId = $('#buildingId').val();
    requestObject.start_time = $('#time').val(); //10:00
    requestObject.classRoom = $('#classRoom').val();
    alert(JSON.stringify(requestObject));

    $.ajax({
        type: 'post',
        url: requestUrl,
        contentType : 'application/json',
        date: JSON.stringify(requestObject),
        async: false,
        success: function (result){

            addReservation(requestObject);
        },error: function (error){
            alert(error.responseText);
        }

    })

}