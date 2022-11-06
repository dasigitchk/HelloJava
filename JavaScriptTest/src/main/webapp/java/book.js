// book.js

fetch('./BookListServlet')
.then(result => result.json() ) 
.then(bookList) 
.catch( error => console.error(error) );

function bookList(result){
    console.log(result);
////////////////===Event===/////////////////
//저장버튼 이벤트 등록.
document.querySelectorAll('button[type="button"]')[0].addEventListener('click', addFunc);

//삭제버튼 이벤트 등록.
document.querySelectorAll('button[type="button"]')[1].addEventListener('click', delFunc);
////////////////===Event===/////////////////

////////////////===function===/////////////////
	function addFunc() {
		console.log('추가버튼....')
		let code = document.getElementById('bookCode').value;
		let name = document.getElementById('bookName').value;
		let author = document.getElementById('author').value;
		let press = document.getElementById('press').value;
		let price = document.getElementById('price').value;
		let check = code && name && author && press && price;
		if (!check) {
			alert('입력항목 확인');
			return;
		}
		let newRow = {
			bookCode: code,
			bookName: name,
			author: author,
			press: press,
			price: price
		}
		document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));
		 //ajax 호출.
		 fetch('./BookAddServlet', {
					method: 'post',
					headers: {
						'Content-type': 'application/json'
					},
					body: newRow
			
			 })
			 	.then( result => result.json() )
				.then(addCallback)
				.catch(err => {
					console.log(err);
				});
				return false;
	};
	
	function addCallback(result) {
			console.log(result);
			document.querySelector('#list').append(makeTr(result));

			// 화면입력초기화.
			document.getElementById('bookCode').value = "";
			document.getElementById('bookName').value = "";
			document.getElementById('author').value = "";
			document.getElementById('press').value = "";
			document.getElementById('price').value = "";
		}
	
	function delFunc() {
		
	}
////////////////===function===/////////////////
// table
	let table = document.createElement('table');
	let show = document.getElementById('show');
	show.appendChild(table);

	//thead
	let thead = document.createElement('thead');
	let tr = document.createElement('tr');
	let titles = ['도서코드', '도서명', '저자', '출판사', '가격', '삭제'];
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
	tr.prepend(td);

	thead.appendChild(tr);
	table.appendChild(thead);

	// tbody
	let tbody = document.createElement('tbody');
	tbody.setAttribute('id', 'list');
	table.appendChild(tbody);
	let fields = ['bookCode', 'bookName', 'author', 'press', 'price'];
	for (let obj of result) {	// 데이터 건수만큼 반복
		let tr = makeTr(obj);
		tbody.appendChild(tr);
}
function makeTr(row) {
		let tr = document.createElement('tr');
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
		tr.prepend(td);

		return tr;
	}
}
