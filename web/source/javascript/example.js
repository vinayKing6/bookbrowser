function say() {
    var age = 'nihao',
        name = 'hi',
        old = 9;
    console.log("hello world\n" + name + ' ' + old + age);
    console.log(typeof name + ' ' + typeof old);
    let Null=null;
    let noValue;
    console.log(typeof Null);
    console.log(typeof no);//also 'no' is undefined but it can't be used anywhere!
    console.log(typeof noValue);
    console.log("if null equals undefined? the answer is : "+(Null==noValue));//null equals undefined

    //Number
    let boolean=true;
    let False=false;
    console.log(String(Number(boolean))+'  '+String(Number(False)));
    console.log(typeof 55.9);
    console.log(0x1f+088);//十六进制0x...,八进制0...;x只能小写
    // console.log(false+false);此句输出的使两个boolean值相加的值
    console.log(8.0+' '+7.9);//自动把小数点后为0的浮点数转为整数
    console.log(2.4e-15);
    console.log(0.45+' '+0.000000009);//小数点超过6位会自动转换成科学计数法
    console.log(Number.MIN_VALUE);
    console.log(Number.POSITIVE_INFINITY);//正无穷
    console.log(Number.NEGATIVE_INFINITY);//负无穷
    console.log(0/0);//NaN:not a number
    console.log(5/0);//infinity
    console.log(-2/0);//-infinity
    console.log(NaN/99)//anything that have something to do with NaN is NaN
    console.log(NaN ==NaN);//NaN can't equals anything including NaN itself
    console.log(isNaN(NaN)+' '+isNaN('this')+' '+isNaN(4)+' '+isNaN(0/0)+' '+isNaN('20'));
    //judge if the value is a number or which can be turned into the number (like the String '20' but the String 'blue' is not permitted)
    let num1=Number('1.3');//force into float
    let num2=Number('2');
    let num3=Number('0019');
    let num4=Number('this');
    let num5=Number(' ');//this equals 0
    let num6=Number(true);//true equals 1 while false equals 0
    console.log(num1+' '+num2+' '+num3+' '+num4+' '+num5+' '+num6);
    let int1=parseInt(' ');//if the value starts with non-number then export NaN
    let int2=parseInt('1234blue');//follow the number until the first non-number
    let int3=parseInt('22.8');//cut the float into the int
    console.log(int1+' '+int2+' '+int3);

    //String:
    console.log('\u03a3');//print sigma
    let text='this a sigma:\u03a3';
    console.log(text.length);
    let number=11;
    console.log(number.toString(2));
    let html=`
    <div>
        <a href="#">
            <span>Jake</span>
        </a>
    </div>`;//模板
    console.log(html);
    let twoline=`
                first
                second`;
    console.log(twoline);
    let exponent='second';
    let value=5;
    let text2=`
        ${value} to the ${exponent} power is ${value*value}`;
    console.log(text2);
    console.log(`${capitalize('hello')},${capitalize('king!')}`);
}
say();
function capitalize(word)
{
    return `${word[0].toUpperCase()}${word.slice(1)}`;
}

function tagFunction(Strings,aValExpression,bValExpression,sumValExpression)
{
    console.log(Strings)
    console.log(aValExpression)
    console.log(bValExpression)
    console.log(sumValExpression)

    return 'foobar'
}

let a=8;
let b=9;

let untagged=`${a}+${b}=${a+b}`
let tagged=tagFunction`${a}+${b}=${a+b}`
console.log(`${untagged},${tagged}`);
console.log('\u00A9');
console.log(String.raw`\u00A9`);

function printRaw(strings,word)
{
    console.log(strings);
    console.log(word);
    console.log('actual strings:')
    for(const string of strings)
    {
        console.log(string);
    }

    console.log('raw strings:')
    for(const string of strings.raw)
    {
        console.log(string);
    }
}

printRaw`\uA009,${'hello'},\n`;

let symbol=Symbol('foo');
let symbol1=Symbol.for('foo');
let symbol2=Symbol.for('foo');
console.log(`${symbol==symbol1} ${symbol1==symbol2} ${symbol1.toString()}`)
console.log(`${Symbol.keyFor(symbol)} ${Symbol.keyFor(symbol1)}`)

let s1=Symbol('head'),
    s2=Symbol('body');//符号属性
let properties={
    [s1]:'head val',//符号属性要用[]
    [s2]:'body val',
    baz:'baz val',
    qux:'qux val'//普通属性
};//键值对
console.log(Object.getOwnPropertySymbols(properties));//输出符号属性键
console.log(Object.getOwnPropertyNames(properties));//输出普通属性键
console.log(Object.getOwnPropertyDescriptors(properties))
console.log(Reflect.ownKeys(properties));//输出所有键
console.log(properties[s1]);
let bazSymbol=Object.getOwnPropertySymbols(properties).find((symbol)=>{return symbol.toString().match(/head/)});
console.log(bazSymbol);
console.log(Object.getOwnPropertySymbols(properties).find((symbol)=>symbol.toString().match(/head/)));

for(let i=0;i<4;i++)
{
    console.log(i);
}



//let只作用在块作用域，即{}，var作用在一个函数作用域，并且let在一个作用域内（{}）不能重复声明，var可以重复声明
// 比如：function fun() {
//     var name='hi';
//     {
//         let old=9;
//         var year='1999-2-3';
//     }
//     console.log(old) error!;
//     console.log(year) permitted!;
// }

