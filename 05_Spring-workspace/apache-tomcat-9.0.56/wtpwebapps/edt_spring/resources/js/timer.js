const timerContainer=document.querySelector(".js-clock"),
    timer=timerContainer.querySelector(".timer1");

function getTime() {
  const DDay = new Date("2022-01-25:10:00:00+0900");
  const now=new Date();
  const gap=DDay-now;
  const day=Math.floor(gap/(1000*60*60*24)); //일
  const hours=Math.floor((gap/(1000*60*60))%24); //시
  const minutes=Math.floor(((gap/1000)*60)%60); //분
  const seconds=Math.floor((gap/1000)%60); //초
  
  timer.innerText=`${day}d ${hours<10?`0${hours}`:hours}h ${minutes<10?`0${minutes}`:minutes}m ${seconds<10? `0${seconds}`:seconds}s`;
}

function init() {
    getTime();
    setInterval(getTime,1000);
}
init();

const timerContainer2=document.querySelector(".js-clock2"),
    timer2=timerContainer2.querySelector(".timer2");

    function getTime2() {
        const DDay2 = new Date("2022-01-26:10:00:00+0900");
        const now2=new Date();
        const gap2=DDay2-now2;
        const day2=Math.floor(gap2/(1000*60*60*24)); //일
        const hours2=Math.floor((gap2/(1000*60*60))%24); //시
        const minutes2=Math.floor(((gap2/1000)*60)%60); //분
        const seconds2=Math.floor((gap2/1000)%60); //초
        
        timer2.innerText=`${day2}d ${hours2<10?`0${hours2}`:hours2}h ${minutes2<10?`0${minutes2}`:minutes2}m ${seconds2<10? `0${seconds2}`:seconds2}s`;
      }
      
      function init2() {
          getTime2();
          setInterval(getTime2,1000);
      }
      init2();

const timerContainer3=document.querySelector(".js-clock3"),
timer3=timerContainer3.querySelector(".timer3");

    function getTime3() {
        const DDay3 = new Date("2022-01-27:10:00:00+0900");
        const now3=new Date();
        const gap3=DDay3-now3;
        const day3=Math.floor(gap3/(1000*60*60*24)); //일
        const hours3=Math.floor((gap3/(1000*60*60))%24); //시
        const minutes3=Math.floor(((gap3/1000)*60)%60); //분
        const seconds3=Math.floor((gap3/1000)%60); //초
        
        timer3.innerText=`${day3}d ${hours3<10?`0${hours3}`:hours3}h ${minutes3<10?`0${minutes3}`:minutes3}m ${seconds3<10? `0${seconds3}`:seconds3}s`;
      }
      
      function init3() {
          getTime3();
          setInterval(getTime3,1000);
      }
      init3();
