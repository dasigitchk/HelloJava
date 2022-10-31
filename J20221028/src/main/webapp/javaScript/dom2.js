// dom2.js

document.addEventListener('DOMContentLoaded', domLoadedFunc); //DOMC~~ 이벤트 발생시 우측 함수를 실행.

function domLoadedFunc() {
	let data = `[{"id":1,"first_name":"Caspar","last_name":"Fright","email":"cfright0@apache.org","gender":"Male","salary":8591},
				 {"id":2,"first_name":"Ewart","last_name":"Dono","email":"edono1@salon.com","gender":"Male","salary":3150},
				 {"id":3,"first_name":"Kylen","last_name":"Beltzner","email":"kbeltzner2@shinystat.com","gender":"Female","salary":2382},
				 {"id":4,"first_name":"Natalee","last_name":"Sudron","email":"nsudron3@discovery.com","gender":"Female","salary":4130}
				]`;
	//중괄호로 객체선언?
	let obj = {}
	let result = JSON.parse(data); // json 형태의 data를 js의 object타입으로 변환하는것이 parse.
	console.log(result);

	console.log(result[1].email);
	for (let i = 0; i < result.length; i++) {
		console.log(`firstName: ${result[i].first_name}, lastName: ${result[i][`last_name`]}`);
	}
	//편한방식. 배열에 들어있는 개수만큼 반복 (확장for문 for of.)
	for (let obj of result) {
		console.log(`id: ${obj.id}, email : ${obj['email']}`)
	}

	console.clear();  //위 콘솔의 내용을 지워줌.
	// 배열일 경우에는 array.forEach(0 배열 result에 들어있는 갯수만큼 반복하는 메소드(매개값으로 함수가 들어감)
	result.forEach(function(value, index) {
		// if(value. salary > 5000)
		if (index < 2)
			console.log(value, index)
	});

	// table
	let table = document.createElement('table');
	let show = document.getElementById('show');
	show.appendChild(table);

	//thead
	let thead = document.createElement('thead');
	let tr = document.createElement('tr');
	let titles = ['아이디', '이름', '이메일', '성별', '급여', '삭제'];
	for (let title of titles) {
		let idTag = document.createElement('th');
		let idTxt = document.createTextNode(title); //<th>아이디</th>
		idTag.appendChild(idTxt);
		tr.appendChild(idTag);
	}
	// checkbox 생성.
	let td = document.createElement('th');
	let checkbox = document.createElement('input');
	checkbox.setAttribute('type', 'checkbox');
	checkbox.addEventListener('change', function() {
		let cks = document.querySelectorAll('#show input[type="checkbox"]');
		cks.forEach(function(check) {
			check.checked = checkbox.checked;
		});
	});
	td.appendChild(checkbox);
	tr.appendChild(td);

	thead.appendChild(tr);
	table.appendChild(thead);

	// tbody
	let tbody = document.createElement('tbody');
	table.appendChild(tbody);
	let fields = ['id', 'first_name', 'email', 'gender', 'salary'];
	for (let obj of result) {	// 데이터 건수만큼 반복
		let tr = makeTr(obj);
		tbody.appendChild(tr);
	}// end of for(let obj of result)

	/////////////////////////==Event==//////////////////////
	//추가버튼에 이벤트 등록.
	document.querySelector('button[type="button"]').addEventListener('click', addFunc);

	// 수정버튼에 이벤트 등록.
	document.querySelectorAll('button[type="button"]')[1].addEventListener('click', updateFunc);	 //두가지 버튼중 index번호에 맞는 버튼만선택.	

	// 선택삭제버튼에 이벤트 등록.
	document.querySelectorAll('button[type="button"]')[2].addEventListener('click', deleteFunc);	 //두가지 버튼중 index번호에 맞는 버튼만선택.

	/////////////////////////==/Event==//////////////////////	

	//////////////////////////==Function==////////////////////
	function addFunc() {
		consle.log('추가버튼....')
		let id = document.getElementById('id').value;
		let fn = document.getElementById('fname').value;
		let em = document.getElementById('email').value;
		let gn = document.getElementById('gender').value;
		let sa = document.getElementById('salary').value;
		let check = id && fn && em && sa && gn;
		if (!check) {
			alert('입력항목 확인');
			return;
		}
		let newRow = {
			id: id,
			first_name: fn,
			last_name: ln,
			salary: sa,
			gender: gn
		}
		document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));
	};

	function updateFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		let id = document.getElementById('id').value;
		console.log(trs);
		for (let i = 0; i < trs.length; i++) {
			if (id == trs[i].children[0].textContent) {
				trs[i].children[4].textContent = document.getElementById('salary').value;
				trs[i].children[3].textContent = document.getElementById('gender').value;
				trs[i].children[2].textContent = document.getElementById('email').value;
				trs[i].children[1].textContent = document.getElementById('fname').value;
			}
		}
	}

	function deleteFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		for (let i = 0; i < trs.length; i++) {
			if (trs[i].children[6].firstElementChild.checked) {
				trs[i].remove();
			}
		}
	}
	//////////////////////////==/Function==////////////////////

	// tr함수 생성.
	function makeTr(row) {
		let tr = document.createElement('tr');
		tr.addEventListener('mouseover', showDetailFunc)//마우스가 tr태그에 올라가면 function(){}실행.
		tr.addEventListener('click', displayFunc)
		tr.addEventListener('mouseout', function() {
			this.style.backgroundColor = null;
		})
		for (let field of fields) {
			// 항목만큼 반복.
			let td = document.createElement('td');
			let txt = document.createTextNode(row[field]);
			td.appendChild(txt);
			tr.appendChild(td);
		}
		// 삭제버튼. <button></button>
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.addEventListener('click', function() {
			console.log(this);
			this.parentElement.parentElement.remove(); //
		})
		let txt = document.createTextNode('삭제');
		td.appendChild(btn);
		btn.appendChild(txt);
		tr.appendChild(td);

		//선택버튼
		td = document.createElement('td');
		td.style.textAlign = 'center';
		let check = document.createElement('input');
		check.addEventListener('change', function() {

		});
		check.setAttribute('type', 'checkbox');
		td.appendChild(check);
		tr.appendChild(td);

		return tr;
	} // end of makeTr()

	function showDetailFunc() {
		this.style.backgroundColor = 'yellow';
	}

	function displayFunc() {
		document.getElementById('id').value = this.children[0].textContent;
		document.getElementById('fname').value = this.children[1].textContent;
		document.getElementById('email').value = this.children[2].textContent;
		document.getElementById('gender').value = this.children[3].textContent;
		document.getElementById('salary').value = this.children[4].textContent;
	}
}// end of (let obj of result)