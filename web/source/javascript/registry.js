var check = document.querySelector('.check');
var flag = false;
check.onclick = function () {
    if(!flag){
        check.style.backgroundImage="url('source/images/blackArrowForRight.png')";
    }else{
        check.style.backgroundImage="url('')";
    }
    flag=!flag;
    console.log(flag);
}

var pwdContainer=document.querySelector('.pwd');
var input=pwdContainer.getElementsByTagName('input');
var pwd=input[0];
var tip=document.querySelector('.tip');
pwd.onblur=function(){
    if(this.value.length<4){
        tip.className='tip wrong';
        tip.innerHTML='你输入的密码太短了！';
    }
    else if(this.value.length>16){
        tip.className='tip wrong';
        tip.innerHTML='你输入的密码太长了！';
    }
    else{
        tip.className='tip right';
        tip.innerHTML='输入的密码正确！';
    }
}
