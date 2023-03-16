const trArr = document.querySelectorAll("tr");
const boardTable = document.querySelector("table#board");

// for(let tr of trArr){
//     tr.addEventListener("click" , function(){
//         alert(123);
//     });
// }

// trArr.forEach(function(tr){
//     tr.addEventListener("click", f);
// });



boardTable.addEventListener("click", f);

var f = function(event){
    const no_ = event.target.parentNode.children[0].innerHTML;
    const no = Number(no_);

    if(!isNaN(no)){
        alert(`선택하신 글 번호는 ${no} 번 입니다.`);
    }

}

