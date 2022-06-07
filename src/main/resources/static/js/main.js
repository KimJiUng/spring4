
function data_create(){
    let name = $("#name").val();
    let phone = $("#phone").val();
    let memo = $("#memo").val();
    alert("저장");
    $.ajax({
        url : "create",
        data : {"name" : name, "phone" : phone, "memo" : memo},
        method : "POST",
        success : function(result){
            alert("RESTFUL crate 통신 "+result);
        }
    });
}

function data_read(){
    alert("호출");
    $.ajax({
        url : "read",
        method : "GET",
        success : function(result){
            let mlist = result;
            let html = "";
            html += '<table>';
            html += '<tr><th>no</th><th>name</th><th>phone</th><th>memo</th><tr>'
            for(let i=0; i<mlist.length; i++){
                html += '<tr><td>'+mlist[i]["no"]+'</td><td>'+mlist[i]["name"]+'</td><td>'+mlist[i]["phone"]+'</td><td>'+mlist[i]["memo"]+'</td></tr>';
            }
            html+='</table>';
            $("#membertable").html(html);
        }
    });
}

function data_update(){
    alert("수정");
    $.ajax({
        url : "update",
        method : "PUT",
        success : function(result){
            alert("RESTFUL update 통신 "+result);
        }
    });
}

function data_delete(){
    alert("삭제");
    $.ajax({
        url : "delete",
        method : "DELETE",
        success : function(result){
            alert("RESTFUL delete 통신 "+result);
        }
    });
}