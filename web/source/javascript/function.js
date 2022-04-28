// this is used to practice function
function getMax()
{
    var max=arguments[0];
    for(let i=1;i<arguments.length;i++)//arguments is the default collection of param that is inside the function
    {
        if(arguments[i]>max)
        {
            max=arguments[i];
        }
    }
    return max;
}

console.log(getMax(3,555,6,77,5,0));