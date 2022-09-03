var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
        var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.643707049709526, 127.10576992074999), //지도의 중심좌표.
	level: 4 //지도의 레벨(확대, 축소 정도)
};
var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

getBuildingPositions();

function getBuildingPositions(){

    $.ajax({
      type: 'get',
      url: '/buildings',
      dataType: 'json',
      async:'false',
      success: function(result){
        setMarker(result.buildingDtoList);
        console.log(result);
      },
      error: function(error){
      console.log(error);
      }
    });
}

function setMarker(arrays){
    // 마커가 표시될 위치입니다
    for(let i =0;i<arrays.length;i++){
        let markerPosition  = new kakao.maps.LatLng(arrays[i].latitude, arrays[i].longitude);
    // 마커를 생성합니다
        let marker = new kakao.maps.Marker({
            position: markerPosition
        });

        marker.setMap(map);    // 마커가 지도 위에 표시되도록 설정합니다
        addOverlay(marker,arrays[i]);
    }
}


function addOverlay(marker,data){
       let overlay = new kakao.maps.CustomOverlay({
            map: map,
            position: marker.getPosition()
        });

        let content = makeContent(data.name,data.intro,data.id,overlay);
        //overlay.setContent(content);

        kakao.maps.event.addListener(marker, 'click', function() {
            overlay.setContent(content);
            overlay.setMap(map);
        });
}

// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
function closeOverlay(overlay) {
     overlay.setMap(null);
}
function makeContent(name,intro,bid,overlay){
//이름, 소개, URL
      var wrap = document.createElement('div');
      wrap.classList.add("wrap");

      var info = document.createElement('div');
      info.classList.add('info');

      var title = document.createElement('div');
      title.classList.add('title');
      title.innerText = name;

      var close = document.createElement('div');
      close.classList.add('close');
      close.addEventListener('click',function(){
        overlay.setMap(null);
      });

      var body = document.createElement('div');
      body.classList.add('body');

      var desc = document.createElement('div');
      desc.classList.add('desc');

      var ellipsis = document.createElement('div');
      ellipsis.classList.add('ellipsis')
      ellipsis.innerText = intro;

      var urlDiv = document.createElement('div');
      var url = document.createElement('a');
      url.innerText = "강의실 현황"
      url.setAttribute('href',"/buildings/"+bid);

      wrap.appendChild(info);
      title.appendChild(close);
      info.appendChild(title);
      info.appendChild(body);

      urlDiv.appendChild(url);
      desc.appendChild(ellipsis);
      desc.appendChild(urlDiv);

      body.appendChild(desc);

      return wrap;
}