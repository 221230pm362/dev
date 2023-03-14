//window.open()
const btn1 = document.querySelector("#btn1");
btn1.addEventListener("click" , function(){
    
    //window.open();
    //window.open("https://www.naver.com");
    // window.open("https://www.naver.com" , 't1');

    window.open("https://www.naver.com" , 't1' , 'width=500' , 'height=800' , 'resizeable=no' );
});


//setTimeout
const btn2 = document.querySelector('#btn2');
btn2.addEventListener('click' , function(){
    
    const newWindow = window.open();
    newWindow.alert("3초 후 이 창은 종료됩니다.");
    
    const timer = setTimeout(()=>{
        newWindow.close();
    } , 5000);

    clearTimeout(timer);
})

//setInterval()
const btn3 = document.querySelector("#btn3");
btn3.addEventListener("click" , function(){
    
    timer = setInterval(() => {
        const d = new Date();
        console.log(d);
    }, 1000);

    
});

const btn4 = document.querySelector("#btn4");
btn4.addEventListener("click" , function(){
    clearInterval(timer);
});


//BOM

//location
const btn01 = document.querySelector("#btn01");
btn01.addEventListener('click' , function(){
    
    console.log(location);
    // location.assign("https://www.naver.com");
    location.replace("https://www.naver.com");

});

//navigator
const btn02 = document.querySelector("#btn02");
btn02.addEventListener('click' , function(){
    
    console.log(navigator);

});


