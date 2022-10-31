/**
 *  dom3.js
 */

document.addEventListener('DOMContentLoaded', function() {

	document.querySelector('button').addEventListener('click', function() {
		// 아이디 조회해서 화면에서 삭제.
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		let id = document.getElementByTagName('text').value;
		for(let i=0; i<trs.length; i++){

		}
	})

	let tableObject = {
		id: 'hong',
		titles: ["아이디", "이름", "이메일", "삭제"],
		data: [{id: 'user1', name: '홍길동', email: 'hong@email'},
			   {id: 'user2', name: '김민서', email: 'kim@email'},
				{id: 'user3', name: '박항서', email: 'park@email'}],
		addData: function(row) {
			this.data.push(row);
		},
		makeTable: function() {
			let table = document.createElement('table');
			let thead = this.makeHead();
			let tbody = this.makeBody();
			table.append(thead, tbody);
			return table;
		},
		makeHead: function() {
			let thead = document.createElement('thead');
			let tr = document.createElement('tr');
			this.titles.forEach(function(title) {
				let td = document.createElement('th');
				let txt = document.createTextNode(title);
				td.append(txt);
				tr.append(td);

			})
			thead.append(tr);
			return thead;
		},
		makeBody: function() {
			let tbody = document.createElement('tbody');
			this.data.forEach(val => {
				let tr = document.createElement('tr');
				tbody.append(tr);
				for (let field in val) {  // 개수만큼 반복.
					let td = document.createElement('td');
					let txt = document.createTextNode(val[field]);
					td.append(txt);
					tr.append(td);
				}
				// 삭제버튼. 클릭하면 한건 삭제.
					let delBtn = document.createElement('button');
					delBtn.addEventListener('click', function() {
						delBtn.parentElement.parentElement.remove();
					});
					let td = document.createElement('td');
					delBtn.textContent = '삭제';
					td.append(delBtn);
					tr.append(td);
			});
				return tbody;
		},
		init: function() {
			document.getElementsByTagName('body')[0].append(this.makeTable());
		}
	}
	// 데이터 추가.
	tableObject.addData({id: 'user4', name: '황선홍', email: 'hwang@emial'});
	tableObject.init();

}) // end of DOMContentLoaded.
