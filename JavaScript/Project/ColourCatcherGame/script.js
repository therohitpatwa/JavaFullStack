let targetColor="";
let score=0;
let time=30;
let timer;
let color=['red','orange','blue','green','black','grey','hotpink','purple','white','yellow','lightgreen','mahroon','khaki','brown','navy','indigo']
const grid=document.getElementById("grid");
const targetColorDisplay=document.getElementById("targetColor");
const scoreDisplay=document.getElementById("score");
const timeDisplay=document.getElementById("time")
function getRandomColor()
{

}
function startGame()
{
    score=0;
    time=30;
    scoreDisplay.textContent=score;
    timeDisplay.textContent=time;
    createGrid();
    clearInterval(timer);
    timer=setInterval(()=>{
        time--;
        timeDisplay.textContent=time;
        if(time===0)
        {
            clearInterval
        }
    },1000);


}