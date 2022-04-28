//array practice
var array1=new Array();//first way to create an array
array1.push('hi');
array1.push(12);
console.log(array1);

var array2=[1,'hi',33.4];
console.log(array2);
for(let a of array2)
{
    console.log(typeof a);
}


//select number that is bigger than 10
var array3=[1,55,7,33,5,99];
var select1=[];
for(let a of array3)
{
    if(a>=10)
    {
        select1.push(a);//you can change select1.length to change the length of the array
    }
}
console.log(select1.sort());


//delete the duplicate number in one array
var array4=[1,4,5,5,7,0,9,33,4,0,4,5,6,7,7,8,5,7,0,6];
var count=[];
for(let i=0;i<array4.length;i++)
{
    if(count[array4[i]]>=1)
    {
        count[array4[i]]++; 
    }
    else
    {
        count[array4[i]]=1;
    }
    if(count[array4[i]]>1)
    {
        console.log(array4[i]);
        array4[i]=array4[array4.length-1];
        array4.length--;
        i--;
    }
}
console.log(array4);
console.log(count);
console.log('fuck')



