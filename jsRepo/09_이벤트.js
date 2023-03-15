//고전 이벤트 모델
const btn1 = document.querySelector("#btn1");
btn1.onclick = function(){
    alert('고전 이벤트 모델 ~~~');
}

//표준 이벤트 모델
const btn3 = document.querySelector("#btn3");
btn3.addEventListener('click' , ()=>{
    alert('표준 이벤트 모델')
});


//이벤트가 발생한 요소에 접근
const btn4 = document.querySelector("#btn4");
btn4.addEventListener('click' , (event) => {

    console.log(window.event.target);
    console.log(this);

});



function checkPwd(){

    const pwdTag = document.querySelector("input[name=memberPwd]");
    

    if(pwdTag.value.length >= 4){
        return true;
    }else{
        alert("비밀번호가 너무 짧습니다.");
        return false;
    }
}


//기본 이벤트 막기
const t = document.querySelector("#t");
t.addEventListener('click' , function(event){

    const len = document.querySelector("#temp").value.length;

    if(len < 1){
        event.preventDefault();
    }

});


//이벤트 전파

const div01 = document.querySelector("#div01");
const div02 = document.querySelector("#div02");
const div03 = document.querySelector("#div03");

div01.addEventListener('click' , clickHandler , false);
div02.addEventListener('click' , clickHandler , false);
div03.addEventListener('click' , clickHandler , false);

function clickHandler(event){
    //console.log(event.target);
    console.log(event.currentTarget);
    //event.stopPropagation();
}