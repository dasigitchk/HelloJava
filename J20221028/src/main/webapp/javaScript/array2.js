fetch('./MemberListServlet') // method방식 지정안해주면 기본값인 get이됨.
    .then(result => result.json())
    .then(listShow)
    .catch(error => console.error(error));



    function listShow(data = []) {
        data.forEach(member => {
          if(member.resposibility == 'admin')
            console.log(member);
        })

        // 권한 user인 사람들만 userGroup 배열에 담기.
        let userGroup = [];
        //forEach 사용하면..
        data.forEach(member => {
            if(member.resposibility == 'user')
                userGroup.push(member);
        })
        //filter 사용하면..
        userGroup = data.filter(member => member.resposibility == 'user')
            
    }