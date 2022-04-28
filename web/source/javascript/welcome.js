var ul = document.querySelector('.items');
var items = ul.querySelectorAll('.itemsList');
var sub = document.querySelectorAll('.subList');
var showSub = document.querySelector('.showSub');
var title = ul.getElementsByClassName('title');
console.log(title);
ul.onmouseover = function () {
    for (let i = 0; i < title.length; i++) {

        title[i].style.color = 'bleck';
    }
    showSub.style.backgroundColor = '#f5f6f7';
    showSub.style.animation = 'grow .25s forwards';
}
ul.onmouseleave = function () {
    for (let i = 0; i < title.length; i++) {
        title[i].style.color = '#f5f6f7';
    }
    showSub.style.animation='reduce .25s forwards';
}
for (let i = 0; i < items.length; i++) {
    items[i].onmouseover = function () {
        var itemsA = sub[i].getElementsByTagName('a');
        console.log(itemsA);
        sub[i].style.animation= 'move .2s forwards';
        for(let j=0;j<itemsA.length;j++){
            itemsA[j].style.color='rgba(0,0,0,.4)';
        }
    }
    items[i].onmouseleave = function () {
        items[i].style.color = 'black';
        sub[i].style.animation='back .2s forwards';
    }
}