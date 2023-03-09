function f01(){
    
    // var x = new Array();
    // var x = new Array(3);
    // var x = new Array("안녕" , "하세요", 20 , true);

    // var x = [];
    // var x = ["zzz", 111 , 3.14 , false];

    var x = [];
    x[0] = "키보드";
    x[1] = "마우스";
    x[3] = "모니터";
    console.log(x);

}

//indexOf
function test01(){
    var x = ['동' , '해' , '물', '과'];
    var result = x.indexOf('물');
    console.log(result);
}

//concat
function test02(){
    var x = ['동' , '해' , '물', '과'];
    var x2 = ['백' , '두' , '산', '이'];
    console.log(x);
    console.log(x2);
    
    var result = x.concat(x2)
    console.log(result);
}

//join
function test03(){
    var x = ['동' , '해' , '물', '과'];
    var result = x.join("@");
    console.log(result);
}

//reverse
function test04(){
    var x = ['동' , '해' , '물', '과'];
    x.reverse();
    console.log(x);
}

//sort
function test05(){
    var x = [1111, 22, 30, 7, 888];
    var result = x.sort(function f01(temp1, temp2){
        return temp2 - temp1;
    });
    console.log(result);
    console.log(x);
}

//push
function test06(){
    var x = ['동' , '해' , '물', '과'  , '물', '과'];
    x.push("백두산");
    console.log(x);

    var result = x.pop();
    console.log(result);
    console.log(x);
}

//shift
function test07(){
    // var x = ['동' , '해' , '물', '과'];
    // var result = x.shift();
    // console.log(result);
    // console.log(x);

    var x = ['동' , '해' , '물', '과' , 'zzz'];
    var result = x.unshift("카메라");
    console.log(result);
    console.log(x);
}

//slice
function test08(){
    // var x = ['동' , '해' , '물', '과'];
    // var result = x.slice(1 , 3);
    // console.log(result);
    // console.log(x);

    var x = ['동' , '해' , '물', '과', '백', '두'];
    var result = x.splice(2, 0, '글자' , '한개더');
    console.log(result);
    console.log(x);
}