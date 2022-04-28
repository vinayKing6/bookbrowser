var ul = document.querySelector('.items');
var items = ul.querySelectorAll('.itemsList');
var sub = document.querySelectorAll('.subList');
var showSub = document.querySelector('.showSub');
var title = ul.getElementsByClassName('title');
console.log(title);

for (let i = 0; i < items.length; i++) {
    items[i].onmouseover = function () {
        for(let j=0;j<sub.length;j++){
            sub[j].style.display='none';
        }

        sub[i].style.display='block';
        var itemsA = sub[i].getElementsByTagName('a');
        // console.log(itemsA);
        sub[i].style.animation= 'move .2s forwards';
        sub[i].style.backgroundColor='rgba(255,255,255,.9)'
        for(let j=0;j<itemsA.length;j++){
            itemsA[j].style.color='rgba(0,0,0,.8)';
        }
    }
    items[i].onmouseout = function () {
        items[i].style.color = 'black';
        sub[i].style.animation='back .2s forwards';
        // sub[i].style.zIndex='0';
        sub[i].style.display='none';
    }
}



function test() {
    var doc1 = document.getElementById('header');//get element by id
    console.log(doc1);
    console.dir(doc1);

    var divs = document.getElementsByTagName('div');//get all elements by tag name like 'div' and contains them in an array;
    var innerLis = divs[0].getElementsByTagName('li');//get all leave elements of divs[0] by tag name 'li';

    console.log(divs[0]);
    console.log(innerLis[0]);

    var firstBox = document.querySelector('.clearfix');//class need '.'
    console.log(firstBox);
    var allBoxes = document.querySelectorAll('.clearfix');
    console.log(allBoxes);
    var header = document.querySelector('#header');//id need '#'
    console.log(header);
    var list = document.querySelectorAll('li');
    console.log(list);

    var body = document.body;//get body
    var html = document.documentElement;//get html
    console.log(body);
    console.log(html);
}

function list(value, front, next) {
    this.value = value;
    this.front = front;
    this.next = next;
}

var btn = document.querySelector('.btn');
var time = document.querySelector('.time');
btn.onclick = function () {
    if (btn.innerHTML == '显示系统时间') {
        btn.innerHTML = '关闭系统时间';
        var date = new Date();
        time.innerHTML = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    }
    else {
        btn.innerHTML = '显示系统时间';
        time.innerHTML = null;
    }

}


function change_img() {
    var pressR = document.querySelector('.afterv');
    var pressL = document.querySelector('.prev');
    var imgContaner = document.querySelector('.image1');
    var img = imgContaner.getElementsByTagName('img');

    var math1 = new list('source/images/math1.png', null, null);
    var project1 = new list('source/images/project1.png', null, null);
    var psImage = new list('source/images/psImage.jpg', null, null);

    math1.next = project1;
    project1.next = psImage;
    project1.front=math1;
    psImage.next = math1;
    psImage.front=project1;
    math1.front=psImage;

    var position = math1;
    console.log(position.value);
    pressR.onclick = function () {
        position=position.next;
        img[0].src = position.value;
    }
    pressL.onclick = function () {
        position = position.front;
        img[0].src = position.value;
    }
}

change_img();


