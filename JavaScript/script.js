console.log("Hello Rohit")
console.error("I am Error")
console.warn("I am giving you warning")
console.debug("Hello Do dubug")
// window.alert("Hello world!")
// window.prompt("Give me response")


var v = 10;
var c=v;

c=c+2;

console.log(v);
console.log(c);


var arr=[1,2,3,4,5];
var arr1=arr;
arr1.pop();             // make change in orginal value bcz we pass refernce
console.log(arr)


function print()
{
   console.log("I am a Functionn Statement")
}
print()


var func = function (){
console.log("hello i am function expression");
}
func()

var greet=function() {
console.log("hello");
}
greet()


var fun = () => {
    console.log("Fat Function");   
}
fun()

var fun = (a)=>{
    console.log("fat arrow with one param Fat Function"); 
}

fun(20);

var fun = ()=>"Genie Ashwani";

var res=fun();
console.log(res)


var arr=[1,2,"ashwani",[],function (){}]
console.log(arr[2])

var obj={
    name:"Rohit",
    "age":25,
    email:"Rohit@gmail",
    contact:"56789087654"
}

console.log(obj.name)

console.log(this);


function print()
{
    console.log(this);
}

print()
// method : in js we can say method which is inside object 
// ------------------------------------------------------
var obj ={
    name : function(){
        console.log(this);  //this.age
    },
    age:25

}
obj.name(); 


// function inside method(ES5)
// ----------------------------
var obj = {
    parent : function(){
        function child()
        {
            console.log(this); 
        }

        child();
    }
}

obj.parent();




function print()
{
    console.log(this);
}

var obj=new print();



document.querySelector("button")

.addEventListener("click",function(){
    console.log("i am clicked"); 
})


var obj={
    name:"ashwani"
}

function print1()
{
    console.log(this);
}

print1.call(obj)




var obj={
    name:"ashwani"
}

function print2(x,y,z)
{
    console.log(this,x,y,z);
}

print2.apply(obj,[1,2,3])

var obj={
    name:"ashwani"
}

function print3()
{
    console.log(this);
}

var func=print3.bind(obj)
func();



var btn=document.querySelector("button");
btn.textContent="Starting..."

var h1=document.querySelector('p');
// h1.textContent="hello"
h1.innerHTML='<i>Hello</i>'

var h1=document.querySelector('h1');
h1.style.color='red';
h1.style.fontFamily="Courier New";

// Ensure there is an element with the class 'h2' in your HTML
var h2=document.querySelector('.h2');
if (h2) {
    h2.classList.add('apna');
} else {
    console.error("No element with class 'h2' found.");
}
h2.classList.remove('apna')

var h1=document.createElement('h1');
h1.textContent="hello";
h1.classList.add("styl  e.css");
document.querySelector("body").appendChild(h1);


// var btn=document.querySelector("button");
// btn.addEventListener('click',function(){
//     alert("I got clicked")
// });