// dom1.js
// 	DOM 활용해서 페이지 생성.

//document가 다운로드받아지면 제일마지막에 실행.
document.addEventListener('DOMContentLoaded', function() {

	//매개값으로 들어가는 태그 작성.
	let show = document.getElementById('show');
	let form = document.createElement('form');

//id.
	let txt = document.createTextNode('ID: ');
	let input = document.createElement('input');
	let br = document.createElement('br');
	input.setAttribute('type', 'text');
	input.setAttribute('id', 'id');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);
// name.
	txt = document.createTextNode('Name: ');
	input = document.createElement('input');
	input.setAttribute('type', 'text'); // input type="text"
	input.setAttribute('id', 'name');  // id="name"
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	//indext.html의 id값이 show인 div 안에있는 form이기 때문에.
	document.getElementById('show').appendChild(form);
	show.appendChild(form);
//phone.
	txt = document.createTextNode('Phone: ');
	input = document.createElement('input');
	input.setAttribute('type', 'text'); // input type="text"
	input.setAttribute('id', 'phone');  // id="name"
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);
//전송.
	input = document.createElement('input');
	input.setAttribute('type', 'submit');
	input.setAttribute('value', '전송');
	form.appendChild(input);
	show.appendChild(form);
})
