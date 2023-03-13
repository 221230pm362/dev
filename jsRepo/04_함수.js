function test01(){
    alert("test01 called...");
}

f = function(){
    alert("함수 호출됨 ...");
};

//자동 실행 함수
// (function(){
//     alert("자동실행함수 동작함 ~~~");
// })();

//화살표 함수
test04 = () => {
    alert("화살표 함수 ~~~");
}


//=========================
//매개변수
function test21(a , b){
    sum = a+b;
    alert(sum);
}

function test22(){
    sum = 0;
    for(let i = 0; i < arguments.length; i++){
        sum += arguments[i];
    }

    alert(sum);
}

function test31(){
    result = returnValue();
    console.log(result);
}

function returnValue(){
    return 100;
}



function test32(){
    result = returnFunc();
    console.log(result);
    result();
}

function returnFunc(){
    let temp = 777;
    return function(){alert(temp)}
}