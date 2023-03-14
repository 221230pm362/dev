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

    //객체와 반복문
    const btn03 = document.querySelector("#btn03");
    btn03.addEventListener("click" , function(){
        
        const p = {
            nick : "1dragon" ,
            age : 20 ,
            atk : 100 ,
            def : 50
        };

        // console.log(p.nick);
        // console.log(p.age);
        // console.log(p.atk);
        // console.log(p.def);

        for(let k in p){
            console.log(`${k} : ${p[k]}`);
        }

        // 객체의 value 는 iterable 하지 않으므로 접근 불가
        // for(let v of p){
        //     console.log(v);
        // }

    });

    //객체의 속성 추가 및 제거
    const btn04 = document.querySelector("#btn04");
    btn04.addEventListener("click" , function(){
        
        const p = {};

        p.atk = 123;
        p.def = 30;
        p['speed'] = 777;
        p.attack = () => {
            console.log("공격!!!");
        };

        delete(p.speed);

        console.log(p);
        p.attack();

    });

    //객체 배열
    const btn05 = document.querySelector("#btn05");
    btn05.addEventListener("click" , function(){
        
        const arr = [];

        const s1 = {name : '심원용' ,java : 100 ,sql : 100 ,};
        const s2 = {name : '심투용' ,java : 222 ,sql : 222 ,};
        const s3 = {name : '심삼용' ,java : 333 ,sql : 333 ,};

        // arr[0] = s1;
        // arr[1] = s2;
        // arr[2] = s3;

        arr.push({name : '심원용' ,java : 100 ,sql : 100 ,});
        arr.push(s2);
        arr.push(s3);

        console.log(arr);
    });

    //생성자 함수
     const btn06 = document.querySelector("#btn06");
     btn06.addEventListener("click" , function(){
        
        function Pokemon(name , atk, def){
            this.name = name;
            this.atk = atk;
            this.def = def;
            //메소드
            // this.getName = function(){
            //     return this.name;
            // };
            // this.setName = function(str){
            //     this.name = str;
            // };
        }//생성자 함수

        Pokemon.prototype.getName = function(){
            return this.name;
        };
        Pokemon.prototype.setName = function(str){
            this.name = str;
        };

        Pokemon.prototype.age = 20;
        Pokemon.prototype.name = '포켓몬기본이름';

        const x = new Pokemon("피카츄" , 100, 200);
        console.log(x);

        x.setName("파이리");
        console.log( x.getName() );

        console.log(x.__proto__.name);

        console.log("!!!!");
        console.log(Pokemon.name);

        // temp = Object.getPrototypeOf(x);
        // console.log(temp);

        // console.log("-------------");
        // console.log(Pokemon.prototype.name);
        // Pokemon.prototype.name = "zzz";
        // console.log(x.__proto__.name);  

     });

     //캡슐화
     const btn07 = document.querySelector("#btn07");
     btn07.addEventListener("click" , function(){
        
        function Person(n, a){
            let name = n;
            let age = a;

            this.getName = function(){return name;};
            this.setName = function(str){name = str};
        }

        const p = new Person("심원용" , 20);

        console.log(p);
        console.log( p.getName() );
        p.setName("심투용");
        console.log( p.getName() );

     });


}; //onload function
