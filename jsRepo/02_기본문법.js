//1. 변수와 자료형

//전역변수 선언
s = "전역변수ㅋㅋ"; 

//함수 외부에서 선언한 var 변수
var s2 = 'var 로 선언한 전역변수ㅋㅋ';

function f01(){
    
    var s = "지역변수ㅎㅎ";
    var s2 = "var 지역변수 ㅎㅎ";
    var s3;

    console.log(window.s);
    console.log(window.s2);
    console.log(window.s3);

    //-----------------------------------

    // var , let , const

    //var : 중복 선언 가능
    //let : 일반적인 변수
    //const : 재할당 불가능

    // const x = 10;
    // console.log(x);

    // x = 20;
    // console.log(x);


    console.log("--------------------");

    //2. 유효범위(스코프)
    // - 함수 안에서 var 키워드로 선언한 변수 : 함수 스코프
    // - 함수 안에서 let,const 키워드로 선언한 변수 : 블록 스코프

    if(true){
        const temp = 10;
        console.log(temp);
    }

    console.log(temp);

}

//f01();

// 자료형
function f02(){
    
    function testFunc(){
        let result = 10+20+30;
    }

    let x;

    console.log(x);
    console.log(typeof x);

}

//데이터 형변환
function f03(){

    //문자열 , 숫자
    var result = 'a' * 3;
    console.log(result);

    //강제 형변환
    var result = String(1) + 2;
    console.log(result);

    //연산자
    var a = 11;
    var b = '10';
    var result = a == b;
    console.log(result);

}

// 제어문
function f04(){
    let arr = [10, 20, 30];

    // for(let i = 0 ; i < 3; ++i){
    //     console.log(arr[i]);
    // }

    // for(let x in arr){
    //     console.log(arr[x]);
    // }

    for(x of arr){
        console.log(x);
    }
}
