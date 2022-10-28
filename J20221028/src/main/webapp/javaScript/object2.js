 object2.js


document.addEventListener('DOMContentLoaded', function() {
	//document.getElementById('show').innerHTML = '<p>Hello, World</p>'	
	let data = `[{"id":1,"first_name":"Caspar","last_name":"Fright","email":"cfright0@apache.org","gender":"Male","salary":8591},
{"id":2,"first_name":"Ewart","last_name":"Dono","email":"edono1@salon.com","gender":"Male","salary":3150},
{"id":3,"first_name":"Kylen","last_name":"Beltzner","email":"kbeltzner2@shinystat.com","gender":"Female","salary":2382},
{"id":4,"first_name":"Natalee","last_name":"Sudron","email":"nsudron3@discovery.com","gender":"Female","salary":4130},
{"id":5,"first_name":"Reinhold","last_name":"Lutsch","email":"rlutsch4@alibaba.com","gender":"Male","salary":1357},
{"id":6,"first_name":"Roi","last_name":"Pawel","email":"rpawel5@addtoany.com","gender":"Male","salary":7173},
{"id":7,"first_name":"Owen","last_name":"Pfeffle","email":"opfeffle6@zimbio.com","gender":"Bigender","salary":4294},
{"id":8,"first_name":"Kelley","last_name":"Windley","email":"kwindley7@themeforest.net","gender":"Female","salary":6851},
{"id":9,"first_name":"Willie","last_name":"Perello","email":"wperello8@google.com.hk","gender":"Female","salary":6493},
{"id":10,"first_name":"Emelia","last_name":"Jalland","email":"ejalland9@deliciousdays.com","gender":"Female","salary":2495}]`;

// json 타입 => javascript 오브젝트.

let result = JSON.parse(data);
console.log(result);

// for (String str : personList )
// <ul><li>obj</li></ul><ul><li>obj</li></ul>
// <div id= 'show'></div>
const fields = ['id', 'first_name', 'email', 'salary'];
let ulTag = document.createElement('talbe');  
for(row of result){
	ulTag.appendChild(makeTr(row));
}

document.getElementById('show').appendChild(ulTag);

function makeTr(obj) {
	
}

function makeList(obj)  {
	let liTag = document.createElement('li');
	let str = '';
	for (field of fields) {
		str += `${field}: ${obj[field]} `;
	}
	let txt = document.createTextNode(str);
	liTag.appendChild(txt);
	
	return liTag;
}
});

