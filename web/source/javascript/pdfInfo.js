//prevent selection
document.addEventListener('selectstart',function(event){
    event.preventDefault();
})



//header
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

//tab
var tab_list=document.querySelector('.tab_list');
var list=tab_list.querySelectorAll('li');
var tab_items=document.querySelectorAll('.tab_item');

for(let i=0;i<list.length;i++){
    list[i].onclick=function(){
        for(let i=0;i<list.length;i++){
            list[i].className='';
            tab_items[i].style.display='none';
        }
        list[i].className='tab_current';
        tab_items[i].style.display='block';
    }
}

//append comment
let commentList=document.querySelector('.commentList');
let submit=document.querySelector('.submit');
let commentText=document.querySelector('.comment');
let userInfo=document.querySelector('.user');
let userName=userInfo.innerText;

submit.onclick=function(event){
    // event.preventDefault();
    event.stopPropagation();
    
    let text=commentText.value;
    if(text==''){
        alert('请输入评论！')
    }else{
        //get lastComment
        console.log(commentList.children.length)
        lastComment=commentList.children[0];
        let li=document.createElement('li');
        li.innerHTML='<span>'+userName+':</span>\n<div>\n'+text+'</div>';
        commentList.insertBefore(li,lastComment);
    }
}
