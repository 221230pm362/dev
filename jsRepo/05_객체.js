window.onload = function(){
    
    const h1 = document.querySelector("h1");
    
    h1.addEventListener("click", function(){
        alert("클릭 발생 ~~~");
    });


    // 객체 선언
    const btn01 = document.querySelector("#btn01");
    btn01.addEventListener("click", ()=>{
        console.log("객체 선언 테스트");

        //const x = new Object();
        const x = {
            name : '심원용' ,
            age : 20 ,
            hobby : ['메이플' , '스타', '롤'] ,
            hello : function(){alert("안녕");} ,
            "favorite!!!!@@@@?? color" : "black"
        };


        const str = "age";
        console.log(x);
        console.log(x['name']);
        console.log(x[str]);
        console.log(x['hobby']);
        console.log(x["favorite!!!!@@@@?? color"]);

    });

    //객체의 메소드
    const btn02 = document.querySelector("#btn02");
    btn02.addEventListener("click" , function(){

        const p = {
            nick : '심원용' ,
            age : 20 ,
            atk : 100 ,
            def : 50 ,
            attack : function(enemy){
                console.log(`${this.atk} 의 공격력으로 ${enemy} 을(를) 공격!`);
            }
        }

        p.attack('슬라임');

    });

};
