// covid.js

window.onload = function() {
    // request url.
    let url =
		'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=P9A%2BFFMphBZDZrCDOThlMbCDZ5V7LRIWq4VK8p0qLC43NQhzu9OE10URw5UB6GxGiekbmaOJtfe3SxedqibVew%3D%3D';
	fetch(url)
	.then(result => result.json())
	.then( showList )
	.catch( error => console.log(error));
    document.querySelector('#findBtn').addEventListener('click', findCenterList);
}
let titles = {
    id: '센터아이디', centerName: '센터명', phoneNumber: '연락처', lat:'위도', lng: '경도'
};
let data;

function resetList() {
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove());
   
}

function showList(result) {
    // 타이틀 생성.
    makeHead();
   
    // body 영역 생성. 데이터 초기화.
    console.log(result); 
    data = result.data;

    // option 태그 생성.
    // makeOption(data);

    // select태그 생성.
    let sidoAry = []; ['서울특별시', '인천광역시', '대전광역시', '대구광역시', '부산광역시', '경기도','경상도'];

    let selectedCity = data.filter(center => center.sido == '서울특별시'); 
    makeList(selectedCity);
}

function findCenterList() {
    let searchKey = document.querySelector('#city').value;
    let searchAry = data.filter(center => center.sido == searchKey);
    makeList(searchAry);
}

function makeList(ary = []) {
    // 화면에 tr이 있으면 tr삭제.
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove());
    let list = document.getElementById('list')
    ary.forEach(center => {
        list.append(makeTr(center));
    });
}

function makeTr(row = {}) {
    let tr = document.createElement('tr');
    tr.setAttribute('lng', row.lng);
    tr.setAttribute('lat', row.lat);
    tr.addEventListener('click', openInfoWindow);
    //td 생성.
    for(let field in titles) { // titles객체의 개수만큼 반복.
        let td = document.createElement('td');
        let txt = document.createTextNode(row[field]);
        td.appendChild(txt);
        tr.appendChild(td);
    }
    return tr;
}

function openInfoWindow(e) {
    console.log(e.target.parentElement); //이벤트를 받는대상  tr이 가지고있는 lng,lat을 알수있음.
    let lng = e.target.parentElement.getAttribute('lng');
    let lat = e.target.parentElement.getAttribute('lat');

    window.location.href = 'infoWindow.html?x='+lng+'&y='+lat; // url
}
function makeHead() {
     // 타이틀.
     let tr = document.createElement('tr');
     let th = document.createElement('th');
     for(let title in titles){
         let th = document.createElement('th');
         let txt = document.createTextNode(titles[title]);
         th.appendChild(txt);
         tr.appendChild(th);
     }
     document.getElementById('title').append(tr);
 
}

