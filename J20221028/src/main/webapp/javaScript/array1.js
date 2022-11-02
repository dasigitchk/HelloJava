// array1.js
fetch('data/MOCK_DATA.json')
.then(result => result.json() ) 
.then( composeFnc ) // 앞의 then 에서의 결과값이 showMain으로 넘ㅇ옴.
.catch( error => console.error(error) );


function composeFnc(result = []) { //result = [] 을 해줘야 .을 붙이면 가능한 기능들을 띄어줌.
    // 급여가 5000넘는 사람들만. filter 한 후에 새로운 모임.
    result.filter(row => row.salary > 5000)
        .map(row => {
            let team = {
                t_id: row.id,  //중괄호안에 바로 넣어도됨. 넣을땐 기호와 객체이름을 주의.
               t_name: row.first_name + '/' + row.last_name
            }  
            team.t_mail = row.email;
            team['t_dept'] = 'Account';

            return team;
        })
        .forEach(team => console.log(team));
}

// Array.map() => A - A'   mapping은 A형태의 데이터를 A'형태로 바꾸어주는것.
function mappingFnc(result = []) {
    let newAry = result.map( row => {
        let newObj = {};  // js에서 오브젝트선언은 중괄호를 써줌  = new Object(); 도 가능.
        newObj.user_id = row.id;
        newObj.user_name = row.first_name + '-' + row.last_name;
        newObj.info = row.email;

        return newObj;
    });

    newAry.forEach(obj => console.log(obj));
}

// Array.filter() => 매개함수의 반환값이 true인 요소들만 모아서 새로운 배열생성.
function filterFnc(result = []) {    
    let oddAry = result.filter((row, idx) => row.salary > 5000) // return이 true이면 oddAry에 담겨서 새로운배열이 된다.
              .forEach(row => console.log(row))
    // oddAry.forEach(row => console.log(row));
}


// Array.forEach() => 최종처리하는 기능 구현.
function showMain(result) {
    // console.log(result);
    result.forEach((row, idx) => {   //forEach는 값,인덱스,배열 3개 존재.
        // console.log(row)  //row 값이 뭔지 모를때 이렇게 출력해본다.
         if(row.gender == 'Female') {
            if(idx % 2 ==0){
            console.log(row.id, row.first_name, row.last_name, row.salary);
        } 
    }});
}

function sum(a=0,b=0) {
        return a+b;
}
console.log(sum(10)); // js에서는 변수개수가 안맞아도 에러가 아님.