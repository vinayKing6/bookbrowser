var obj=new Object();
obj.name="king";
obj.age=19;
obj.say=function(){
    console.log(this.name+" "+this.age+" ");
}
//first form of object
obj.say();

//second form of object:
function obj2(name,age,desc){
    this.name=name;
    this.age=age;
    this.desc=desc;
    this.say=function(){
        console.log(this.desc);
    }
}

var objsec=new obj2("vinay",2,"I am the king!");
objsec.say();
// third form of object

var objthrd={
    name: "king",
    age: 19,
    say: function(){
        console.log(this.name);
    }
}

objthrd.say();

//遍历对象的属性
for(var k in objsec){
    console.log(k);//print the name of key
    console.log(objsec[k]);//print the value of the key
}

//Math对象：
console.log(Math.PI);
console.log(Math.max(1,555,6));

function getRandom(min,max){
    return Math.floor(Math.random()*(max-min+1))+min;
}

console.log(getRandom(2,8));

//Date对象：
var today=new Date();
console.log(today);
var year=today.getFullYear();
var month=today.getMonth()+1;//starts from 0 to 11
var date=today.getDate();//today
var day=today.getDay()//sunday is 0
console.log(year+"-"+month+"-"+date+"-"+day+" "+today.getHours()+":"+today.getMinutes()+":"+today.getSeconds());

//Array对象：
var array=new Array(3);//create an Array which has 3 length
var array2=new Array(1,5,6);//create an Array [1,5,6]
console.log(array);
console.log(array2);

console.log(array instanceof Array);//judge if array is an Array type form 1
console.log(Array.isArray(array));//judge if array is an Array type form 2
console.log(2 instanceof Array);

var length=array2.push(9,8,7);//add 9,8,7 to the end of the Array and return the modified length of array
console.log(array2);
console.log(length);
length=array2.unshift(3,6);//add 3,6 to the start of the array and return the modified length
console.log(array2);
console.log(length);

console.log(array2.pop());//pop() delete the last element of the array and return the last element
console.log(array2);
console.log(array2.shift());//shift() delete the first element of the array and return the first element
console.log(array2);


//operation of array
var array3=[3, 1,7,8,5,0];
console.log("\n"+array3);
array3.reverse();//reverse the array
console.log(array3);
array3.sort();
console.log(array3);
array3.sort((a,b)=>b-a);
console.log(array3);

var value=['blue','red','blue','yellow'];
console.log(value.toString());
console.log(value.join('-'));
console.log(value.indexOf('blue'));//return the first index of the value in the array
console.log(value.lastIndexOf('blue'));//return the last index fo the value in the array
console.log(value.slice(0,3));//(return [start,end);
console.log(value.splice(0,3));//delete [0,3);
console.log(value);


//operation of string
var string='abcoefoxyozzopp';
function calculate(){
    this.index=[];
    this.num=0;
    this.update=function(index){
        this.index.push(index);
        this.num++;
    }
}
var calculate=new calculate();
var position=string.indexOf('o');

while(position!=-1&&position<string.length){
    calculate.update(position);
    position=string.indexOf('o',position+1);
}
console.log(calculate);

console.log(string.charAt(0));
console.log(string.charCodeAt(0));





