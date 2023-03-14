// 내장 객체

const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click" , function(){

    //Object
    const x1 = new Object();
    const x2 = {};

    console.log(x1 instanceof Object);
    console.log(x2 instanceof Object);

});


//Number
const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click" , function(){
    
    let n1 = 123;
    let n2 = Number(3.14);
    let n3 = new Number(777);

    console.log( n1 instanceof Number );
    console.log( n2 instanceof Number );
    console.log( n3 instanceof Number );

    console.log(typeof n1);
    console.log(typeof n2);
    console.log(typeof n3);
});

//String
const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click" , function(){
    
    let str1 = 'zzzz';
    let str2 = new String('zzzz');

    console.log(typeof str1);
    console.log(typeof str2);

    console.log(str1 instanceof String);
    console.log(str2 instanceof String);
    
});

//Date
const btn04 = document.querySelector("#btn04");
btn04.addEventListener("click" , function(){
    
    //객체 생성 방법
    const d1 = new Date(2002 , 5, 14, 20, 25, 30);

    console.log(d1);
    console.log(d1.getFullYear());
    console.log(d1.getMonth()+1);
    console.log(d1.getDate());
    console.log(d1.getDay());

});


