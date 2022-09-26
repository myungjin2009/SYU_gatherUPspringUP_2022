<script src="http://code.jquery.com/jquery-latest.js"></script>
$(function(){
    if($("#pwForm").submit(function(){
        if($("#pw").val() !== $("#pw2").val()){
            alert("비밀번호가 다릅니다.");
            $("#pw").val("").focus();
            $("#pw2").val("");
            return false;
        }else if ($("#pw").val().length < 8) {
            alert("비밀번호는 8자 이상으로 설정해야 합니다.");
            $("#pw").val("").focus();
            return false;
        }else if($.trim($("#pw").val()) !== $("#pw").val()){
            alert("공백은 입력이 불가능합니다.");
            return false;
        }
    }));
})