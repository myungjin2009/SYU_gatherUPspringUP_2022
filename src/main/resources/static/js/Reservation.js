function requestReserve(requestObject) {
    const requestUrl = "/building/reservation";

    $.ajax({
        type: 'post',
        url: requestUrl,
        contentType: 'application/json',
        data: JSON.stringify(requestObject),
        async: false,
        success: function (result) {
            alert(result);
            window.location.replace(`/buildings/${result}`);
        }, error: function (error) {
            alert(error.responseText);
        }
    })
}

function reserve(buildingId, start_time, classRoom) {
    const requestUrl = '/building/reservationCheck';

    let requestObject = {};
    requestObject.buildingId = buildingId;
    requestObject.start_time = start_time;
    requestObject.classRoom = classRoom;
    alert(JSON.stringify(requestObject));

    $.ajax({
        type: 'post',
        url: requestUrl,
        contentType: 'application/json;',
        data: JSON.stringify(requestObject),
        async: false,
        success: function (result) {
            requestReserve(requestObject);
        }, error: function (error) {
            alert(error.responseText);
        }

    })

}