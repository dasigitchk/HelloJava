// shopItem.js

fetch('../../ShopItemListServlet')
.then( result => result.json() )
.then( itemListShow )
.catch( err => console.log(err) );

function itemListShow(result){
    console.log(result)
    result.forEach(item => {
        makeItemDiv(item);
    });
}
function makeItemDiv(item = {}) {
    let template = document.querySelector('#template>div');
    let good = template.cloneNode(true);
    good.querySelector('h5').textContent = item.itemName;
    good.querySelector('span.text-muted').textContent = item.originPrice;
  

    // add to cart 누르면 카트에 숫자증가.
    good.querySelector('a.btn').addEventListener('click', addCart);
    function addCart() {
  	 let num = Number(document.querySelector('nav.navbar>div>div>form>button>span.badge').textContent)+1;
  	 document.querySelector('nav.navbar>div>div>form>button>span.badge').textContent = num;
    }   
    
    //.nextSibling은 그 다음의 어떤것이든 가져옴?
    good.querySelector('span.text-muted').nextSibling.textContent = " " +item.salePrice;
    good.querySelector('img.card-img-top').src = '../../images/' + item.image;

    // 별점
    let review = item.likeIt; //  평점. 4.5  3.5 ...
    let a = Math.floor(review); //  완전한별.
    let b = review - a; // 0, .5  반쪽별.
    for(let i=0; i<a; i++) {
        let div = document.createElement('div');
        div.className = 'bi-star-fill'; // <div class='bi-star-fill'>
        good.querySelector('div.d-flex').append(div);

    }
    if(b) {
        let div = document.createElement('div');
        div.className = 'bi-star-half'; // <div class='bi-star-fill'>
        good.querySelector('div.d-flex').append(div);

    }
    good.querySelector('div.d-flex').append();

    // 목록.
    let parent = document.querySelector('section.py-5>div>div');
    parent.append(good);
    console.log(good);

}